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
		this.gameBuilder.buildRoomFinish("obyvak", "Obıvací pokoj. Tak tady skládáš skládaèku...", cil, false);
		cil.add("obyvak");
		this.gameBuilder.buildRoom("kuchyn", "Kuchyò... pár spotøebièù, jinak nic moc. Nebo ne?", cil, false);
		this.gameBuilder.buildRoom("koupelna", "Ve vzduchu je vlko a rozpoznáváš nasládlou pachu mıdla.", new HashSet<String>(), true);
		cil.add("kuchyn");
		cil.add("koupelna");
		this.gameBuilder.buildRoom("predsin", "Pøedsíò, centrální prvek tvého bytu. Lze odsud jít kamkoliv.", cil, false);
		this.gameBuilder.buildThing("kuchyn", "klic", "S tím by se daly odemknout urèité dveøe.", true, "koupelna");
		this.gameBuilder.buildThing("kuchyn", "lednicka", "Lednice... obèas zahuèí a zavrní.", false);
		this.gameBuilder.buildThing("koupelna", "sprcha", "Obyèejná sprcha s masání hlavicí.", false);
		this.gameBuilder.buildThing("kuchyn", "kolac", "Malinovı koláè... a jak voní.", true);
		this.gameBuilder.buildThing("koupelna", "puzzle", "Osamocenı zubatı kousek puzzle.", true);
		this.gameBuilder.buildPlayer("obyvak");
		this.gameBuilder.buildFinalCondition("obyvak", "puzzle");
	}
}
