package com.example.coffee.exception;

public class NotFoundMemberException extends RuntimeException{
    private ErrorCode errorCode;

    public NotFoundMemberException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
