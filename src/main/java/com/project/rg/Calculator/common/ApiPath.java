package com.project.rg.Calculator.common;

public interface ApiPath  {

    String API = "api",
            V = "v1",
            SERVICE = "frontend-api",
            SLASH = "/";

    String API_PATH = SLASH + API + SLASH + V;

    String SERVICE_PATH = SLASH + SERVICE;


    String REGISTER_USER =  SLASH + "registerUser";
    String LOGIN = SLASH + "login";
    String INTERNAL = "internal";

}
