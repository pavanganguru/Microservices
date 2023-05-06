package com.pavan.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

import com.pavan.microservices.currencyexchangeservice.model.ExchangeValue;
import com.pavan.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("/exchange-value/from/{from}/to/{to}")
	private ExchangeValue currencyExchangeValue(@PathVariable String from , @PathVariable String to) {
//		ExchangeValue ev= new ExchangeValue(100,from,to,BigDecimal.valueOf(65));
		
		ExchangeValue ev = exchangeValueRepository.findByFromAndTo(from, to);
		
//		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return ev;
		
	}

}
