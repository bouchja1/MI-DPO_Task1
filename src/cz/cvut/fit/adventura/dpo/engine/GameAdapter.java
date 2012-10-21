package cz.cvut.fit.adventura.dpo.engine;

import java.io.File;

import cz.cvut.fit.adventura.dpo.engine.mvc.Game;

/**
 * @author bouc2162
 * 
 * Spousteni konstrukce hry a spousteni herni smycky
 *
 */
public class GameAdapter {

	private Game game;	

	
	/**
	 * @param gameEngineer 
	 * @param textGame
	 * @throws Exception
	 * 
	 * Spousteni konstrukce hry
	 */
	public void buildGame(IGameEngineer gameEngineer, TextGameBuilder textGame) throws Exception {
		gameEngineer.constructGame();
		game = gameEngineer.getGame();
	}
	
	
	/**
	 * @throws Exception povinnost finalni mistnosti
	 * 
	 * Spousteni herni smycky
	 */
	public void playGame() throws Exception {
		if (game.getModel().isPlayable()) {
			this.game.play();
		}
		else {
			throw new Exception("You must set FINAL ROOM for playing game!");
		}
	}

}
