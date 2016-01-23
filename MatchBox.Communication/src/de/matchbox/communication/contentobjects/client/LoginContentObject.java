/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects.client;

import java.util.HashMap;

/**
 *
 * @author Pascal
 */
public class LoginContentObject extends HashMap<String, String>{
    
    public LoginContentObject(String pUsername){
        this.put("username", pUsername);
    }
}
