package cz.cvut.fit.adventura.dpo.engine;

import cz.cvut.fit.adventura.dpo.engine.commands.Command;
import cz.cvut.fit.adventura.dpo.engine.commands.CommandFactory;

//vytvari komandy
public class GameCommandParser {	
	
	private Game game;	

	public GameCommandParser(Game game) {
		this.game = game;
	}

	public Command parseCommand(String inputLine) {
		//tady se provede rozparsovani inputu, validace a volani novych prikazu
        String [] parsedInput = inputLine.split("[ \t]+"); //space or tab occurs one or more times 
        String commandString = parsedInput[0];
        
        String [] commandParams = new String[parsedInput.length-1];
        
        for (int i = 0 ; i < commandParams.length; i++) {
        	commandParams[i] = parsedInput[i+1];   
        }        
        
        Command command = CommandFactory.getCommand(commandString, game, commandParams, game.getModel());
        
        return command;
	}
	

}
