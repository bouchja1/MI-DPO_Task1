package cz.cvut.fit.adventura.dpo.engine;

import cz.cvut.fit.adventura.dpo.engine.commands.Command;
import cz.cvut.fit.adventura.dpo.engine.exception.GameException;
import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;

/**
 * @author bouc2162
 * 
 * Zpracovani vstupu a na z�klad� toho validace a vytvareni p��kaz�
 *
 */
public interface GameCommandParser {
	/**
	 * @param model
	 * @param view
	 * @return konkr�tn� p��kaz
	 * @throws GameException
	 * 
	 * Rozparsovani inputu, validace a volani novych prikazu
	 */
	public Command parseCommand(Model model, View view) throws GameException;
}
