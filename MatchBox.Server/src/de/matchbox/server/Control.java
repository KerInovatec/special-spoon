package de.matchbox.server;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.contentobjects.ErrorContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.server.abiturklassen.Server;
import de.matchbox.server.net.Client;

public class Control {

    private Control() {
    }

    public void process(MessageObject pMessageObject, Client pClient, Server pServer) {
        switch (pMessageObject.getNachrichtenTyp()) {
            case LOGIN:
                if (pMessageObject.getContentObject().containsKey("username")) {
                    pClient.setUsername(pMessageObject.getContentObject().get("username"));
                    pServer.send(pClient, new Gson().toJson(new MessageObject(MessageType.LOGIN)));
                } else {
                    pServer.send(pClient, new Gson().toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
                }
                break;
            case LOGOUT:
                break;
            case CREATE_ROOM:
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
