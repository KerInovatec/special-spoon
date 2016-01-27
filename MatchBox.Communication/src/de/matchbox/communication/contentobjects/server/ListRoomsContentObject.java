/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects.server;

import de.matchbox.communication.contentobjects.IMessageContentObject;
import de.matchbox.communication.shared.abiturklassen.List;

/**
 *
 * @author Pascal
 */
public class ListRoomsContentObject implements IMessageContentObject{
    private final List rooms;
            
    public ListRoomsContentObject(List pRoomList) {
        this.rooms = pRoomList;
    }

    public List getRooms() {
        return rooms;
    }
}
