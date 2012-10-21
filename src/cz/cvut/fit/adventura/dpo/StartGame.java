package cz.cvut.fit.adventura.dpo;

import java.io.File;

import cz.cvut.fit.adventura.dpo.engine.GameAdapter;
import cz.cvut.fit.adventura.dpo.engine.TextGameBuilder;


/**
 * @author bouc2162
 * 
 * Vstupni brana do aplikace.
 *
 */
public class StartGame {
	
	/**
	 * @param args
	 * 
	 * Instanciovani dulezitych trid, ktere maji za ukol vytvorit a nakonfigurovat
	 * hru a veci potrebne k jejimu obsluhovani.
	 */
	public static void main(String[] args) {
		  	GameAdapter gameAdapter = new GameAdapter();
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
