package com.example.demo.ApiExceptionHandler;

public class ResourceNotFoundException extends Exception{
    private String message;
    private int id;

    public ResourceNotFoundException(int id, String message) {
        super(message);
        this.message = message;
        this.id=id;
    }

    public ResourceNotFoundException() {

    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }
}
