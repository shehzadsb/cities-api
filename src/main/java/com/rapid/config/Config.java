package com.rapid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rapid.service.CityService;
import com.rapid.service.CityServiceImpl;
import com.rapid.validator.ParamValidator;

@Configuration
public class Config {
	
	@Bean
	public CityServiceImpl cityService() {
		return new CityServiceImpl();
	}
	
	/*
	@Bean
	public ParamValidatorImpl paramValidator() {
		return new ParamValidatorImpl();
	}
	*/
	 

}
