package cz.cvut.fit.adventura.dpo.engine.mvc;

import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

/**
 * @author bouc2162
 * 
 * View. Stará se o veškerý textový výpis hlášek ve høe
 *
 */
public interface View {
	public void writeIntro();
	
	public void writeCommandAcceptsOne(String commandName);
	
	public void writeCommandAcceptsNone(String commandName);
	
	public void writePutWhat(Thing putWhat);
	
	public void writeCantPutThis(Thing putWhat);
	
	public void writeTakeWhat(Thing takeWhat);
	
	public void writeUnlockWhat(Room unlockWhat);
	
	public void writeUnlockNoWay(Room unlockWhat);

	public void writeRoom(Player player);

	public void writeCommandError();

	public void writeCommandInfo(String executeCommand);

	public void writeOutro();
	
	public void writeUnlockNeedKey();

	public void writeUnlockAlreadyUnlocked();

	public void writeExitOk();

	public void writeTakeCant();

	public void writeTakeMissing();

	public void writeGoLocked();

	public void writeGoEntered();

	public void writeGoNo();

	public void writeHelp();
}
