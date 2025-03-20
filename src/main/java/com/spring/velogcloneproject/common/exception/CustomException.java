package com.spring.velogcloneproject.common.exception;

public class CustomException extends RuntimeException {

    private final CodeInterface codeInterface;

    public CodeInterface getUserExceptionInterFace() {
        return codeInterface;
    }

    public CustomException(CodeInterface v) {
        super(v.getMessage());
        this.codeInterface = v;
    }

    public CustomException(CodeInterface v, String message) {
        super(v.getMessage() + message);
        this.codeInterface = v;
    }
}
