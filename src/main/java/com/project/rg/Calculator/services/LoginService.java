package com.project.rg.Calculator.services;

import com.project.rg.Calculator.dao.UserRepository;
import com.project.rg.Calculator.enums.LoginStatus;
import com.project.rg.Calculator.model.LoginResponse;
import com.project.rg.Calculator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static com.project.rg.Calculator.common.Constants.Message.*;
import static com.project.rg.Calculator.common.Constants.Message.USER_PRESENT_BY_EMAIL;
import static com.project.rg.Calculator.enums.LoginStatus.INVALID;
import static com.project.rg.Calculator.enums.LoginStatus.VALID;
import static java.util.logging.Level.INFO;
@Service
public class LoginService {

    Logger logger = Logger.getLogger(LoginService.class.getName());

    @Autowired
    UserRepository userRepository;

    public LoginResponse getLoginResponse(String message , LoginStatus loginStatus) {
        return new LoginResponse(message, loginStatus);
    }

    public LoginResponse getSuccessLogin(){
        logger.log(INFO, "Trying to get Login Response");
        return validLogin(USER_IS_VALID);
    }

    public LoginResponse validLogin(String message){
        return getLoginResponse(message, VALID);
    }

    public LoginResponse getFailureLogin(){
        logger.log(INFO, "Trying to get Failure Login Response");
        return invalidLogin(USER_IS_INVALID);
    }

    public LoginResponse invalidLogin(String message){
        return getLoginResponse(message, INVALID);
    }


    public LoginResponse validateUser(User request){

        if(userRepository.existsUserByEmail(request.getEmail())){
            return invalidLogin( USER_PRESENT_BY_EMAIL);
        }
        if (userRepository.existsUserByUserName(request.getUserName())){
            return invalidLogin( USER_PRESENT_BY_USERNAME);
        }

        return null;
    }


    public LoginResponse registerUser(User request) {
        userRepository.save(request);
        return validLogin(USER_SUCCESSFULLY_REGEISTERED);
    }



}
