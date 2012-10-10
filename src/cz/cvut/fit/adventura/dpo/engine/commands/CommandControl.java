package cz.cvut.fit.adventura.dpo.engine.commands;

//INVOKER command
//http://java.dzone.com/articles/design-patterns-command
public class CommandControl {
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public String executeCommand() throws Exception {
		return command.execute();
	}
}
