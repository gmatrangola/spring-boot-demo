package com.matrangola.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<ResourceErrorResponse> resourceNotFound(ResourceException e) {
        ResourceErrorResponse response = e.getResourceErrorResponse();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
