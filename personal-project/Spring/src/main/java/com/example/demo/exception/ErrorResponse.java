package com.example.demo.exception;

public class ErrorResponse{
    private final String type;
    private final String description;

    ErrorResponse(String type, String description){
        this.type = type;
        this.description = description;
    }

    public String getErrorType(){
        return type;
    }

    public String getErrorDescription(){
        return description;
    }
}
