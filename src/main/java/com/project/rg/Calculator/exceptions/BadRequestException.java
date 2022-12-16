package com.project.rg.Calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public final class BadRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BadRequestException(){

    }
    public BadRequestException(String message){
        super(message);
    }
}
