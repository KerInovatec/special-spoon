package de.matchbox.server;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.ErrorContentObject;
import de.matchbox.communication.contentobjects.client.CreateRoomContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.server.net.Client;

public class Control {

    private Control() {
    }

    public void process(MessageObject pMessageObject, Client pClient, StreichholzServer pServer) {
        switch (pMessageObject.getNachrichtenTyp()) {
            case LOGIN:
                if (pMessageObject.getContentObject() instanceof LoginContentObject) {
                    pClient.setUsername(((LoginContentObject) pMessageObject.getContentObject()).getUsername());
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGIN)));
                } else {
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
                }
                break;
            case LOGOUT:
                if (pServer.logoutClient(pClient)) {
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGOUT)));
                } else {
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN))));
                }
                break;
            case CREATE_ROOM:
                if (!(pMessageObject.getContentObject() instanceof CreateRoomContentObject)) {
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
                }

                if (pServer.createRoom(new Room(((CreateRoomContentObject) pMessageObject.getContentObject()).getName()))) {
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.CREATE_ROOM)));
                } else {
                    pServer.send(pClient, new StandardGsonBuilder().create().toJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN))));
                }
                break;
            case JOIN_ROOM:
                break;
            case LEAVE_ROOM:
                break;
            case LIST_ROOMS:
                break;
            default:
                pServer.send(pClient.getIp(), pClient.getPort(), new Gson().toJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN_COMMAND))));
                break;
        }
    }

    public static void main(String[] args) {
        Control lControl = new Control();
        StreichholzServer lStreichholzServer1 = new StreichholzServer(1234, lControl);
    }
}
