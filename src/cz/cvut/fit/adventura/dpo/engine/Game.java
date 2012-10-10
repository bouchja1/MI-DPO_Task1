package cz.cvut.fit.adventura.dpo.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.commands.Command;
import cz.cvut.fit.adventura.dpo.engine.commands.CommandControl;
import cz.cvut.fit.adventura.dpo.engine.objects.FinalCondition;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.RoomFinish;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class Game {

	private Model model;
	private GameCommandParser commandParser;
	private CommandControl commandControl;

	public Game() {
		model = new Model();
		this.commandControl = new CommandControl();
		this.commandParser = new GameCommandParser(this);
	}

	public void play() throws Exception {
		NarratorView.writeIntro();

		while (!model.isEndGame()) {
			NarratorView.writeRoom(model.getPlayer());
			String userInput = readUserInput();
			Command command = commandParser.parseCommand(userInput);
			if (command != null) {
				commandControl.setCommand(command);
				NarratorView.writeCommandInfo(commandControl.executeCommand());
			} else {
				NarratorView.writeCommandError();
			}
			isGameEnd();
		}
		NarratorView.writeOutro();
	}

	public void isGameEnd() {
		if ((model.getFinishRoom().possibleEndGame())
				&& (model.getPlayer().getWhereAmI() == model.getFinishRoom())) {
			model.setEndGame(true);
		}
	}

	private String readUserInput() {
		System.out.print("> ");
		Scanner sc = new Scanner(System.in);
		String inputLine = sc.nextLine();
		return inputLine;
	}

	public Model getModel() {
		return model;
	}
	
	

}
