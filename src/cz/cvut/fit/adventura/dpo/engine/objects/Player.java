package cz.cvut.fit.adventura.dpo.engine.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bouc2162
 * 
 * Reprezentuje objekt hr��, kter� v� o sv� pozici a vlastn� invent��, do kter�ho si lze vkl�dat v�ci
 *
 */
public class Player {
	private Room whereAmI;
	private List<Thing> inventory;		
	
	public Player() {		
		this.inventory = new ArrayList<Thing>();
	}
	
	/**
	 * @return vrac� aktu�ln� hr��skou pozici ve h�e
	 */
	public Room getWhereAmI() {
		return whereAmI;
	}
	
	/**
	 * @param thing
	 * 
	 * vkl�d� v�c do hr��ova invent��e
	 */
	public void addToInventory(Thing thing) {
		inventory.add(thing);
	}
	
	/**
	 * @param thing
	 * @return kontrola, zda hr�� ji� nevlastn� tuto v�c
	 */
	public boolean hasThing(Thing thing) {
		if (inventory.contains(thing)) {
			return true;
		} return false;
	}	
	
	/**
	 * @param roomToUnlock
	 * @return kontrola, zda hr�� vlastn� v�c ur�enou k odemyk�n� konkr�tn� m�stnosti
	 */
	public boolean hasUnlockThing(Room roomToUnlock) {
		for (Thing thing : inventory) {
			if (thing.getCanUnlock().equals(roomToUnlock.getName())) return true;
		}
		return false;
	}		
	
	/**
	 * @param thing
	 * 
	 * odstran�n� v�ci z hr��ova invent��e
	 */
	public void removeThing(Thing thing) {
		inventory.remove(thing);
	}  	
	
	/**
	 * @return vrac� seznam v�c� v hr��ov� invent��i
	 */
	public String thingsInInventory() {
		String t = "";
		for (Thing thing : inventory) {
			System.out.println("'" + thing.getName() + "' - " + thing.getDescription());
		}
		return t;
	}	
	
	public void setWhereAmI(Room whereAmI) {
		this.whereAmI = whereAmI;
	}
	public List<Thing> getInventory() {
		return inventory;
	}
	public void setInventory(List<Thing> inventory) {
		this.inventory = inventory;
	}
	
	
}
