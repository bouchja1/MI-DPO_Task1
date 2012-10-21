package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class CommandPut implements Command {

	private Model model;
	private View view;
	private Thing thingToPut;
	
	public CommandPut(Model model, View view, Thing thingToPut) {
		this.model = model;
		this.view = view;
		this.thingToPut = thingToPut;
	}

	@Override
	public void execute() {
		Room actualRoom = model.getPlayer().getWhereAmI();
		Player player = model.getPlayer();

			if (player.hasThing(thingToPut)) {
				model.getPlayer().removeThing(thingToPut);
				actualRoom.addThing(thingToPut);
				model.checkConditions(actualRoom, thingToPut);
				view.writePutWhat(thingToPut);
			} else
				view.writeCantPutThis(thingToPut);
	}

}
