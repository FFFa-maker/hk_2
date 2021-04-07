package com.example.hk_2.advice;


public class UserException extends RuntimeException{
    private String kind;
    public UserException(String kind){
        this.kind = kind;
    }
    public String getKind() {
        return kind;
    }
}
