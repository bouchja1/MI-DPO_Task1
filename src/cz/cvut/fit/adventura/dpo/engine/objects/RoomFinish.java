package cz.cvut.fit.adventura.dpo.engine.objects;

import java.util.HashSet;
import java.util.Set;

public class RoomFinish extends Room {

	private Set<FinalCondition> conditions;
	
	public RoomFinish(String roomName, String description, boolean isLocked) {
		super(roomName, description, isLocked);
		conditions = new HashSet<FinalCondition>();
	}

	public void addCondition(FinalCondition fc) {
		conditions.add(fc);
	}
	
	public boolean possibleEndGame() {
		boolean possible = true;
		for (FinalCondition c : conditions) {
			if (!c.isAccomplished()) {
				possible = false;
			}
		}
		return possible;
	}

	public Set<FinalCondition> getConditions() {
		return conditions;
	}
	
	
}
