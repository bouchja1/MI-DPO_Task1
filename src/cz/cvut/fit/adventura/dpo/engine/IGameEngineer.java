package cz.cvut.fit.adventura.dpo.engine;

import cz.cvut.fit.adventura.dpo.engine.mvc.Game;

/**
 * @author bouc2162
 * 
 *         Parametrizace hry. Vytvareni mistnosti, pruchodu, veci, podminek pro
 *         vyhru atd.
 */
public interface IGameEngineer {

	public Game getGame();
	public void constructGame() throws Exception;
}
