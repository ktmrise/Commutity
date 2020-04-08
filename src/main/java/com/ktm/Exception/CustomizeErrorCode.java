package com.ktm.Exception;

public enum CustomizeErrorCode implements CustomErrorCode {

    QUESTION_NOT_FOUND(2001, "你访问的问题不存在了"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "当前操作需要登录，请登录后重试") ,
    SYS_ERROR(2004  , "服务冒烟了，要不等一下再试试"),
    TYPE_PARAM_WRONG(2005  , "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2005  , "回复的评论不存在了");
    private String message;
    private Integer code;



    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;

    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
