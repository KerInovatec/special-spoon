package de.matchbox.communication.contentobjects.client;

import de.matchbox.communication.contentobjects.IMessageContentObject;

public class CreateRoomContentObject implements IMessageContentObject{
    private String name;

    public String getName() {
        return name;
    }
}
