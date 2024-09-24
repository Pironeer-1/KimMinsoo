package com.example.mytemplatecode.global.exception;

public class CustomException extends RuntimeException {
    private Exception originException;
    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(Exception originException, ErrorCode errorCode) {
        this.originException = originException;
        this.errorCode = errorCode;
    }
}
