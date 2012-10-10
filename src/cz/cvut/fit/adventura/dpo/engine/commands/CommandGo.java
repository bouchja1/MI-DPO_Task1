package cz.cvut.fit.adventura.dpo.engine.commands;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.NarratorView;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;

public class CommandGo implements Command {

	private Game game;
	private Room roomToGo;

	public CommandGo(Game game, Room roomToGo) {
		this.game = game;
		this.roomToGo = roomToGo;
	}

	@Override
	public String execute() throws Exception {
		String executeText = "";

		Room actualRoom = game.getModel().getPlayer().getWhereAmI();

			if (actualRoom.getEscapes().contains(roomToGo)) {
				if (roomToGo.isLocked()) {
					executeText = NarratorView.GO_LOCKED;
				} else {
					game.getModel().getPlayer().setWhereAmI(roomToGo);
					executeText = NarratorView.GO_ENTERED;
				}
			} else {
				executeText = NarratorView.GO_NO;
			}

		return executeText;
	}

}
