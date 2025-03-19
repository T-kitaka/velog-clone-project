package com.spring.velogcloneproject.common.exception;

public enum ErrorCode implements CodeInterface {
    USER_ALREADY_EXISTS(-1, "USER_ALREADY_EXISTS"),
    USER_SAVED_FAILED(-2, "USER_SAVED_FAILED");
//    NOT_EXISTS_USER(-3, "NOT_EXISTS_USER"),
//    MISS_MATCH_PASSWORD(-4, "MISS_MATCH_PASSWORD");

    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
