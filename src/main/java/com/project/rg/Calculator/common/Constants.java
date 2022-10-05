package com.project.rg.Calculator.common;

public interface Constants {

    interface HttpHeaderValues {
        long MAX_AGE = 86400;
    }

    interface Message {
        // USERS

        String USER_PRESENT_BY_USERNAME = "User already present by username";
        String USER_PRESENT_BY_EMAIL = "User already present by Email address";


        String USER_IS_VALID = "User is valid";
        String USER_IS_INVALID = "User is invalid";
        String USER_SUCCESSFULLY_REGEISTERED = "User is registered Successfully";

    }
}
