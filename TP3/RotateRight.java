package nemo;

public class RotateRight extends Command {

	public void execute(Nemo nemo) {
		nemo.rotateRight();
	}
	
	public boolean isCommand(char command) {
		return 'r' == command;
	}

}
