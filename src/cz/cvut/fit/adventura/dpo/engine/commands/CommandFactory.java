package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.Model;
import cz.cvut.fit.adventura.dpo.engine.NarratorView;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class CommandFactory {

	public static Command getCommand(String name, Game game,
			String[] commandParams, Model model) {

		if (writeByCommand(name, commandParams)) {
			if (name.equals("go")) {
				Room roomToGo;
				try {
					roomToGo = model.getRoomByName(commandParams[0]);
					return new CommandGo(game, roomToGo);
				} catch (Exception e) {
					NarratorView.writeCommandInfo(e.getMessage());
				}
			} else if (name.equals("exit"))
				return new CommandExit(game);
			else if (name.equals("take")) {
				Thing toTake;
				try {
					toTake = model.getThingByName(commandParams[0]);
					return new CommandTake(game, toTake);
				} catch (Exception e) {
					NarratorView.writeCommandInfo(e.getMessage());
				}
			} else if (name.equals("put")) {
				Thing toPut;
				try {
					toPut = model.getThingByName(commandParams[0]);
					return new CommandPut(game, toPut);
				} catch (Exception e) {
					NarratorView.writeCommandInfo(e.getMessage());
				}
			}
			else if (name.equals("unlock")) {
				Room roomToUnlock;
				try {
					roomToUnlock = model.getRoomByName(commandParams[0]);
					return new CommandUnlock(game, roomToUnlock);
				} catch (Exception e) {
					NarratorView.writeCommandInfo(e.getMessage());
				}
			}
		}
		return null;
	}

	private static boolean writeByCommand(String commandName,
			String[] commandParams) {
		if ((commandName.equals("go")) || (commandName.equals("put"))
				|| (commandName.equals("take"))
				|| (commandName.equals("unlock"))) {
			if (commandParams.length != 1) {
				NarratorView.writeCommandAcceptsOne(commandName);
				return false;
			}
		} else if (commandName.equals("exit")) {
			if (commandParams.length != 0) {
				NarratorView.writeCommandAcceptsNone(commandName);
				return false;
			}
		}

		return true;
	}

}
