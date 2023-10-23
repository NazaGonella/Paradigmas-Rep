package nemo;

public class MoveUp extends Command {

	public void execute(Nemo nemo) {
		nemo.moveUp();
	}

	public boolean isCommand(char command) {
		return 'u' == command;
	}

}
