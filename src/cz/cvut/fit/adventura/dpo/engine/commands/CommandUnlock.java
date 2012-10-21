package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;

public class CommandUnlock implements Command {
	
	private Model model;
	private View view;
	private Room roomToUnlock;
	
	public CommandUnlock(Model model, View view, Room roomToUnlock) {
		this.model = model;
		this.view = view;
		this.roomToUnlock = roomToUnlock;
	}	

	@Override
	public void execute() {		
		Room actualRoom = model.getPlayer().getWhereAmI();
		Player player = model.getPlayer();

			if (actualRoom.getEscapes().contains(roomToUnlock)) {
				if (roomToUnlock.isLocked()) {
					if (player.hasUnlockThing(roomToUnlock)) {
						roomToUnlock.setLocked(false);						
						view.writeUnlockWhat(roomToUnlock);
					} else {
						view.writeUnlockNeedKey();
					}
				} else {					
					view.writeUnlockAlreadyUnlocked();
				}
			} else {
				view.writeUnlockNoWay(roomToUnlock);
			}
	}

}
