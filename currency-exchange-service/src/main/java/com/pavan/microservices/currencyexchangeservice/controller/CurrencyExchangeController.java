package com.pavan.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

import com.pavan.microservices.currencyexchangeservice.model.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@GetMapping("/exchange-value/from/{from}/to/{to}")
	private ExchangeValue currencyExchangeValue(@PathVariable String from , @PathVariable String to) {
		ExchangeValue ev= new ExchangeValue(100,from,to,BigDecimal.valueOf(65));
		ev.setPortNumber(Integer.parseInt(environment.getProperty("local.server.port")));
		return ev;
		
	}

}
