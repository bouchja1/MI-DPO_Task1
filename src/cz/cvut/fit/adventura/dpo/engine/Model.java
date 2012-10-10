package cz.cvut.fit.adventura.dpo.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.objects.FinalCondition;
import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.RoomFinish;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class Model {

	private List<Room> rooms;
	private List<Thing> things;
	private Player player;
	private boolean endGame = false;
	private boolean playable;
	private RoomFinish finishRoom;
	
	public Model() {
		this.rooms = new ArrayList<Room>();
		this.things = new ArrayList<Thing>();				
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public void addFinalRoom(RoomFinish room) {

		finishRoom = room;

		rooms.add(room);
	}

	public void addThing(Thing thing, String roomName) {
		Room room;
		try {
			room = getRoomByName(roomName);
			checkConditions(room, thing);
			room.addThing(thing);
			things.add(thing);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}	
	
	public void addPlayer(Player player) {
		this.player = player;		
	}	
	
	public void setFinalCondition(String roomName, String thingName)
			throws Exception {
		Room room = getRoomByName(roomName);
		Thing th = getThingByName(thingName);
		FinalCondition finalCond = new FinalCondition(room, th);
		finishRoom.addCondition(finalCond);
	}

	// kontrola pri vytvareni veci nebo pokladani veci, jestli uz tam neni
	// splnena podminka
	public void checkConditions(Room room, Thing thing) {
		Set<FinalCondition> conditions = finishRoom.getConditions();

		for (FinalCondition c : conditions) {
			if ((c.getRoom() == room) && (c.getThing() == thing)) {
				c.setAccomplished(true);
			}
		}
	}

	public Thing getThingByName(String thingName) throws Exception {
		Iterator<Thing> iterator = things.iterator();
		Thing t = null;

		while (iterator.hasNext()) {
			Thing iterableThing = iterator.next();
			if (iterableThing.getName().equals(thingName)) {
				t = iterableThing;
				break;
			}
		}

		if (t == null)
			throw new RuntimeException(NarratorView.THING_NOT_FOUND);

		return t;
	}

	public Room getRoomByName(String roomName) throws Exception {
		Iterator<Room> iterator = rooms.iterator();
		Room r = null;

		while (iterator.hasNext()) {
			Room iterableRoom = iterator.next();
			if (iterableRoom.getName().equals(roomName)) {
				r = iterableRoom;
				break;
			}
		}

		if (r == null)
			throw new RuntimeException(NarratorView.ROOM_NOT_FOUND);
		return r;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isEndGame() {
		return endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public RoomFinish getFinishRoom() {
		return finishRoom;
	}

	public void setFinishRoom(RoomFinish finishRoom) {
		this.finishRoom = finishRoom;
	}

}
