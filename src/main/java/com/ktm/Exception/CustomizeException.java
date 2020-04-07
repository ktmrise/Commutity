package com.ktm.Exception;

public class CustomizeException extends RuntimeException {
    private String message;


    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(CustomErrorCode errorCode) {
        this.message=errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
