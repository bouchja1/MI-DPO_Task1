package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.NarratorView;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class CommandPut implements Command {

	private Game game;
	private Thing thingToPut;
	
	public CommandPut(Game game, Thing thingToPut) {
		this.game = game;
		this.thingToPut = thingToPut;
	}

	@Override
	public String execute() throws Exception {
		String executeText = "";
		
		Room actualRoom = game.getModel().getPlayer().getWhereAmI();
		Player player = game.getModel().getPlayer();

			if (player.hasThing(thingToPut)) {
				game.getModel().getPlayer().removeThing(thingToPut);
				actualRoom.addThing(thingToPut);
				game.getModel().checkConditions(actualRoom, thingToPut);
				executeText = NarratorView.writePutWhat(thingToPut);
			} else
				executeText = NarratorView.writeCantPutThis(thingToPut);

		return executeText;
	}

}
