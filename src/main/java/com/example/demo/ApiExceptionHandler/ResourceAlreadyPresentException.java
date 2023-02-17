package com.example.demo.ApiExceptionHandler;

public class ResourceAlreadyPresentException extends Exception{
    private int id;
    private String message;

    public ResourceAlreadyPresentException(int id, String message) {
       super(message);
        this.id = id;
        this.message = message;
    }

    public ResourceAlreadyPresentException() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
