package com.ktm.Exception;

public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;


    public CustomizeException(CustomErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
