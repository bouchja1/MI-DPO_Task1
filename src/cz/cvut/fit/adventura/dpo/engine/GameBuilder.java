package cz.cvut.fit.adventura.dpo.engine;

import java.util.Set;

public interface GameBuilder {
	
	public void buildRoom(String roomName, String description, Set<String> escapes, boolean isLocked) throws Exception;
	
	public void buildRoomFinish(String roomName, String description, Set<String> escapes, boolean isLocked) throws Exception;
	
	public void buildFinalCondition(String roomName, String thingName) throws Exception;
	
	public void buildThing(String roomName, String thingName, String thingDesc, boolean isMovable);
	
	public void buildThing(String roomName, String thingName, String thingDesc, boolean isMovable, String canUnlock);
	
	public void buildPlayer(String roomName) throws Exception;
	
	public Game getGame();
}
