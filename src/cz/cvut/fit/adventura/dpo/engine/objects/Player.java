package cz.cvut.fit.adventura.dpo.engine.objects;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private Room whereAmI;
	private List<Thing> inventory;		
	
	public Player() {		
		this.inventory = new ArrayList<Thing>();
	}
	public Room getWhereAmI() {
		return whereAmI;
	}
	
	public void addToInventory(Thing thing) {
		inventory.add(thing);
	}
	
	public boolean hasThing(Thing thing) {
		if (inventory.contains(thing)) {
			return true;
		} return false;
	}	
	
	public boolean hasUnlockThing(Room roomToUnlock) {
		for (Thing thing : inventory) {
			if (thing.getCanUnlock().equals(roomToUnlock.getName())) return true;
		}
		return false;
	}		
	
	public void removeThing(Thing thing) {
		inventory.remove(thing);
	}  	
	
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
