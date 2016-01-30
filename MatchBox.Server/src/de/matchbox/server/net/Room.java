package de.matchbox.server.net;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.CheckEquasionResultContentObject;
import de.matchbox.communication.contentobjects.roomcommands.EquasionContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ListPlayerContentObject;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;
import de.matchbox.communication.shared.abiturklassen.List;
import de.matchbox.server.StreichholzServer;
import de.matchbox.server.utility.ListUtility;

public class Room {

    private final int id;
    private final String name;
    private final List playerList;
    private String wrongEquasion = "**7+**8=**1";
    private String correctEquasion = "**7+**0=**7";

    public Room(int pId, String pName, Client pHost) {
        this.id = pId;
        this.name = pName;
        this.playerList = new List();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void process(RoomCommandContentObject pMessageObject, Client pClient, StreichholzServer pServer) {
        switch (pMessageObject.getCommand()) {
            case CHECK_EQUASION:
                this.checkEquasion(pMessageObject, pClient);
                break;
            case REQUEST_EQUASION:
                this.requestEquasion(pClient);
                break;
            case LIST_PLAYER:
                this.listPlayer(pClient, false);
                break;
            default:
                pServer.send(pClient, new Gson().toJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN_COMMAND))));
                break;
        }
    }

    private void listPlayer(Client pClient, boolean pHostChanged) {
        List lPlayerList = new List();

        this.playerList.toFirst();
        while (this.playerList.hasAccess()) {
            if (this.playerList.getObject() instanceof Player) {
                Player lPlayer = (Player) this.playerList.getObject();
                if (!lPlayer.getClient().equals(pClient)) {
                    lPlayerList.append(lPlayer.getModel());
                }
            }
            this.playerList.next();
        }

        if (!pHostChanged) {
            pClient.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LIST_PLAYER, new ListPlayerContentObject(lPlayerList)))));
        } else {
            pClient.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.HOST_CHANGED, new ListPlayerContentObject(lPlayerList)))));
        }
    }

    private void checkEquasion(RoomCommandContentObject pMessageObject, Client pClient) {
        if (pMessageObject.getContentObject() instanceof EquasionContentObject) {
            boolean lIsEquasionCorrect = ((EquasionContentObject) pMessageObject.getContentObject()).getEquasion().equals(this.correctEquasion);
            if(lIsEquasionCorrect){
                this.givePlayerPoint(pClient);
            }
            pClient.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.CHECK_EQUASION, new CheckEquasionResultContentObject(lIsEquasionCorrect)))));
        } else {
            pClient.send(new Gson().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
        }
    }
    
    private void givePlayerPoint(Client pClient){
        this.playerList.toFirst();
        while(this.playerList.hasAccess() && this.playerList.getObject() instanceof Player){
            Player lPlayer = (Player) this.playerList.getObject();
            if(lPlayer.getClient().equals(pClient)){
                lPlayer.setPoints(lPlayer.getPoints() + 1);
            }
            this.playerList.next();
        }
        this.sendPlayersToAll(false);
    }

    private void requestEquasion(Client pClient) {
        if (this.isClientHost(pClient)) {
            this.sendToAll(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION, new EquasionContentObject(this.wrongEquasion)))));
        } else {
            pClient.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION, new EquasionContentObject(this.wrongEquasion)))));
        }
    }

    private void onHostChanged() {
        this.sendPlayersToAll(true);
    }
    
    private void sendPlayersToAll(boolean pHostChanged){
        List lPlayerList = ListUtility.copyList(this.playerList);
        lPlayerList.toFirst();
        while (lPlayerList.hasAccess()) {
            this.listPlayer(((Player) lPlayerList.getObject()).getClient(), pHostChanged);
            lPlayerList.next();
        }
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

    public void deleteClient(Client pClient) {
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
                            this.onHostChanged();
                        }
                    }
                    return;
                }
            }
            this.playerList.next();
        }
    }

    public void addClient(Client pClient) {
        this.playerList.append(new Player(pClient, 0, false));
    }

    public void sendToAll(String pMessage) {
        this.playerList.toFirst();
        Object lCurObject;
        while (this.playerList.hasAccess() && (lCurObject = this.playerList.getObject()) instanceof Client) {
            ((Client) lCurObject).send(pMessage);
            this.playerList.next();
        }
    }
}
