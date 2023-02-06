package com.kishore.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kishore.learnspringframework.game.GameRunner;
import com.kishore.learnspringframework.game.GamingConsole;
import com.kishore.learnspringframework.game.PacManGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacManGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole console) {
		var gameRunner = new GameRunner(console);
		return gameRunner;
	}
}
