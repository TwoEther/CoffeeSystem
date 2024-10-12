package com.example.coffee.exception;

import lombok.Getter;

@Getter
public class DuplicateMemberException extends RuntimeException{
    private ErrorCode errorCode;

    public DuplicateMemberException(String message, ErrorCode errorCode) {
        super(errorCode.getErrorCode());
        this.errorCode = errorCode;
    }
}
