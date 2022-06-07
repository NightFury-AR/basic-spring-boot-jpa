package com.basicjpaweb.basicjpaweb.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleException(IllegalStateException e) {
        return new ResponseEntity<Object>("Something went wrong !!!", HttpStatus.NOT_FOUND);
    }

}
