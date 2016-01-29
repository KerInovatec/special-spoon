package de.matchbox.server;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.contentobjects.client.CreateRoomContentObject;
import de.matchbox.communication.contentobjects.client.JoinRoomContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.contentobjects.server.ListRoomsContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.server.net.Client;
import de.matchbox.server.net.Room;

public class Control {

    private Control() {
    }

    public void process(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
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
            case LEAVE_ROOM:
                this.leaveRoom(pClient, pServer);
                break;
            case LIST_ROOMS:
                pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LIST_ROOMS, new ListRoomsContentObject(pServer.getRoomModelList()))));
                break;
            case ROOM_CMD:
                break;
            default:
                pServer.send(pClient.getIp(), pClient.getPort(), new Gson().toJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN_COMMAND))));
                break;
        }
    }

    private void loginClient(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        if (pMessageObject.getContentObject() instanceof LoginContentObject) {
            pClient.setUsername(((LoginContentObject) pMessageObject.getContentObject()).getUsername());
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGIN)));
        } else {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
        }
    }

    private void logoutClient(Client pClient, StreichholzServer pServer) {
        if (pServer.logoutClient(pClient)) {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGOUT)));
        } else {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN))));
        }
    }

    private void createRoom(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        if (!(pMessageObject.getContentObject() instanceof CreateRoomContentObject)) {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
        }

        if (pServer.createRoom(((CreateRoomContentObject) pMessageObject.getContentObject()).getName())) {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.CREATE_ROOM)));
        } else {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.ROOM_EXISTS))));
        }
    }

    private void joinRoom(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        if (!(pMessageObject.getContentObject() instanceof JoinRoomContentObject)) {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
        }

        int lRoomId = ((JoinRoomContentObject) pMessageObject.getContentObject()).getRoomId();
        Room lRoom = pServer.getRoom(lRoomId);
        if (lRoom == null) {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.ROOM_NOT_FOUND))));
        } else {
            lRoom.addClient(pClient);
            pClient.setCurRoom(lRoom);
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.JOIN_ROOM)));
        }
    }

    private void leaveRoom(Client pClient, StreichholzServer pServer) {
        Room lRoom = pClient.getCurRoom();
        if (lRoom == null) {
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.NOT_IN_ROOM))));
        } else {
            lRoom.deleteClient(pClient);
            pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LEAVE_ROOM)));
        }
    }

    public static void main(String[] args) {
        Control lControl = new Control();
        StreichholzServer lStreichholzServer1 = new StreichholzServer(1234, lControl);
    }
}
