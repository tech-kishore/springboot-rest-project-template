package com.kishore.learnspringframework;

import com.kishore.learnspringframework.game.GameRunner;
import com.kishore.learnspringframework.game.PacManGame;

public class App01GamingBasic {

	public static void main(String[] args) {

        //var game = new MarioGame();
		//var gameRunner = new GameRunner(game);
		//var game=new SuperContraGame();
		
		var game = new PacManGame();
		
		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}

}
