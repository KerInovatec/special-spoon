package de.streichholzprojekt.server;

import de.streichholzprojekt.server.enumeration.MessageType;
import de.streichholzprojekt.server.net.Client;

public class Control {

    private final StreichholzServer server;

    private Control() {
        this.server = new StreichholzServer(1234, this);
    }

    public void process(MessageType pType, String[] pMessage, Client pClient) {
        switch (pType) {
            case LOGIN:
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
                this.server.send(pClient.getIp(), pClient.getPort(), "ERR UNKOWN_COMMAND");
                break;
        }
    }

    public static void main(String[] args) {
        Control lControl = new Control();
    }
}
