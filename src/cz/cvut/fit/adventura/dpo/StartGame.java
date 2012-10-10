package cz.cvut.fit.adventura.dpo;

import cz.cvut.fit.adventura.dpo.engine.GameAdapter;
import cz.cvut.fit.adventura.dpo.engine.TextGameBuilder;


public class StartGame {
	public static void main(String[] args) {
		  	GameAdapter gameAdapter = GameAdapter.getInstance();
			TextGameBuilder textGame = new TextGameBuilder();
			GameEngineer gameEngineer = new GameEngineer(textGame);
		  	
		  	try {
		  		gameAdapter.buildGame(gameEngineer, textGame);
		  		gameAdapter.playGame();
		  	} catch (Exception e) {
		  		e.printStackTrace();
		  	}
	}
}
