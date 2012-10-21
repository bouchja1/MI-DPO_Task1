package cz.cvut.fit.adventura.dpo.engine;

import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.mvc.Game;

/**
 * @author bouc2162
 * 
 * Stavìní hry, pattern Builder
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
	 * Vytvoøí místnost, nastaví východu do dalších a pøidá ji do hry
	 */
	public void buildRoom(String roomName, String description, Set<String> escapes, boolean isLocked) throws Exception;
	
	
	/**
	 * @param roomName
	 * @param description
	 * @param escapes
	 * @param isLocked
	 * @throws Exception
	 * 
	 * Vytvoøí místnost, nastaví východy, pøidá ji do hry a rozhodne o tom, že hra je již spustitelná (pøítomna cílová místnost)
	 */
	public void buildRoomFinish(String roomName, String description, Set<String> escapes, boolean isLocked) throws Exception;
		
	/**
	 * @param name
	 * @param thingName
	 * @throws Exception
	 * 
	 * Nastaví høe, jaké podmínky jsou tøeba být splnìné pro úspìšné dohrání hry
	 */
	public void buildFinalCondition(String name, String thingName) throws Exception;
		
	/**
	 * @param roomName
	 * @param thingName
	 * @param thingDesc
	 * @param isMovable
	 * 
	 * Vytváøení objektu vìc, vložení do místnosti a do hry
	 */
	public void buildThing(String roomName, String thingName, String thingDesc, boolean isMovable);
	
	/**
	 * @param roomName
	 * @param thingName
	 * @param thingDesc
	 * @param isMovable
	 * @param canUnlock
	 * 
	 * Vytváøení objektu vìc, vložení do místnosti a do hry, navíc se jedná o vìc, která mùže odemknout nìjakou místnost
	 */
	public void buildThing(String roomName, String thingName, String thingDesc, boolean isMovable, String canUnlock);
		
	/**
	 * @param roomName
	 * @throws Exception
	 * 
	 * Vytvoøení objektu hráè, nastavení jeho pozice a umístìní do hry
	 */
	public void buildPlayer(String roomName) throws Exception;
	
	public Game getGame();
}
