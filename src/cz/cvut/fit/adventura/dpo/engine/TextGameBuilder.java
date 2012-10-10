package cz.cvut.fit.adventura.dpo.engine;

import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.objects.MovableThing;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.RoomFinish;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;
import cz.cvut.fit.adventura.dpo.engine.objects.UnmovableThing;

public class TextGameBuilder implements GameBuilder {

	private Game game;

	public TextGameBuilder() {
		this.game = new Game();
	}

	@Override
	public void buildRoom(String roomName, String description,
			Set<String> escapes, boolean isLocked) throws Exception {
		Room roomActual = new Room(roomName, description, isLocked);

		for (String s : escapes) {
			Room roomEscape;
				roomEscape = game.getModel().getRoomByName(s);
				roomEscape.addEscape(roomActual);
				roomActual.addEscape(roomEscape);

		}

		game.getModel().addRoom(roomActual);
	}

	public void buildRoomFinish(String roomName, String description,
			Set<String> escapes, boolean isLocked) throws Exception {
		RoomFinish roomActual = new RoomFinish(roomName, description, isLocked);

		for (String s : escapes) {
			Room roomEscape;
				roomEscape = game.getModel().getRoomByName(s);
				roomEscape.addEscape(roomActual);
				roomActual.addEscape(roomEscape);

		}

		game.getModel().addFinalRoom(roomActual);
		game.getModel().setPlayable(true);
	}

	public void buildFinalCondition(String roomName, String thingName) throws Exception {
		game.getModel().setFinalCondition(roomName, thingName);
	}

	@Override
	public void buildThing(String roomName, String thingName, String thingDesc,
			boolean isMovable) {
		Thing th = helpBuildThing(roomName, thingName, thingDesc, isMovable,
				null);
		game.getModel().addThing(th, roomName);
	}

	@Override
	public void buildThing(String roomName, String thingName, String thingDesc,
			boolean isMovable, String canUnlock) {
		Thing th = helpBuildThing(roomName, thingName, thingDesc, isMovable,
				canUnlock);
		game.getModel().addThing(th, roomName);
	}

	private Thing helpBuildThing(String roomName, String thingName,
			String thingDesc, boolean isMovable, String canUnlock) {
		Thing thingHelper;
		if (isMovable) {
			if (canUnlock != null) {
				thingHelper = new MovableThing(thingName, thingDesc, canUnlock);
			} else {
				thingHelper = new MovableThing(thingName, thingDesc);
			}
		} else {
			thingHelper = new UnmovableThing(thingName, thingDesc);
		}
		return thingHelper;
	}

	@Override
	public void buildPlayer(String roomName) throws Exception {
		Player player = new Player();
			player.setWhereAmI(game.getModel().getRoomByName(roomName));
			game.getModel().addPlayer(player);
	}

	@Override
	public Game getGame() {
		return this.game;
	}
}
