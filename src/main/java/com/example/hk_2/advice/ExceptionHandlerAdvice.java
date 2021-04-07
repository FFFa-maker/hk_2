package com.example.hk_2.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> f(UserException e){
        return ResponseEntity.badRequest().body("400:"+e.getKind());
    }
}