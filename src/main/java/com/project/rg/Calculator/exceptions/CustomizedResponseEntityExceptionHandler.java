
package com.project.rg.Calculator.exceptions;

import com.project.rg.Calculator.controller.AbstractController;
import com.project.rg.Calculator.model.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;


import java.util.Date;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler  {

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity<Object> exception(Exception ex) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(),"Bad Req exception" , ex.getMessage() );
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }


}
