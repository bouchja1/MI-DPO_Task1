package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.NarratorView;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;

public class CommandUnlock implements Command {
	
	private Game game;
	private Room roomToUnlock;
	
	public CommandUnlock(Game game, Room roomToUnlock) {
		this.game = game;
		this.roomToUnlock = roomToUnlock;
	}	

	@Override
	public String execute() throws Exception {
		String executeText = "";
		
		Room actualRoom = game.getModel().getPlayer().getWhereAmI();
		Player player = game.getModel().getPlayer();

			if (actualRoom.getEscapes().contains(roomToUnlock)) {
				if (roomToUnlock.isLocked()) {
					if (player.hasUnlockThing(roomToUnlock)) {
						roomToUnlock.setLocked(false);
						executeText = NarratorView.writeUnlockWhat(roomToUnlock);
					} else {
						executeText = NarratorView.UNLOCK_NEED_KEY;
					}
				} else {
					executeText = NarratorView.UNLOCK_ALREADY_UNLOCKED;
				}
			} else {
				executeText = NarratorView.writeUnlockNoWay(roomToUnlock);
			}
		
		return executeText;
	}

}
