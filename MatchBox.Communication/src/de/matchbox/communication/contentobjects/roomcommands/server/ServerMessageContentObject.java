package de.matchbox.communication.contentobjects.roomcommands.server;

import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;

public class ServerMessageContentObject implements IRoomCommandContentObject {

    private String username;
    private String message;

    public ServerMessageContentObject(String pUsername, String pMessage) {
        this.username = pUsername;
        this.message = pMessage;
    }

    public ServerMessageContentObject() {
        this("", "");
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
