package com.project.rg.Calculator.model;

import com.project.rg.Calculator.enums.CalcDataType;

public class CalculatedResult {

    private String result;
    private CalcDataType resultDataType;

    public CalculatedResult(String result, CalcDataType resultDataType) {
        this.result = result;
        this.resultDataType = resultDataType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public CalcDataType getResultDataType() {
        return resultDataType;
    }

    public void setResultDataType(CalcDataType resultDataType) {
        this.resultDataType = resultDataType;
    }
}
