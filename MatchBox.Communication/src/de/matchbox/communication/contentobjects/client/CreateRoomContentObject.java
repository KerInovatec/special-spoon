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
public class CreateRoomContentObject implements IMessageContentObject{
    private String name;

    public String getName() {
        return name;
    }
}
