package cz.cvut.fit.adventura.dpo.engine.objects;

/**
 * @author bouc2162
 * 
 * Reprezentuje objekt v�c, kter� se m��e nach�zet ve h�e/m�stnostech, lze jej vkl�dat do sv�ho invent��e,
 * pokl�dat, v ur�it�ch p��padech pou��vat.
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
