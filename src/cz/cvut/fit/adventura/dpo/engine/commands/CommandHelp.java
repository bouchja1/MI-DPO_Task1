package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.mvc.View;

public class CommandHelp implements Command {

	private View view;

	public CommandHelp(View view) {
		this.view = view;
	}

	@Override
	public void execute() {
		view.writeHelp();
	}

}
