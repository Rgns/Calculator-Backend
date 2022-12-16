package com.project.rg.Calculator.services;

import com.project.rg.Calculator.enums.CalcDataType;
import com.project.rg.Calculator.model.CalcInput;
import com.project.rg.Calculator.model.CalcRequest;
import com.project.rg.Calculator.model.CalculatedResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    public CalculatedResult calculate(CalcRequest request) {
        switch (request.getOperator()) {
            case ADD:
                return add(request.getInput1(), request.getInput2());
            case MINUS:
                return substract(request.getInput1(), request.getInput2());
            case DIVIDE:
                return divide(request.getInput1(), request.getInput2());
            case MULTIPLY:
                return multiply(request.getInput1(), request.getInput2());
        }

        throw new UnsupportedOperationException("wrong operator");
    }

    private CalculatedResult multiply(CalcInput input1, CalcInput input2) {
        if (input1.getCalcDataType().equals(CalcDataType.DECIMAL) || input2.getCalcDataType().equals(CalcDataType.DECIMAL)) {
            double res = Double.parseDouble(input1.getData()) * Double.parseDouble(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.DECIMAL);
        } else {
            int res = Integer.parseInt(input1.getData()) * Integer.parseInt(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.INTEGER);
        }
    }

    private CalculatedResult divide(CalcInput input1, CalcInput input2) {
        if (input1.getCalcDataType().equals(CalcDataType.DECIMAL) || input2.getCalcDataType().equals(CalcDataType.DECIMAL)) {
            double res = Double.parseDouble(input1.getData()) / Double.parseDouble(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.DECIMAL);
        } else {
            int res = Integer.parseInt(input1.getData()) / Integer.parseInt(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.INTEGER);
        }
    }

    private CalculatedResult substract(CalcInput input1, CalcInput input2) {
        if (input1.getCalcDataType().equals(CalcDataType.DECIMAL) || input2.getCalcDataType().equals(CalcDataType.DECIMAL)) {
            double res = Double.parseDouble(input1.getData()) - Double.parseDouble(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.DECIMAL);
        } else {
            int res = Integer.parseInt(input1.getData()) - Integer.parseInt(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.INTEGER);
        }
    }


    private CalculatedResult add(CalcInput input1, CalcInput input2) {
        if (input1.getCalcDataType().equals(CalcDataType.DECIMAL) || input2.getCalcDataType().equals(CalcDataType.DECIMAL)) {
            double res = Double.parseDouble(input1.getData()) + Double.parseDouble(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.DECIMAL);
        } else {
            int res = Integer.parseInt(input1.getData()) + Integer.parseInt(input2.getData());
            return createCalcResponse(String.valueOf(res), CalcDataType.INTEGER);
        }
    }

    private CalculatedResult createCalcResponse(String result, CalcDataType dataType) {
        return new CalculatedResult(result, dataType);
    }
}
