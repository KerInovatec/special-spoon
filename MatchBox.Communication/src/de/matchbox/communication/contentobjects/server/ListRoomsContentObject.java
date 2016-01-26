/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects.server;

import de.matchbox.communication.contentobjects.IMessageContentObject;
import java.util.Map;

/**
 *
 * @author Pascal
 */
public class ListRoomsContentObject implements IMessageContentObject{
    private final Map<Integer, String> rooms;
            
    public ListRoomsContentObject(Map<Integer, String> pRoomList) {
        this.rooms = pRoomList;
    }

    public Map<Integer, String> getRooms() {
        return rooms;
    }
}
