package de.matchbox.communication.contentobjects.client;

import de.matchbox.communication.contentobjects.IMessageContentObject;

public class LoginContentObject implements IMessageContentObject{
    private final String username;
    
    public LoginContentObject(String pUsername){
        this.username = pUsername;
    }

    public String getUsername() {
        return username;
    }
}
