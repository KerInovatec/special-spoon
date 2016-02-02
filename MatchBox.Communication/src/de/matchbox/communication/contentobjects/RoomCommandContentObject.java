package de.matchbox.communication.contentobjects;

import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import de.matchbox.communication.enumeration.RoomCommand;

public class RoomCommandContentObject implements IMessageContentObject {

    private RoomCommand command = RoomCommand.UNKOWN;
    private IRoomCommandContentObject contentObject;

    public RoomCommandContentObject() {

    }

    public RoomCommandContentObject(RoomCommand pCommand) {
        this.command = pCommand;
    }

    public RoomCommandContentObject(RoomCommand pCommand, IRoomCommandContentObject pContentObject) {
        this.command = pCommand;
        this.contentObject = pContentObject;
    }

    public RoomCommand getCommand() {
        return command;
    }

    public IRoomCommandContentObject getContentObject() {
        return contentObject;
    }
}
