package com.pavan.microservices.limitservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.microservices.limitservices.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsConfigurations() {
		return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}
	

}
