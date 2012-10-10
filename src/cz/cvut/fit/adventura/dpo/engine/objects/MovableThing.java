package cz.cvut.fit.adventura.dpo.engine.objects;

public class MovableThing extends Thing {

	public MovableThing(String thingName, String thingDesc) {
		super(thingName, thingDesc);
	}
	
	public MovableThing(String thingName, String thingDesc, String canUnlock) {
		super(thingName, thingDesc, canUnlock);
	}	

}
