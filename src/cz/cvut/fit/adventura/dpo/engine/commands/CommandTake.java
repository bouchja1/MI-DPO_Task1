package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;
import cz.cvut.fit.adventura.dpo.engine.objects.MovableThing;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class CommandTake implements Command {

	private Model model;
	private View view;
	private Thing thingToTake;
	
	public CommandTake(Model model, View view, Thing thingToTake) {
		this.model = model;
		this.view = view;
		this.thingToTake = thingToTake;
	}

	@Override
	public void execute() {
		Room actualRoom = model.getPlayer().getWhereAmI();	

			if (actualRoom.containsThing(thingToTake)) {
				if (thingToTake instanceof MovableThing) {
					model.getPlayer().addToInventory(thingToTake);
					actualRoom.removeThing(thingToTake);
					view.writeTakeWhat(thingToTake);
				} else {
					view.writeTakeCant();
				}

			} else {
				view.writeTakeMissing();
			}
	}		

}
