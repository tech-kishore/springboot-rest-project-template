package com.kishore.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		// Launch a Spring Context
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

			// Configure the things that we want Spring to manage - @Configuration
			// HelloWorldConfiguration
			// name - @Bean

			// Retrieve beans managed by Spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("address"));
			System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean("address1"));

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}

	}

}
