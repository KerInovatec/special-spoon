package de.matchbox.communication.contentobjects.client;

import de.matchbox.communication.contentobjects.IMessageContentObject;

public class JoinRoomContentObject implements IMessageContentObject {

    private int roomId;

    public JoinRoomContentObject() {
    }
    public JoinRoomContentObject(int pRoomID) {
        this.roomId = pRoomID;
    }

    public int getRoomId() {
        return roomId;
    }
}
