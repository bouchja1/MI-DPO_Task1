package cz.cvut.fit.adventura.dpo.engine;

import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class NarratorView {

	public static final String INTRO = "Tady bude seznameni s hrou a mozne prikazy.";
	public static final String COMMAND_ERROR = "You typed invalid command, try it again...";
	public static final String OUTRO = "Thanks for playing our game!";

	public static final String EXIT_WITH_PARAM = "What do you want to exit? I don't know why you have typed the other word (command is simply 'exit')...";
	public static final String EXIT_OK = "You closed the game...";
	public static final String GO_NOWHERE = "Where should I go? Type some location";
	public static final String GO_LOCKED = "It is LOCKED! I can't go there... need some key.";
	public static final String GO_ENTERED = "You entered to the other room...";
	public static final String GO_NO = "It's not possible to go to this location...";
	public static final String TAKE_CANT = "You can't take this thing... it is fixed in this room.";
	public static final String TAKE_MISSING = "That thing is not in this room...";
	public static final String UNLOCK_NEED_KEY = "You need to find some thing made for unlocking this doors.";
	public static final String UNLOCK_ALREADY_UNLOCKED = "It is not necessary to unlock this room... it is already unlocked.";
	public static final String THING_NOT_FOUND = "This thing does not exist!";
	public static final String ROOM_NOT_FOUND = "Thing you want enter does not exist!";
	
	public static void writeIntro() {
		System.out.println(INTRO);
	}
	
	public static void writeCommandAcceptsOne(String commandName) {
		System.out.println("Command " + commandName + " accepts only ONE param!");
	}
	
	public static void writeCommandAcceptsNone(String commandName) {
		System.out.println("Command " + commandName + " accepts NO params... its alone!");
	}
	
	public static String writePutWhat(Thing putWhat) {
		return "You put away the '" + putWhat.getName() + "'.";
	}
	
	public static String writeCantPutThis(Thing putWhat) {
		return "I don't have thing '" + putWhat.getName()
		+ "' in my pocket... can't to put away it...";
	}
	
	public static String writeTakeWhat(Thing takeWhat) {
		return "You took the '" + takeWhat.getName()
		+ "' and inserted it in your pocket.";
	}
	
	public static String writeUnlockWhat(Room unlockWhat) {
		return "You unlocked " + unlockWhat.getName()
		+ ". Now you can go there...";
	}
	
	public static String writeUnlockNoWay(Room unlockWhat) {
		return "There leads no way to the '" + unlockWhat.getName() + "'.";
	}

	public static void writeRoom(Player player) {
		Room actualRoom = player.getWhereAmI();
		System.out
				.println("-------------------------------------------------------");
		System.out.println("Nyni se nachazis v mistnosti: "
				+ actualRoom.getName() + ". " + actualRoom.getDescription());

		if (actualRoom.getEscapes().size() != 0) {
			System.out.println("Mozne vychody odsud jsou: "
					+ actualRoom.escapeList());
		}
		if (actualRoom.getThings().size() != 0) {
			System.out.println("V mistnosti se nachazeji nasledujici veci: ");
			System.out.println(actualRoom.thingList());
		}
		if (player.getInventory().size() != 0) {
			System.out.println("My INVENTORY: ");
			System.out.println(player.thingsInInventory());
		} else {
			System.out.println("My INVENTORY: nothing...");
		}
	}

	public static void writeCommandError() {
		System.out.println(COMMAND_ERROR);
		System.out.println();
	}

	public static void writeCommandInfo(String executeCommand) {
		System.out.println(executeCommand);
		System.out.println();
	}

	public static void writeOutro() {
		System.out.println(OUTRO);

	}

}
