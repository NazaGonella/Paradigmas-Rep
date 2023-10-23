package nemo;

public class ReleaseCapsule extends Command {

	public void execute(Nemo nemo) {
		nemo.releaseCapsule();
	}
	
	public boolean isCommand(char command) {
		return 'm' == command;
	}

}
