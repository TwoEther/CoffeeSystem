package com.example.coffee.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    NOT_FOUND_USER_ID(HttpStatus.NOT_FOUND, "U-001", "해당 유저를 찾을 수 없습니다."),
    ALREADY_REGISTERED_USER_ID(HttpStatus.BAD_REQUEST, "U-004", "이미 존재하는 유저 아이디입니다.");



    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
