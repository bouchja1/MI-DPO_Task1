package cz.cvut.fit.adventura.dpo.engine.commands;

/**
 * @author bouc2162
 * 
 * Command v patternu Command. Specifikuje metodu, je� maj� prov�d�t ve�ker� konkr�tn� commandy.
 *
 */
public interface Command {
	
	/**
	 * @throws Exception
	 * 
	 * Metoda pro vykon�n� p��kazu. Ka�d� konkr�tn� command ji implementuje jinak
	 */
	public void execute() throws Exception;
}
