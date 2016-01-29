/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects.client;

import de.matchbox.communication.contentobjects.IMessageContentObject;

/**
 *
 * @author Pascal
 */
public class JoinRoomContentObject implements IMessageContentObject {

    private int roomId;

    public JoinRoomContentObject() {
    }
    public JoinRoomContentObject(int roomID) {
    }

    public int getRoomId() {
        return roomId;
    }
}
