package com.portalnfsolution.exception;

/**
 * Created by felipe.simmi on 23/09/2017.
 */
public class CustomErrorType {

    private String errorMessage;


    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
