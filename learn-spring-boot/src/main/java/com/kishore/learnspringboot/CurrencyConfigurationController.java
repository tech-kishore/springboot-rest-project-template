package com.kishore.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

	private CurrencyServiceConfiguration configuration;

	@Autowired
	public CurrencyConfigurationController(CurrencyServiceConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	@GetMapping("/currency-configuration")
	public CurrencyServiceConfiguration getCurrencyConfiguration() {
		return configuration;
	}

}
