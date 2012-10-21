package cz.cvut.fit.adventura.dpo.engine.mvc;

import java.io.File;

import cz.cvut.fit.adventura.dpo.engine.GameCommandParser;
import cz.cvut.fit.adventura.dpo.engine.commands.Command;
import cz.cvut.fit.adventura.dpo.engine.commands.CommandControl;
import cz.cvut.fit.adventura.dpo.engine.exception.GameException;

/**
 * @author bouc2162
 * 
 * Controller. Obsluhuje herní smyèku a prùbìh hry.
 *
 */
public class Game {

	private Model model;
	private GameCommandParser commandParser;
	private CommandControl commandControl;
	private View view;

	public Game(View view, GameCommandParser commandParser) {
		this.view = view;
		this.model = new Model();
		this.commandControl = new CommandControl();
		this.commandParser = commandParser;
	}

	/**
	 * @throws Exception
	 * 
	 * Herní smyška. Probíhá tak dlouho, dokud není hra ukonèena (výhrou èi pøíkazem)
	 * Stará se též o iniciaci spuštìní pøíkazu
	 */
	public void play() throws Exception {
		view.writeIntro();

		while (!model.isEndGame()) {
			view.writeRoom(model.getPlayer());
			Command command = null;
			try {
				command = commandParser.parseCommand(model, view);			
			}
			catch (GameException ge) {
				view.writeCommandInfo(ge.getMessage());
			}
			if (command != null) {
				commandControl.setCommand(command);
				commandControl.executeCommand();
			} else {
				view.writeCommandError();
			}
			isGameEnd();				
		}
		view.writeOutro();
	}

	/**
	 * Nastavuje konec hry v pøípadì splnìní podmínek
	 */
	public void isGameEnd() {
		if ((model.getFinishRoom().possibleEndGame())
				&& (model.getPlayer().getWhereAmI() == model.getFinishRoom())) {
			model.setEndGame(true);
		}
	}

	public Model getModel() {
		return model;
	}

	public View getView() {
		return view;
	}
	
	

}
