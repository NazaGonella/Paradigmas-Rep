package nemo;

public class MoveUp extends Command {

	public void execute(Nemo nemo) {
		nemo.moveUp();
	}

	public boolean applies(char command) {
		return 'u' == command;
	}

}
