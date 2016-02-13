package de.matchbox.server.net;

import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.CommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.EquasionContentObject;
import de.matchbox.communication.contentobjects.roomcommands.MessageContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.CheckEquasionResultContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.EquasionSolvedContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ListPlayerContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.PlayerWonContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ServerMessageContentObject;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;
import de.matchbox.communication.shared.abiturklassen.List;
import de.matchbox.server.StreichholzServer;
import de.matchbox.server.utility.ChatUtility;
import de.matchbox.server.utility.MatchUtility;
import java.util.Random;

public class Room {

    private String correctEquasion = "**7+**0=**7";
    private boolean equasionSolved = true;
    private int winningPoints = 10;

    private final int id;
    private String name;
    private final List playerList;
    private final StreichholzServer server;
    private String wrongEquasion = "**7+**8=**1";

    public Room(int pId, String pName, Client pHost, StreichholzServer pServer) {
        this.id = pId;
        this.name = pName;
        this.playerList = new List();
        this.playerList.append(new Player(pHost, 0, true));
        this.server = pServer;
        this.getNewEquasion();
    }

    public void addClient(Client pClient) {
        this.playerList.append(new Player(pClient, 0, false));
        this.sendPlayersToAll(RoomCommand.PLAYER_JOINED);
    }

    public boolean containsClient(Client pClient) {
        this.playerList.toFirst();
        while (this.playerList.hasAccess()) {
            if (this.playerList.getObject() instanceof Player) {
                Player lPlayer = (Player) this.playerList.getObject();
                if (lPlayer.getClient().equals(pClient)) {
                    return true;
                }
            }
            this.playerList.next();
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void getNewEquasion() {
        this.equasionSolved = false;
        do {
            int lNumber1 = new Random().nextInt(100);
            int lNumber2 = new Random().nextInt(100);
            int lSum = lNumber1 + lNumber2;
            char lEquasionTypeChar = '+';
            if (lNumber1 > lNumber2 && new Random().nextBoolean()) {
                lSum = lNumber1 - lNumber2;
                lEquasionTypeChar = '-';
            }
            this.correctEquasion = this.fillStringUp(String.valueOf(lNumber1), 3, '*', true) + lEquasionTypeChar + this.fillStringUp(String.valueOf(lNumber2), 3, '*', true) + "=" + this.fillStringUp(String.valueOf(lSum), 3, '*', true);
            this.wrongEquasion = MatchUtility.getWrongEquasion(this.correctEquasion);
        } while (this.wrongEquasion.isEmpty());
    }

    public boolean isClientHost(Client pClient) {
        this.playerList.toFirst();
        while (this.playerList.hasAccess()) {
            if (this.playerList.getObject() instanceof Player) {
                Player lPlayer = (Player) this.playerList.getObject();
                if (lPlayer.getClient().equals(pClient)) {
                    return lPlayer.isHost();
                }
            }
            this.playerList.next();
        }
        return false;
    }

    public void logoutPlayer(Client pClient) {
        this.deleteClient(pClient);
        pClient.setCurRoom(null);
        pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LEAVE_ROOM)));
    }

    public void process(RoomCommandContentObject pMessageObject, Client pClient, StreichholzServer pServer) {
        switch (pMessageObject.getCommand()) {
            case CHECK_EQUASION:
                this.checkEquasion(pMessageObject, pClient);
                break;
            case LIST_PLAYER:
                pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LIST_PLAYER, new ListPlayerContentObject(this.getPlayerModelList()))));
                break;
            case LEAVE_ROOM:
                this.logoutPlayer(pClient);
                break;
            case MESSAGE:
                this.processMessage(pMessageObject, pClient);
                break;
            case COMMAND:
                this.processCommand(pMessageObject, pClient);
                break;
            default:
                pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN_COMMAND)));
                break;
        }
    }

    public void onPlayerJoined(Client pClient) {
        pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION, new EquasionContentObject(this.wrongEquasion))));
    }

    private void processMessage(RoomCommandContentObject pContentObject, Client pClient) {
        if (!(pContentObject.getContentObject() instanceof MessageContentObject)) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! Nachricht nicht erkannt!"))));
            return;
        }

        this.sendMessageToAll((MessageContentObject) pContentObject.getContentObject(), pClient);
    }

    private void processCommand(RoomCommandContentObject pCommandContentObject, Client pClient) {
        if (!(pCommandContentObject.getContentObject() instanceof CommandContentObject)) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! Befehl nicht erkannt!"))));
            return;
        }

        CommandContentObject lCommandObject = (CommandContentObject) pCommandContentObject.getContentObject();
        if (lCommandObject.getMessageParts().length == 0) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! Befehl nicht erkannt!"))));
            return;
        }

        switch (lCommandObject.getMessageParts()[0]) {
            case "kick":
                this.kickPlayer(lCommandObject, pClient);
                break;
            case "help":
                pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.MESSAGE, new ServerMessageContentObject("Server", ChatUtility.getHelpText(this.isClientHost(pClient))))));
                break;
            case "set":
                this.setCommand(lCommandObject, pClient);
                break;
            case "start":
                break;
            case "takeHost":
                break;
            case "info":
                pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.MESSAGE, new ServerMessageContentObject("Server", "Room Information:\n" + "Roomname: " + this.name + "\nCurrent Host: " + this.getHost().getClient().getUsername() + "\nWinning Points: " + this.winningPoints))));
                break;
            default:
                pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! Befehl nicht erkannt!"))));
                break;
        }
    }

    private void kickPlayer(CommandContentObject pCommandContentObject, Client pClient) {
        if (pCommandContentObject.getMessageParts().length < 2 || pCommandContentObject.getMessageParts().length > 3) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Usage: " + ChatUtility.KickUsageText))));
            return;
        }

        if (!this.isClientHost(pClient)) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! You need to be Host to perform this command!"))));
            return;
        }

        Player lPlayer = this.getPlayer(pCommandContentObject.getMessageParts()[1]);
        if (lPlayer == null) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! Player '" + pCommandContentObject.getMessageParts()[1] + "' not found!"))));
            return;
        }
        lPlayer.getClient().setCurRoom(null);
        lPlayer.getClient().sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.SERVER_MESSAGE, new ServerMessageContentObject("Server", "You were kicked!" + (pCommandContentObject.getMessageParts().length == 3 ? " Reason: " + pCommandContentObject.getMessageParts()[2] : "")))));
        this.deleteClient(lPlayer.getClient());
    }

    private void setCommand(CommandContentObject pCommandContentObject, Client pClient) {
        if (pCommandContentObject.getMessageParts().length < 3 || pCommandContentObject.getMessageParts().length > 3) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Usage: " + ChatUtility.SetUsageText))));
            return;
        }

        if (!this.isClientHost(pClient)) {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! You need to be Host to perform this command!"))));
            return;
        }

        switch (pCommandContentObject.getMessageParts()[1]) {
            case "winningPoints":
                try {
                    this.winningPoints = Integer.parseInt(pCommandContentObject.getMessageParts()[2]);
                } catch (NumberFormatException ex) {
                    pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Error! Must specify Number!"))));
                }
                break;
            case "roomName":
                this.name = pCommandContentObject.getMessageParts()[2];
                break;
            default:
                pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.ERROR_MESSAGE, new ServerMessageContentObject("Server", "Usage: " + ChatUtility.SetUsageText))));
                break;
        }
    }

    private void checkEquasion(RoomCommandContentObject pMessageObject, Client pClient) {
        if (this.equasionSolved) {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.EQUASION_ALREADY_SOLVED)));
            return;
        }

        if (pMessageObject.getContentObject() instanceof EquasionContentObject) {
            String lEquasion = ((EquasionContentObject) pMessageObject.getContentObject()).getEquasion();
            boolean lIsEquasionCorrect = false;
            if (MatchUtility.canBeCreatedFromEquasion(this.wrongEquasion, lEquasion)
                    && (lIsEquasionCorrect = MatchUtility.isEquasionCorrect(lEquasion))) {
                this.equasionSolved = true;
                this.givePlayerPoint(pClient);
            }
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.CHECK_EQUASION, new CheckEquasionResultContentObject(lIsEquasionCorrect))));
        } else {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR)));
        }
    }

    private void deleteClient(Client pClient) {
        this.playerList.toFirst();
        while (this.playerList.hasAccess()) {
            if (this.playerList.getObject() instanceof Player) {
                Player lPlayer = (Player) this.playerList.getObject();
                if (lPlayer.getClient().equals(pClient)) {
                    this.playerList.remove();
                    if (lPlayer.isHost()) {
                        this.playerList.toFirst();
                        if (this.playerList.hasAccess()) {
                            ((Player) this.playerList.getObject()).setHost(true);
                            this.onPlayerLeft(true);
                        } else {
                            this.onPlayerLeft(true);
                        }
                    } else {
                        this.onPlayerLeft(false);
                    }
                    return;
                }
            }
            this.playerList.next();
        }
    }

    private String fillStringUp(String pString, int pMaxLength, char pFillChar, boolean prepend) {
        while (pString.length() < pMaxLength) {
            if (prepend) {
                pString = pFillChar + pString;
            } else {
                pString += pFillChar;
            }
        }
        return pString;
    }

    private Player getPlayer(String pUsername) {
        this.playerList.toFirst();
        while (this.playerList.hasAccess() && this.playerList.getObject() instanceof Player) {
            Player lPlayer = (Player) this.playerList.getObject();
            if (lPlayer.getClient().getUsername().equals(pUsername)) {
                return lPlayer;
            }
            this.playerList.next();
        }
        return null;
    }

    private Player getHost() {
        this.playerList.toFirst();
        while (this.playerList.hasAccess() && this.playerList.getObject() instanceof Player) {
            Player lPlayer = (Player) this.playerList.getObject();
            if (lPlayer.isHost()) {
                return lPlayer;
            }
            this.playerList.next();
        }
        return null;
    }

    private List getPlayerModelList() {
        List lPlayerList = new List();
        this.playerList.toFirst();
        while (this.playerList.hasAccess()) {
            if (this.playerList.getObject() instanceof Player) {
                lPlayerList.append(((Player) this.playerList.getObject()).getModel());
            }
            this.playerList.next();
        }
        return lPlayerList;
    }

    private void givePlayerPoint(Client pClient) {
        this.playerList.toFirst();
        while (this.playerList.hasAccess() && this.playerList.getObject() instanceof Player) {
            Player lPlayer = (Player) this.playerList.getObject();
            if (lPlayer.getClient().equals(pClient)) {
                lPlayer.setPoints(lPlayer.getPoints() + 1);
                if (lPlayer.getPoints() >= this.winningPoints) {
                    this.onPlayerWon(lPlayer);
                }
            }
            this.playerList.next();
        }
        this.onEquasionSolved(pClient);
    }

    private void onEquasionSolved(Client pClient) {
        this.sendToAll(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.EQUASION_SOLVED, new EquasionSolvedContentObject(pClient.getUsername(), this.getPlayerModelList()))));
        this.sendNewEquasionToAll();
    }

    private void onPlayerLeft(boolean pIsHost) {
        if (this.playerList.isEmpty()) {
            this.server.deleteRoom(this);
            return;
        }

        if (pIsHost) {
            this.sendPlayersToAll(RoomCommand.HOST_CHANGED);
        } else {
            this.sendPlayersToAll(RoomCommand.PLAYER_LEFT);
        }
    }

    private void onPlayerWon(Player pPlayer) {
        this.resetPoints();
        this.sendToAll(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.PLAYER_WON, new PlayerWonContentObject(pPlayer.getClient().getUsername(), this.getPlayerModelList()))));
        this.sendNewEquasionToAll();
    }

    private void sendNewEquasionToAll() {
        this.getNewEquasion();
        this.sendToAll(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION, new EquasionContentObject(this.wrongEquasion))));
    }

    private void resetPoints() {
        this.playerList.toFirst();
        while (this.playerList.hasAccess()) {
            Object lObject = this.playerList.getObject();
            if (lObject instanceof Player) {
                ((Player) lObject).setPoints(0);
            }
            this.playerList.next();
        }
    }

    private void sendMessageToAll(MessageContentObject pMessageContentObject, Client pClient) {
        this.sendMessageToAll(pMessageContentObject.getMessage(), pClient);
    }

    private void sendMessageToAll(String pMessage, Client pClient) {
        this.sendToAll(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.MESSAGE, new ServerMessageContentObject(pClient.getUsername(), pMessage))));
    }

    private void sendPlayersToAll(RoomCommand pRoomCommand) {
        this.sendToAll(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(pRoomCommand, new ListPlayerContentObject(this.getPlayerModelList()))));
    }

    private void sendToAll(String pMessage) {
        this.playerList.toFirst();
        Object lCurObject;
        while (this.playerList.hasAccess() && (lCurObject = this.playerList.getObject()) instanceof Player) {
            ((Player) lCurObject).getClient().send(pMessage);
            this.playerList.next();
        }
    }

    private void sendToAll(MessageObject pMessageObject) {
        this.sendToAll(new StandardGsonBuilder().create().toJson(pMessageObject));
    }

}
