package cz.cvut.fit.adventura.dpo.engine.commands;

/**
 * @author bouc2162
 * 
 * Command v patternu Command. Specifikuje metodu, jež mají provádìt veškeré konkrétní commandy.
 *
 */
public interface Command {
	
	/**
	 * @throws Exception
	 * 
	 * Metoda pro vykonání pøíkazu. Každý konkrétní command ji implementuje jinak
	 */
	public void execute() throws Exception;
}
