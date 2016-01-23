/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects;

import de.matchbox.communication.enumeration.ErrorType;
import java.util.HashMap;

/**
 *
 * @author Pascal
 */
public class ErrorContentObject extends HashMap<String,String>{
    
    public ErrorContentObject(ErrorType pErrorType, String pErrorText){
        this.put("error_type", pErrorType.name());
        this.put("error_text", pErrorText);
    }
    
    public ErrorContentObject(ErrorType pErrorType){
        this.put("error_type", pErrorType.name());
    }
}
