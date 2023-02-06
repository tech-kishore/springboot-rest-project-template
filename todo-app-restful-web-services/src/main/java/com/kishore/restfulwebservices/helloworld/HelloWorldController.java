package com.kishore.restfulwebservices.helloworld;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	@Autowired
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path = "/hello-world/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Hello World - " + name;
	}

	@GetMapping(path = "/hello-world-json")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World - " +LocalDate.now());
	}

	@GetMapping(path = "/hello-world-i18n")
	public String i18nHelloWorld() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("locale.i18n.helloworld", null, "Default Message", locale);
	}

}
