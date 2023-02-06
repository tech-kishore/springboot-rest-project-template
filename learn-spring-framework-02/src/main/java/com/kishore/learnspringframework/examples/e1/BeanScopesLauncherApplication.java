package com.kishore.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class DefaultSingletonScopeClass {

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeScopeClass {

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {

			System.out.println(context.getBean(DefaultSingletonScopeClass.class));
			System.out.println(context.getBean(DefaultSingletonScopeClass.class));
			System.out.println(context.getBean(DefaultSingletonScopeClass.class));

			System.out.println(context.getBean(PrototypeScopeClass.class));
			System.out.println(context.getBean(PrototypeScopeClass.class));
			System.out.println(context.getBean(PrototypeScopeClass.class));

		}

	}

}
