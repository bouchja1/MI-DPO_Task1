package cz.cvut.fit.adventura.dpo.engine.objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bouc2162
 * 
 * Reprezentuje objekt místnost, který se mùže nacházet ve høe, lze jím procházet do dalších místností,
 * odemykat jej...
 *
 */
public class Room {

	private String name;
	private String description;
	private List<Thing> things;
	private Set<Room> escapes;
	private boolean isLocked;
	
	public Room(String roomName, String description, boolean isLocked) {
		this.name = roomName;
		this.description = description;
		this.escapes = new HashSet<Room>();
		this.things = new ArrayList<Thing>();
		this.isLocked = isLocked;
	}

	public void addThing(Thing thing) {
		things.add(thing);
	}
	
	/**
	 * @return seznam vìcí v místnosti
	 */
	public String thingList() {
		String t = "";
		for (Thing thing : things) {
			System.out.println("'" + thing.getName() + "' - " + thing.getDescription());
		}
		return t;
	}
	
	/**
	 * @param thing
	 * @return kontrola, zda místnost obsahuje takovou vìc
	 */
	public boolean containsThing(Thing thing) {
		if (things.contains(thing)) {
			return true;
		}
		return false;
	}
	
    /**
     * @return vrací možné východy z místnosti
     */
    public String escapeList() {
    	String t = "";
        for (Room neighbors : escapes) {
        	if (neighbors.isLocked()) {
        		t += " " + neighbors.getName() + "[LOCKED]";
        	} else {
        		t += " " + neighbors.getName();    
        	}
        }
        return t;
    }	

	/**
	 * @param thing
	 * 
	 * Odstraòuje vìc z místnosti, napø. pøi vložení do inventáøe
	 */
	public void removeThing(Thing thing) {
		things.remove(thing);
	}    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Thing> getThings() {
		return things;
	}

	public void setThings(List<Thing> things) {
		this.things = things;
	}

	public void addEscape(Room escape) {
		escapes.add(escape);
	}

	public Set<Room> getEscapes() {
		return escapes;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}	
	
	
	
	
}
