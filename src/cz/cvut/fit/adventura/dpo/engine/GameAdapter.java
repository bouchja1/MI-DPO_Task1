package cz.cvut.fit.adventura.dpo.engine;

import cz.cvut.fit.adventura.dpo.GameEngineer;



public class GameAdapter {

	private static GameAdapter instance;
	private Game game;	

	private GameAdapter() {		
	}
	
	public static GameAdapter getInstance() {
		if (instance == null) {
			instance = new GameAdapter();
		}
		return instance;
	}	

	public void buildGame(GameEngineer gameEngineer, TextGameBuilder textGame) throws Exception {
		gameEngineer.constructGame();
		game = gameEngineer.getGame();
	}
	
	public void playGame() throws Exception {
		if (game.getModel().isPlayable()) {
			this.game.play();
		}
		else {
			throw new Exception("You must set FINAL ROOM for playing game!");
		}
	}

}
