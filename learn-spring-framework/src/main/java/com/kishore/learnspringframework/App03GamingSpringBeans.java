package com.kishore.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kishore.learnspringframework.game.GameRunner;
import com.kishore.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {

			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}

	}

}
