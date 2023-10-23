package nemo;

public class MoveDown extends Command {

	public void execute(Nemo nemo) {
		nemo.moveDown();
	}

	public boolean isCommand(char command) {
		return 'd' == command;
	}

}
