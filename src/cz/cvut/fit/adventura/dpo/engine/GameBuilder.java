package cz.cvut.fit.adventura.dpo.engine;

import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.mvc.Game;

/**
 * @author bouc2162
 * 
 * Stav�n� hry, pattern Builder
 *
 */
public interface GameBuilder {
	
	
	/**
	 * @param roomName
	 * @param description
	 * @param escapes
	 * @param isLocked
	 * @throws Exception
	 * 
	 * Vytvo�� m�stnost, nastav� v�chodu do dal��ch a p�id� ji do hry
	 */
	public void buildRoom(String roomName, String description, Set<String> escapes, boolean isLocked) throws Exception;
	
	
	/**
	 * @param roomName
	 * @param description
	 * @param escapes
	 * @param isLocked
	 * @throws Exception
	 * 
	 * Vytvo�� m�stnost, nastav� v�chody, p�id� ji do hry a rozhodne o tom, �e hra je ji� spustiteln� (p��tomna c�lov� m�stnost)
	 */
	public void buildRoomFinish(String roomName, String description, Set<String> escapes, boolean isLocked) throws Exception;
		
	/**
	 * @param name
	 * @param thingName
	 * @throws Exception
	 * 
	 * Nastav� h�e, jak� podm�nky jsou t�eba b�t spln�n� pro �sp�n� dohr�n� hry
	 */
	public void buildFinalCondition(String name, String thingName) throws Exception;
		
	/**
	 * @param roomName
	 * @param thingName
	 * @param thingDesc
	 * @param isMovable
	 * 
	 * Vytv��en� objektu v�c, vlo�en� do m�stnosti a do hry
	 */
	public void buildThing(String roomName, String thingName, String thingDesc, boolean isMovable);
	
	/**
	 * @param roomName
	 * @param thingName
	 * @param thingDesc
	 * @param isMovable
	 * @param canUnlock
	 * 
	 * Vytv��en� objektu v�c, vlo�en� do m�stnosti a do hry, nav�c se jedn� o v�c, kter� m��e odemknout n�jakou m�stnost
	 */
	public void buildThing(String roomName, String thingName, String thingDesc, boolean isMovable, String canUnlock);
		
	/**
	 * @param roomName
	 * @throws Exception
	 * 
	 * Vytvo�en� objektu hr��, nastaven� jeho pozice a um�st�n� do hry
	 */
	public void buildPlayer(String roomName) throws Exception;
	
	public Game getGame();
}
