/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication;

import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.contentobjects.IMessageContentObject;
import de.matchbox.communication.enumeration.MessageType;

/**
 *
 * @author Pascal
 */
public class MessageObject {

    private MessageType nachrichtenTyp = MessageType.UNKOWN;
    private final IMessageContentObject contentObject;

    public MessageObject(MessageType pNachrichtenTyp, IMessageContentObject pContentObject) {
        this.nachrichtenTyp = pNachrichtenTyp;
        this.contentObject = pContentObject;
    }
    
    public MessageObject(MessageType pNachrichtenTyp) {
        this.nachrichtenTyp = pNachrichtenTyp;
        this.contentObject = null;
    }

    public MessageObject(ErrorContentObject pErrorObject) {
        this.nachrichtenTyp = MessageType.ERROR;
        this.contentObject = pErrorObject;
    }

    public MessageType getNachrichtenTyp() {
        return nachrichtenTyp;
    }

    public IMessageContentObject getContentObject() {
        return contentObject;
    }
}
