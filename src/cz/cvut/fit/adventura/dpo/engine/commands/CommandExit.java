package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.NarratorView;

public class CommandExit implements Command {

	private Game game;

	public CommandExit(Game game) {
		this.game = game;
	}

	@Override
	public String execute() {
		String executeText = "";

		game.getModel().setEndGame(true);
		executeText = NarratorView.EXIT_OK;

		return executeText;
	}

}
