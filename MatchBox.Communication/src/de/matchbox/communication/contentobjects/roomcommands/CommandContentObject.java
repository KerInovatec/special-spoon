package de.matchbox.communication.contentobjects.roomcommands;

public class CommandContentObject implements IRoomCommandContentObject{
    private String[] messageParts;

    public CommandContentObject(String[] pMessageParts) {
        this.messageParts = pMessageParts;
    }

    public CommandContentObject() {
        this(new String[0]);
    }
    
    public String[] getMessageParts() {
        return messageParts;
    }
    
}
