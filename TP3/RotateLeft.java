package nemo;

public class RotateLeft extends Command {

	public void execute(Nemo nemo) {
		nemo.rotateLeft();
	}
	
	public boolean isCommand(char command) {
		return 'l' == command;
	}
	
}
