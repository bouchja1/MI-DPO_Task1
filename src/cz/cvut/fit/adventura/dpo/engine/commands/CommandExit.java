package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;

public class CommandExit implements Command {

	private Model model;
	private View view;

	public CommandExit(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void execute() {
		model.setEndGame(true);
		view.writeExitOk();
	}

}
