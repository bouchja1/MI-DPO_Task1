package cz.cvut.fit.adventura.dpo.engine.objects;

/**
 * @author bouc2162
 * 
 * Finální a nemìnná podmínka, jejíž splnìní je nutné pro ukonèení hry
 *
 */
public final class FinalCondition {
	private Room room;
	private Thing thing;
	private boolean isAccomplished;
	
	public FinalCondition(Room room, Thing thing) {
		this.room = room;
		this.thing = thing;
		this.isAccomplished = false;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Thing getThing() {
		return thing;
	}
	public void setThing(Thing thing) {
		this.thing = thing;
	}
	public boolean isAccomplished() {
		return isAccomplished;
	}
	public void setAccomplished(boolean isAccomplished) {
		this.isAccomplished = isAccomplished;
	}
	
	
}
