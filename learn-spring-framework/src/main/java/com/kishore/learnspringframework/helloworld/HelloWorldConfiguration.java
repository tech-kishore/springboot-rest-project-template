package com.kishore.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Kishore";
	}

	@Bean
	public int age() {
		return 15;
	}

	@Bean
	public Person person() {
		var person = new Person("Ravi", 20);
		return person;
	}

	@Bean
	@Primary
	public Address address() {
		var address = new Address("JB Road", "Chandigarh");
		return address;
	}
	
	@Bean
	@Qualifier("address1qualifier")
	public Address address1() {
		var address = new Address("JB Road 1", "Chandigarh1");
		return address;
	}


}
