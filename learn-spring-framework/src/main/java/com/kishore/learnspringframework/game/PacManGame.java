package com.kishore.learnspringframework.game;

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
