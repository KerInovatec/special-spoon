/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects;

import de.matchbox.communication.contentobjects.roomcmd.IRoomCommandContentObject;
import de.matchbox.communication.enumeration.RoomCommand;

/**
 *
 * @author Pascal
 */
public class RoomCommandContentObject implements IMessageContentObject{
    private RoomCommand command = RoomCommand.UNKOWN;
    private IRoomCommandContentObject contentObject;
    
    public RoomCommandContentObject(){
        
    }
    
    public RoomCommandContentObject(RoomCommand pCommand){
        this.command = pCommand;
    }
    
    public RoomCommandContentObject(RoomCommand pCommand, IRoomCommandContentObject pContentObject){
        this.command = pCommand;
        this.contentObject = pContentObject;
    }
}
