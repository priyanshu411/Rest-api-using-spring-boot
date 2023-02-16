package com.example.demo.ApiExceptionHandler;

public class StudentNotFoundException extends Exception{
    private String message;

    public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public StudentNotFoundException() {

    }
}
