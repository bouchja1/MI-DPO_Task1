package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.NarratorView;
import cz.cvut.fit.adventura.dpo.engine.objects.MovableThing;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class CommandTake implements Command {

	private Game game;
	private Thing thingToTake;
	
	public CommandTake(Game game, Thing thingToTake) {
		this.game = game;
		this.thingToTake = thingToTake;
	}

	@Override
	public String execute() throws Exception {
		String executeText = "";
		
		Room actualRoom = game.getModel().getPlayer().getWhereAmI();	

			if (actualRoom.containsThing(thingToTake)) {
				if (thingToTake instanceof MovableThing) {
					game.getModel().getPlayer().addToInventory(thingToTake);
					actualRoom.removeThing(thingToTake);
					executeText = NarratorView.writeTakeWhat(thingToTake);
				} else {
					executeText = NarratorView.TAKE_CANT;
				}

			} else {
				executeText = NarratorView.TAKE_MISSING;
			}

		return executeText;
	}		

}
