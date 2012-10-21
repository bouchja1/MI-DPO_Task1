package cz.cvut.fit.adventura.dpo.engine.objects;

/**
 * @author bouc2162
 * 
 * Reprezentuje objekt vìc, který se mùže nacházet ve høe/místnostech, lze jej vkládat do svého inventáøe,
 * pokládat, v urèitých pøípadech používat.
 *
 */
public abstract class Thing {	
	private String name;
	private String description;
	private String canUnlock;
	
	public Thing(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Thing(String name, String description, String canUnlock) {
		this.name = name;
		this.description = description;
		this.canUnlock = canUnlock;
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

	public String getCanUnlock() {
		return canUnlock;
	}

	public void setCanUnlock(String canUnlock) {
		this.canUnlock = canUnlock;
	}


	
	
}
