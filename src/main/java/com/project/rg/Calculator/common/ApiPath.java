package com.project.rg.Calculator.common;

public interface ApiPath  {

    String API = "api",
            V = "v1",
            SERVICE = "frontend-api",
            SLASH = "/";

    String API_PATH = SLASH + API + SLASH + V;

    String SERVICE_PATH = SLASH + SERVICE;


    // login controller
    String REGISTER_USER =  SLASH + "registerUser";
    String LOGIN = SLASH + "login";
    String INTERNAL = "internal";


    // calculator controller

    String CALCULATE = SLASH + "calculate";

}
