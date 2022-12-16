package com.project.rg.Calculator.model;



public class CalcRequest {

    private CalcInput input1;
    private CalcInput input2;
    private Operator operator;

    public CalcInput getInput1() {
        return input1;
    }

    public void setInput1(CalcInput input1) {
        this.input1 = input1;
    }

    public CalcInput getInput2() {
        return input2;
    }

    public void setInput2(CalcInput input2) {
        this.input2 = input2;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
