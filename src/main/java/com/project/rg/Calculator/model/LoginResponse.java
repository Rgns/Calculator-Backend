package com.project.rg.Calculator.model;

import com.project.rg.Calculator.enums.LoginStatus;

public class LoginResponse {
    private String message;
    private LoginStatus status;
    public LoginResponse(String msg, LoginStatus status){
        this.message = msg;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginStatus getStatus() {
        return status;
    }

    public void setStatus(LoginStatus status) {
        this.status = status;
    }
}
