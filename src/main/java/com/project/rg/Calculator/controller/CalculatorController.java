package com.project.rg.Calculator.controller;


import com.project.rg.Calculator.common.CalculatorValidator;
import com.project.rg.Calculator.exceptions.BadRequestException;
import com.project.rg.Calculator.model.CalcRequest;
import com.project.rg.Calculator.model.CalculatedResult;
import com.project.rg.Calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.project.rg.Calculator.common.ApiPath.*;
import static org.springframework.http.HttpStatus.OK;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(API_PATH + SERVICE_PATH)
public class CalculatorController extends AbstractController{

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = CALCULATE, method = POST)// /api/v1/frontend-api/calculate
    public ResponseEntity<CalculatedResult> add(@RequestBody CalcRequest request){

        if(!CalculatorValidator.validateCalcRequest(request)){
            throw new BadRequestException("Request is invalid");
        }
        CalculatedResult result = calculatorService.calculate(request);
        return getResponse(result, OK);
    }

}
