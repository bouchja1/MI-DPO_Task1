package cz.cvut.fit.adventura.dpo.engine.commands;
import cz.cvut.fit.adventura.dpo.engine.mvc.Model;
import cz.cvut.fit.adventura.dpo.engine.mvc.View;
import cz.cvut.fit.adventura.dpo.engine.objects.Room;

public class CommandGo implements Command {

	private Model model;
	private View view;
	private Room roomToGo;

	public CommandGo(Model model, View view, Room roomToGo) {
		this.model = model;
		this.view = view;
		this.roomToGo = roomToGo;
	}

	@Override
	public void execute() {
		Room actualRoom = model.getPlayer().getWhereAmI();

			if (actualRoom.getEscapes().contains(roomToGo)) {
				if (roomToGo.isLocked()) {
					view.writeGoLocked();
				} else {
					model.getPlayer().setWhereAmI(roomToGo);
					view.writeGoEntered();
				}
			} else {
				view.writeGoNo();
			}
	}

}
