package nemo;

public class North extends Cardinal {
	
	public Position moveForwardFrom(Position position) {
		return new Position(position.getX(), position.getY() + 1);
	}
	
	public Cardinal rotateRight() {
		return new East();
	}

	public Cardinal rotateLeft() {
		return new West();
	}

}