package nemo;

public class MoveForward extends Command {

	public void execute(Nemo nemo) {
		nemo.moveForward();
	}
	
	public boolean applies(char command) {
		return'f' == command;
	}

}
