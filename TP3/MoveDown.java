package nemo;

public class MoveDown extends Command {

	public void execute(Nemo nemo) {
		
		nemo.moveDown();
	}

	public boolean applies(char command) {
		return 'd' == command;
	}

}
