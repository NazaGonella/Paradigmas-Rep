package nemo;

public class South extends Cardinal {

	public Position moveForwardFrom(Position position) {
		return new Position(position.getX(), position.getY() - 1);
	}

	public Cardinal rotateRight() {
		return new West();
	}

	public Cardinal rotateLeft() {
		return new East();
	}

}