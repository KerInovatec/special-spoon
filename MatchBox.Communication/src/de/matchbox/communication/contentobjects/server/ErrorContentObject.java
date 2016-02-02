package de.matchbox.communication.contentobjects.server;

import de.matchbox.communication.contentobjects.IMessageContentObject;
import de.matchbox.communication.enumeration.ErrorType;

public class ErrorContentObject implements IMessageContentObject {

    private final ErrorType errorType;
    private String errorText;

    public ErrorContentObject(ErrorType pErrorType, String pErrorText) {
        this.errorType = pErrorType;
        this.errorText = pErrorText;
    }

    public ErrorContentObject(ErrorType pErrorType) {
        this.errorType = pErrorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getErrorText() {
        return errorText;
    }
}
