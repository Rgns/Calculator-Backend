package com.project.rg.Calculator.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.rg.Calculator.services.AuthService;
import com.project.rg.Calculator.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.project.rg.Calculator.common.ApiPath.REGISTER_USER;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class AuthFilter implements Filter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);
    
    @Autowired
    private AuthService authService;

    @Autowired
    private LoginService loginService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String auth = request.getHeader(AUTHORIZATION);


        if(isNewUser(request) || authService.isAuthenticated(auth)){
            LOGGER.info("User authenticated");
        }else{
            LOGGER.info("User authentication failed");
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getOutputStream().println(objectMapper.writeValueAsString(loginService.getFailureLogin()));
            return;
        }

        System.out.println("It came after");
        chain.doFilter(request, response);

    }

    private boolean isNewUser(HttpServletRequest request) {
        LOGGER.info("Checking If user present");
        return request.getRequestURI().contains(REGISTER_USER);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating Custom filter ##########");
    }

}
