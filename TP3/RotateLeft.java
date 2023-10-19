package nemo;

public class RotateLeft extends Command {

	public void execute(Nemo nemo) {
		
		nemo.rotateLeft();
	}
	
	public boolean applies(char command) {
		return 'l' == command;
	}
}
