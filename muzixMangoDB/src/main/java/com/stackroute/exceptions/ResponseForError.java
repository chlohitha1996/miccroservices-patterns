package com.stackroute.Exceptions;

public class ResponseForError {

    private String errorID;
    private String errorMessage;

    public String getErrorID() {
        return errorID;
    }

    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void callerID(final String requestURI) {
        this.errorID = requestURI;
    }
}