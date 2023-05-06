package com.pavan.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pavan.microservices.currencyconversionservice.model.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//ribbon client depricated, migrated to spring cloud loadbalcer
//@RibbonClient(name="currency-exchange-service")
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/exchange-value/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
