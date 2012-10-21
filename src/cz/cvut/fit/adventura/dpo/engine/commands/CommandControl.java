package cz.cvut.fit.adventura.dpo.engine.commands;

//INVOKER command
//http://java.dzone.com/articles/design-patterns-command

/**
 * @author bouc2162
 * 
 * Invoker dle patternu Command. Uchovává pøíkaz a podnìcuje ho k vykonání voláním metody execute
 *
 */
public class CommandControl {
	private Command command;
		
	/**
	 * @param command
	 * 
	 * Nastavení konkrétního Commandu
	 */
	public void setCommand(Command command) {
		this.command = command;
	}
	
	/**
	 * @throws Exception
	 * 
	 * Vykonání commandu
	 */
	public void executeCommand() throws Exception {
		command.execute();
	}
}
