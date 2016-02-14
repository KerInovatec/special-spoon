package de.matchbox.server;

import de.matchbox.communication.MessageObject;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.client.CreateRoomContentObject;
import de.matchbox.communication.contentobjects.client.JoinRoomContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.contentobjects.server.ListRoomsContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.server.net.Client;
import de.matchbox.server.net.Room;

public class Control {

    public static void main(String[] args) {
        Control lControl = new Control();
        StreichholzServer lStreichholzServer1 = new StreichholzServer(1234, lControl);
        lControl.log("Der Server wurde gestartet. Port: " + lStreichholzServer1.getPort());
    }

    private Control() {
    }

    public void err(String errMsg) {
        System.err.println(errMsg);
    }

    public void log(String message) {
        System.out.println(message);
    }

    public void process(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        log("Erhaltene Nachricht:" + pMessageObject.getNachrichtenTyp());

        switch (pMessageObject.getNachrichtenTyp()) {
            case LOGIN:
                this.loginClient(pMessageObject, pClient, pServer);
                break;
            case LOGOUT:
                this.logoutClient(pClient, pServer);
                break;
            case CREATE_ROOM:
                this.createRoom(pMessageObject, pClient, pServer);
                break;
            case JOIN_ROOM:
                this.joinRoom(pMessageObject, pClient, pServer);
                break;
            case LIST_ROOMS:
                pClient.sendJson(new MessageObject(MessageType.LIST_ROOMS, new ListRoomsContentObject(pServer.getRoomModelList())));
                break;
            case ROOM_CMD:
                this.processRoomCommand(pMessageObject, pClient, pServer);
                break;
            default:
                pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN_COMMAND)));
                break;
        }
    }

    private void createRoom(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        if (!(pMessageObject.getContentObject() instanceof CreateRoomContentObject)) {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR)));
            return;
        }

        Room lRoom;
        if ((lRoom = pServer.createRoom(((CreateRoomContentObject) pMessageObject.getContentObject()).getName(), pClient)) != null) {
            pClient.sendJson(new MessageObject(MessageType.CREATE_ROOM));
            lRoom.onPlayerJoined(pClient);
        } else {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.ROOM_EXISTS)));
        }
    }

    private void joinRoom(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        if (!(pMessageObject.getContentObject() instanceof JoinRoomContentObject)) {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR,"Parse Error")));
            return;
        }

        int lRoomId = ((JoinRoomContentObject) pMessageObject.getContentObject()).getRoomId();
        Room lRoom = pServer.getRoom(lRoomId);
        if (lRoom == null) {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.ROOM_NOT_FOUND,"Room not found")));
        } else {
            lRoom.addClient(pClient);
            pClient.setCurRoom(lRoom);
            pClient.sendJson(new MessageObject(MessageType.JOIN_ROOM));
            lRoom.onPlayerJoined(pClient);
        }
    }

    private void loginClient(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        log(pClient.toString() + " verbunden.");
        if (pMessageObject.getContentObject() instanceof LoginContentObject) {
            String lUsername = ((LoginContentObject) pMessageObject.getContentObject()).getUsername();
            if (pServer.containsName(lUsername)) {
                log(pClient.toString() + "abgelehnt: Name bereits vorhanden.");
                pClient.sendJson(new MessageObject(MessageType.ERROR, new ErrorContentObject(ErrorType.USERNAME_TAKEN,"The Username is taken")));
            } else {
                log(pClient.toString() + "wurde akzeptiert.");
                pClient.setUsername(lUsername);
                pClient.sendJson(new MessageObject(MessageType.LOGIN));
            }
        } else {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR)));
        }
    }

    private void logoutClient(Client pClient, StreichholzServer pServer) {
        if (pServer.logoutClient(pClient)) {
            if (pClient.getCurRoom() != null) {
                pClient.getCurRoom().logoutPlayer(pClient);
            }
            pClient.sendJson(new MessageObject(MessageType.LOGOUT));
        } else {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN)));
        }
    }

    private void processRoomCommand(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        if (pClient != null && pClient.getCurRoom() != null) {
            if (!(pMessageObject.getContentObject() instanceof RoomCommandContentObject)) {
                pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR)));
            } else {
                pClient.getCurRoom().process((RoomCommandContentObject) pMessageObject.getContentObject(), pClient, pServer);
            }
        } else if (pClient != null && pClient.getCurRoom() == null) {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.NOT_IN_ROOM)));
        }
    }

}
