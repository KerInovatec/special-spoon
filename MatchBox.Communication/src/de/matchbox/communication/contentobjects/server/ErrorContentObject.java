/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.matchbox.communication.contentobjects.server;

import de.matchbox.communication.contentobjects.IMessageContentObject;
import de.matchbox.communication.enumeration.ErrorType;

/**
 *
 * @author Pascal
 */
public class ErrorContentObject implements IMessageContentObject{
    private final ErrorType errorType;
    private String errorText;
    
    public ErrorContentObject(ErrorType pErrorType, String pErrorText){
        this.errorType = pErrorType;
        this.errorText = pErrorText;
    }
    
    public ErrorContentObject(ErrorType pErrorType){
        this.errorType = pErrorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getErrorText() {
        return errorText;
    }
}
