package com.project.rg.Calculator.services;

import com.project.rg.Calculator.dao.UserRepository;
import com.project.rg.Calculator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import java.util.logging.Logger;

@Service
public class AuthService {

    Logger logger = Logger.getLogger(AuthService.class.getName());

    public String getCurrentLoggedInUser() {
        return currentLoggedInUser;
    }

    private String currentLoggedInUser;

    @Autowired
    UserRepository userRepository;


    public boolean isAuthenticated(String auth) {
        if(auth == null){
            return false;
        }
        String[] authParts = auth.split("\\s+");
        String authInfo = authParts[1];

        byte[] bytes = Base64Utils.decodeFromString(authInfo);
        String decodeString = new String(bytes);
        System.out.println(decodeString);

        String[] details = decodeString.split(":");
        String userName = details[0];
        String pwd = details[1];

        boolean valid =  authenticate(userName,pwd);
        if(valid){
            currentLoggedInUser = userName;
        }
        return valid;

    }

    private boolean authenticate(String userName, String pwd) {
        User user = userRepository.findByUserName(userName);
         return user != null &&  user.getPwd().equals(pwd);
    }

}
