package com.example.coffee.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateMemberException.class)
    protected ResponseEntity<ErrorResponseEntity> handleDuplicateMemberException(DuplicateMemberException e) {
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }
}
