package cz.cvut.fit.adventura.dpo.engine.mvc;

import cz.cvut.fit.adventura.dpo.engine.objects.Player;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;
import cz.cvut.fit.adventura.dpo.engine.objects.Thing;

public class NarratorView implements View {

	public final String INTRO = "*****************************************************************\n" +
								"Ve volnÈm Ëase r·d skl·d·ö puzzle. Aby to bylo o nÏco zajÌmavÏjöÌ,\n" +
								"rozhodl ses jednotlivÈ kousky poh·zet r˘znÏ po bytÏ a zkoumat tedy\n" +
								"nejen to, zda k sobÏ jednotlivÈ dÌlky pasujÌ, ale z·roveÚ je i hledat\n" +
								"v mÌstnostech. Po celodennÌm skl·d·nÌ ti zb˝v· poslednÌ kousek. Ten ale\n" +
								"nem˘ûeö nikde objevit, aù hled·ö jak chceö. NAJDI POSLEDNÕ KUS!\n" +
								"Jakmile jej budeö mÌt, upaluj jej poloûit k ostatnÌm kousk˘m a dokonËit\n" +
								"tak skl·daËku (lze napsat 'help' pro n·povÏdu).\n" +
								"*****************************************************************\n";
	public final String COMMAND_ERROR = "You typed invalid command, try it again...";
	public final String OUTRO = "Thanks for playing our game!";
	public final String HELP = "Commands you can use:\n" +
			"exit - for exit game\n" +
			"go <WHERE> - for walking between rooms\n" +
			"put <WHAT> - for putting down some thing you have in your pocket\n" +
			"take <WHAT> - for taking some thing laying in the room\n" +
			"unlock <ROOM> - for unlocking room which is locked (you need some unlocking object)";

	public final String EXIT_WITH_PARAM = "What do you want to exit? I don't know why you have typed the other word (command is simply 'exit')...";
	public final String EXIT_OK = "You closed the game...";
	public final String GO_NOWHERE = "Where should I go? Type some location";
	public final String GO_LOCKED = "It is LOCKED! I can't go there... need some key.";
	public final String GO_ENTERED = "You entered to the other room...";
	public final String GO_NO = "It's not possible to go to this location...";
	public final String TAKE_CANT = "You can't take this thing... it is fixed in this room.";
	public final String TAKE_MISSING = "That thing is not in this room...";
	public final String UNLOCK_NEED_KEY = "You need to find some thing made for unlocking this doors.";
	public final String UNLOCK_ALREADY_UNLOCKED = "It is not necessary to unlock this room... it is already unlocked.";
	public static final String THING_NOT_FOUND = "This thing does not exist!";
	public static final String ROOM_NOT_FOUND = "Room you want enter does not exist!";
	
	@Override
	public void writeIntro() {
		System.out.println(INTRO);
	}
	
	@Override
	public void writeCommandAcceptsOne(String commandName) {
		System.out.println("Command " + commandName + " accepts only ONE param!");
	}
	
	@Override
	public void writeCommandAcceptsNone(String commandName) {
		System.out.println("Command " + commandName + " accepts NO params... its alone!");
	}
	
	@Override
	public void writePutWhat(Thing putWhat) {
		System.out.println("You put away the '" + putWhat.getName() + "'.");
	}
	
	@Override
	public void writeCantPutThis(Thing putWhat) {
		System.out.println("I don't have thing '" + putWhat.getName()
				+ "' in my pocket... can't to put away it...");
	}
	
	@Override
	public void writeTakeWhat(Thing takeWhat) {
		System.out.println("You took the '" + takeWhat.getName()
				+ "' and inserted it in your pocket.");
	}
	
	@Override
	public void writeUnlockWhat(Room unlockWhat) {
		System.out.println("You unlocked " + unlockWhat.getName()
				+ ". Now you can go there...");
	}
	
	public void writeUnlockNoWay(Room unlockWhat) {
		System.out.println("There leads no way to the '" + unlockWhat.getName() + "'.");
	}

	@Override
	public void writeRoom(Player player) {
		Room actualRoom = player.getWhereAmI();
		System.out
				.println("-------------------------------------------------------");
		System.out.println("You are in the room called: "
				+ actualRoom.getName() + ". " + actualRoom.getDescription());

		if (actualRoom.getEscapes().size() != 0) {
			System.out.println("ESCAPES: "
					+ actualRoom.escapeList());
		}
		if (actualRoom.getThings().size() != 0) {
			System.out.println("THINGS IN THIS ROOM: ");
			System.out.println(actualRoom.thingList());
		}
		if (player.getInventory().size() != 0) {
			System.out.println("YOUR INVENTORY: ");
			System.out.println(player.thingsInInventory());
		} else {
			System.out.println("YOUR INVENTORY: nothing...");
		}
	}

	@Override
	public void writeCommandError() {
		System.out.println(COMMAND_ERROR);
		System.out.println();
	}

	@Override
	public void writeCommandInfo(String executeCommand) {
		System.out.println(executeCommand);
		System.out.println();
	}

	@Override
	public void writeOutro() {
		System.out.println(OUTRO);

	}

	@Override
	public void writeUnlockNeedKey() {
		System.out.println(UNLOCK_NEED_KEY);
		
	}

	@Override
	public void writeUnlockAlreadyUnlocked() {
		System.out.println(UNLOCK_ALREADY_UNLOCKED);
		
	}

	@Override
	public void writeExitOk() {
		System.out.println(EXIT_OK);
		
	}

	@Override
	public void writeTakeCant() {
		System.out.println(TAKE_CANT);
		
	}

	@Override
	public void writeTakeMissing() {
		System.out.println(TAKE_MISSING);
		
	}

	@Override
	public void writeGoLocked() {
		System.out.println(GO_LOCKED);
		
	}

	@Override
	public void writeGoEntered() {
		System.out.println(GO_ENTERED);
		
	}

	@Override
	public void writeGoNo() {
		System.out.println(GO_NO);
		
	}

	@Override
	public void writeHelp() {
		System.out.println(HELP);
	}

}
