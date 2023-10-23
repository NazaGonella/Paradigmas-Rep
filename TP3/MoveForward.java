package nemo;

public class MoveForward extends Command {

	public void execute(Nemo nemo) {
		nemo.moveForward();
	}
	
	public boolean isCommand(char command) {
		return'f' == command;
	}

}
