package com.example.spring.exception;

public class CustomNotFoundException extends RuntimeException{
    public CustomNotFoundException(String msg) {
        super(msg);
    }
}
