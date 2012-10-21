package cz.cvut.fit.adventura.dpo;

import java.util.HashSet;
import java.util.Set;

import cz.cvut.fit.adventura.dpo.engine.GameBuilder;
import cz.cvut.fit.adventura.dpo.engine.IGameEngineer;
import cz.cvut.fit.adventura.dpo.engine.mvc.Game;

/**
 * @author bouc2162
 * 
 *         Parametrizace hry. Vytvareni mistnosti, pruchodu, veci, podminek pro
 *         vyhru atd.
 */
public class GameEngineer implements IGameEngineer {

	private GameBuilder gameBuilder;

	public GameEngineer(GameBuilder gameBuilder) {
		this.gameBuilder = gameBuilder;
	}

	@Override
	public Game getGame() {
		return this.gameBuilder.getGame();
	}

	@Override
	public void constructGame() throws Exception {
		Set<String> cil = new HashSet<String>();
		this.gameBuilder.buildRoomFinish("obyvak", "Ob�vac� pokoj. Tak tady skl�d� skl�da�ku...", cil, false);
		cil.add("obyvak");
		this.gameBuilder.buildRoom("kuchyn", "Kuchy�... p�r spot�ebi��, jinak nic moc. Nebo ne?", cil, false);
		this.gameBuilder.buildRoom("koupelna", "Ve vzduchu je vlko a rozpozn�v� nasl�dlou pachu� m�dla.", new HashSet<String>(), true);
		cil.add("kuchyn");
		cil.add("koupelna");
		this.gameBuilder.buildRoom("predsin", "P�eds��, centr�ln� prvek tv�ho bytu. Lze odsud j�t kamkoliv.", cil, false);
		this.gameBuilder.buildThing("kuchyn", "klic", "S t�m by se daly odemknout ur�it� dve�e.", true, "koupelna");
		this.gameBuilder.buildThing("kuchyn", "lednicka", "Lednice... ob�as zahu�� a zavrn�.", false);
		this.gameBuilder.buildThing("koupelna", "sprcha", "Oby�ejn� sprcha s mas�n� hlavic�.", false);
		this.gameBuilder.buildThing("kuchyn", "kolac", "Malinov� kol��... a jak von�.", true);
		this.gameBuilder.buildThing("koupelna", "puzzle", "Osamocen� zubat� kousek puzzle.", true);
		this.gameBuilder.buildPlayer("obyvak");
		this.gameBuilder.buildFinalCondition("obyvak", "puzzle");
	}
}
