package de.matchbox.communication.contentobjects.server;

import de.matchbox.communication.contentobjects.IMessageContentObject;
import de.matchbox.communication.shared.abiturklassen.List;

public class ListRoomsContentObject implements IMessageContentObject{
    private final List rooms;
            
    public ListRoomsContentObject(List pRoomList) {
        this.rooms = pRoomList;
    }

    public List getRooms() {
        return rooms;
    }
}
