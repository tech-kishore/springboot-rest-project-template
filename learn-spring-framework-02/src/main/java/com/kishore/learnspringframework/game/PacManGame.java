package com.kishore.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacManGame implements GamingConsole {

	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("Duck");
	}

	public void left() {
		System.out.println("Go back");
	}

	public void right() {
		System.out.println("Move forward");
	}
}
