package de.matchbox.communication.contentobjects.roomcommands;

public class MessageContentObject implements IRoomCommandContentObject{
    private String message;

    public MessageContentObject(String pMessage) {
        this.message = pMessage;
    }

    public MessageContentObject() {
        this("");
    }
    
    public String getMessage() {
        return message;
    }
    
}
