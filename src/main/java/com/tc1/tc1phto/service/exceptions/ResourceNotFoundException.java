package com.tc1.tc1phto.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
