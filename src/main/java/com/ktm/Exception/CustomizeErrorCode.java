package com.ktm.Exception;

public enum CustomizeErrorCode implements CustomErrorCode {

    QUESTION_NOT_FOUND("你访问的问题不存在了");
    private String message;


    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
