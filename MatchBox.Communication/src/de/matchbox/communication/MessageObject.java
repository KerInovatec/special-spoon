/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication;

import de.matchbox.communication.contentobjects.ErrorContentObject;
import de.matchbox.communication.enumeration.MessageType;
import java.util.Map;

/**
 *
 * @author Pascal
 */
public class MessageObject {

    private final MessageType nachrichtenTyp;
    private final Map<String, String> contentObject;

    public MessageObject(MessageType pNachrichtenTyp, Map<String, String> pContentObject) {
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

    public Map<String, String> getContentObject() {
        return contentObject;
    }
}
