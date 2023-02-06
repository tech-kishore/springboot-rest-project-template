package com.kishore.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeDependencyClass {
	
	public SomeDependencyClass() {
		super();
		System.out.println("SomeDependencyClass constructor");
	}

	public void logic() {
		System.out.println("logic in SomeDependencyClass..");
	}

	@PreDestroy
	private void cleanup() {
		System.out.println("2. Predestroy- cleanup in " + this.getClass());
	}

}

@Component
class SomeClass {

	private SomeDependencyClass dependency;

	public SomeClass(SomeDependencyClass dependency) {
		super();
		this.dependency = dependency;
		System.out.println("SomeClass constructor");
	}

	@PostConstruct
	private void initialize() {
		System.out.println("Executing postconstruct code in SomeClass");
		this.dependency.logic();
	}
	
	@PreDestroy
	private void cleanup() {
		System.out.println("1. Predestroy- cleanup in " + this.getClass());
	}

}


@Configuration
@ComponentScan
public class PrePostAnotationsContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PrePostAnotationsContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}

	}

}
