package com.project.rg.Calculator.model;

import com.project.rg.Calculator.enums.CalcDataType;



public class CalcInput {

    private CalcDataType calcDataType;
    private String data;

    public CalcInput(CalcDataType calcDataType, String data) {
        this.calcDataType = calcDataType;
        this.data = data;
    }

    public CalcDataType getCalcDataType() {
        return calcDataType;
    }

    public void setCalcDataType(CalcDataType calcDataType) {
        this.calcDataType = calcDataType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
