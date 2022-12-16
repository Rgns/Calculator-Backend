package com.project.rg.Calculator.controller;

import com.project.rg.Calculator.exceptions.BadRequestException;
import com.project.rg.Calculator.model.LoginResponse;
import com.project.rg.Calculator.model.User;
import com.project.rg.Calculator.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.project.rg.Calculator.common.ApiPath.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RequestMapping(API_PATH + SERVICE_PATH)// /api/v1/frontend-api
@RestController
public class LoginController extends AbstractController {

    @Autowired
    private LoginService loginService;


    Logger logger = Logger.getLogger(LoginController.class.getName());

    @GetMapping("/hello")
    public String test() {
        return "Hello world";
    }

    @GetMapping("/hello2")
    public String test2() {
        int x = 2;

        if(x==2)
            return "Hello world";


        throw new BadRequestException("throwing error");


    }



    @RequestMapping(value = LOGIN, method = POST)// /api/v1/frontend-api/login
    public ResponseEntity<LoginResponse> login(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        logger.log(Level.INFO, "Request to Register User");
        return getResponse(loginService.getSuccessLogin(), OK);
    }

    @RequestMapping(value = REGISTER_USER, method = POST)// /api/v1/frontend-api/registerUser
    public ResponseEntity<LoginResponse> registerUser(@RequestBody User request) {
        logger.log(Level.INFO, "Request to Sign up User");
        LoginResponse error = loginService.validateUser(request);
        if (error == null) {
            return getResponse(loginService.registerUser(request), OK);
        }
        return getResponse(error, BAD_REQUEST);
    }


}
