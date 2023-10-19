package nemo;

public abstract class Command {
	
	public abstract void execute(Nemo nemo);
	public abstract boolean applies(char command);
}
