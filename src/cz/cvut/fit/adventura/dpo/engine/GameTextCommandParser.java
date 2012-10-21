package cz.cvut.fit.adventura.dpo.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import cz.cvut.fit.adventura.dpo.engine.commands.Command;
import cz.cvut.fit.adventura.dpo.engine.commands.CommandFactory;
import cz.cvut.fit.adventura.dpo.engine.exception.GameException;
import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;

/**
 * @author bouc2162
 * 
 *         Zpracovani vstupu a na z�klad� toho validace a vytvareni p��kaz�
 * 
 */
public class GameTextCommandParser implements GameCommandParser {

	// private Scanner sc;

	public GameTextCommandParser() {
		// sc = new Scanner(System.in);
	}

	@Override
	public Command parseCommand(Model model, View view)
			throws GameException {
		// zde se provede rozparsovani inputu, validace a volani novych prikazu
		String userInput = readUserInput();
		String[] parsedInput = userInput.split("[ \t]+"); // space or tab occurs
															// one or more times
		String commandString = parsedInput[0];

		String[] commandParams = new String[parsedInput.length - 1];

		for (int i = 0; i < commandParams.length; i++) {
			commandParams[i] = parsedInput[i + 1];
		}

		Command command;

		if (writeByCommand(commandString, view, commandParams)) {
			command = CommandFactory.getCommand(commandString, commandParams,
					model, view);
		} else
			return null;

		return command;
	}

	/**
	 * @return u�ivatelsk� vstup
	 * 
	 *         �ten� u�ivatelsk�ho vstupu z konzole
	 */
	private String readUserInput() {
		System.out.print("> ");
		Scanner sc = new Scanner(System.in);
		String inputLine = sc.nextLine();

		return inputLine;
	}

	/**
	 * @param commandName
	 *            jm�no p��kazu
	 * @param view
	 * @param commandParams
	 * @return zda p��kaz spl�uje sv�j po�et parametr�
	 * 
	 *         Kontrola, zda byl u konkr�tn�ho hern�ho p��kazu zad�n spr�vn�
	 *         po�et parametr�
	 */
	private boolean writeByCommand(String commandName, View view,
			String[] commandParams) {
		if ((commandName.equals("go")) || (commandName.equals("put"))
				|| (commandName.equals("take"))
				|| (commandName.equals("unlock"))) {
			if (commandParams.length != 1) {
				view.writeCommandAcceptsOne(commandName);
				return false;
			}
		} else if ((commandName.equals("exit")) || (commandName.equals("help"))) {
			if (commandParams.length != 0) {
				view.writeCommandAcceptsNone(commandName);
				return false;
			}
		}

		return true;
	}

}
