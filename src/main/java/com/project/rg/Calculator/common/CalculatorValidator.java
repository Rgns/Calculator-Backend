package com.project.rg.Calculator.common;

import com.project.rg.Calculator.model.CalcInput;
import com.project.rg.Calculator.model.CalcRequest;

public class CalculatorValidator {

    private CalculatorValidator(){

    }

    public static boolean validateCalcRequest(CalcRequest request){
        return request != null && isValidInput(request.getInput1()) &&
                isValidInput(request.getInput2()) &&
                request.getOperator() != null;
    }

    private static boolean isValidInput(CalcInput input) throws NumberFormatException{
        if(input == null || input.getData() ==null || input.getData().isEmpty() || input.getCalcDataType() == null){
            return false;
        }
        switch (input.getCalcDataType()){
            case INTEGER:
                Integer.parseInt(input.getData());
                break;
            case DECIMAL:
                Double.parseDouble(input.getData());
                break;
       }
        return true;
    }
}
