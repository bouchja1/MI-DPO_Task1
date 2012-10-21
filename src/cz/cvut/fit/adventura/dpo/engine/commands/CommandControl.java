package cz.cvut.fit.adventura.dpo.engine.commands;

//INVOKER command
//http://java.dzone.com/articles/design-patterns-command

/**
 * @author bouc2162
 * 
 * Invoker dle patternu Command. Uchov�v� p��kaz a podn�cuje ho k vykon�n� vol�n�m metody execute
 *
 */
public class CommandControl {
	private Command command;
		
	/**
	 * @param command
	 * 
	 * Nastaven� konkr�tn�ho Commandu
	 */
	public void setCommand(Command command) {
		this.command = command;
	}
	
	/**
	 * @throws Exception
	 * 
	 * Vykon�n� commandu
	 */
	public void executeCommand() throws Exception {
		command.execute();
	}
}
