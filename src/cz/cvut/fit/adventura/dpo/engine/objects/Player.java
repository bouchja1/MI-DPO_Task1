package cz.cvut.fit.adventura.dpo.engine.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bouc2162
 * 
 * Reprezentuje objekt hráè, který ví o své pozici a vlastní inventáø, do kterého si lze vkládat vìci
 *
 */
public class Player {
	private Room whereAmI;
	private List<Thing> inventory;		
	
	public Player() {		
		this.inventory = new ArrayList<Thing>();
	}
	
	/**
	 * @return vrací aktuální hráèskou pozici ve høe
	 */
	public Room getWhereAmI() {
		return whereAmI;
	}
	
	/**
	 * @param thing
	 * 
	 * vkládá vìc do hráèova inventáøe
	 */
	public void addToInventory(Thing thing) {
		inventory.add(thing);
	}
	
	/**
	 * @param thing
	 * @return kontrola, zda hráè již nevlastní tuto vìc
	 */
	public boolean hasThing(Thing thing) {
		if (inventory.contains(thing)) {
			return true;
		} return false;
	}	
	
	/**
	 * @param roomToUnlock
	 * @return kontrola, zda hráè vlastní vìc urèenou k odemykání konkrétní místnosti
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
	 * odstranìní vìci z hráèova inventáøe
	 */
	public void removeThing(Thing thing) {
		inventory.remove(thing);
	}  	
	
	/**
	 * @return vrací seznam vìcí v hráèovì inventáøi
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
