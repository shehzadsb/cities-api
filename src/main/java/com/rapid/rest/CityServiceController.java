package com.rapid.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapid.service.CityService;
import com.rapid.validator.ParamValidator;



@RestController
public class CityServiceController {
	
	@Autowired
	CityService cityService;
	
	
	@RequestMapping(value="/connected")
	public ResponseEntity<?> connected(@RequestParam String origin, @RequestParam String destination) {
		
		//System.out.println("origin: " + origin + ", destination: " + destination);
		ParamValidator paramValidator = new ParamValidator();
		
		com.rapid.validator.Error error = paramValidator.validateRequestParams(origin, destination);
		
		if (error != null) {
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
            
		String result = cityService.connected(origin, destination);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}


