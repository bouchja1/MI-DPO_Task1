package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.exception.GameException;
import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

/**
 * @author bouc2162
 * 
 * Dle patternu Factory. Vytváøí jednotlivé továrny (produkty) bez specifikování pøesné tøídy, jež by mìla být vytvoøena
 *
 */
public class CommandFactory {
	
	/**
	 * @param name
	 * @param commandParams
	 * @param model
	 * @param view
	 * @return
	 * @throws GameException
	 * 
	 * Vytváøí konkrétní továrnu
	 */
	public static Command getCommand(String name, String[] commandParams,
			Model model, View view) throws GameException {

		if (name.equals("go")) {
			Room roomToGo;
				roomToGo = model.getRoomByName(commandParams[0]);
				return new CommandGo(model, view, roomToGo);
		} else if (name.equals("exit"))
			return new CommandExit(model, view);
		else if (name.equals("take")) {
			Thing toTake;
				toTake = model.getThingByName(commandParams[0]);
				return new CommandTake(model, view, toTake);
		} else if (name.equals("put")) {
			Thing toPut;
				toPut = model.getThingByName(commandParams[0]);
				return new CommandPut(model, view, toPut);

		} else if (name.equals("unlock")) {
			Room roomToUnlock;
				roomToUnlock = model.getRoomByName(commandParams[0]);
				return new CommandUnlock(model, view, roomToUnlock);
		} else if (name.equals("help")) {
			return new CommandHelp(view);
	}

		return null;
	}

}
