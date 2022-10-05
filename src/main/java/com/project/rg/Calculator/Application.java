package com.project.rg.Calculator;

import com.project.rg.Calculator.filters.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
		System.out.println("filterRegistrationBean registered");
		FilterRegistrationBean<AuthFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(authFilterBean());
		filterRegistrationBean.addUrlPatterns("*");
		return filterRegistrationBean;

	}


	@Bean
	AuthFilter authFilterBean(){
		System.out.println("authFilter called");
		return new AuthFilter();
	}*/

}
