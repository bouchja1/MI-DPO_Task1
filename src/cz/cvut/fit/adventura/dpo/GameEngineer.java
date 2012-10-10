package cz.cvut.fit.adventura.dpo;

import java.util.HashSet;
import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.Game;
import cz.cvut.fit.adventura.dpo.engine.GameBuilder;



public class GameEngineer {
	
	  private GameBuilder gameBuilder;
	  
	  public GameEngineer(GameBuilder gameBuilder){
	    this.gameBuilder = gameBuilder;
	  }
	 
	  public Game getGame() {
	    return this.gameBuilder.getGame();
	  }
	 
	  public void constructGame() throws Exception {		
	    this.gameBuilder.buildRoom("start", "start", new HashSet<String>(), false);
	    Set<String> cil = new HashSet<String>();
	    cil.add("start");
	    this.gameBuilder.buildRoomFinish("cil", "cil", cil, true);	
	    this.gameBuilder.buildThing("start", "pc", "komp", false);
	    this.gameBuilder.buildThing("start", "key", "key...", true, "cil");
	    this.gameBuilder.buildThing("start", "fakekey", "key...", true, "start");
	    this.gameBuilder.buildPlayer("start");
	    this.gameBuilder.buildFinalCondition("cil", "fakekey");
	  }
}
