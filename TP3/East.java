package nemo;

public class East extends Cardinal {

	public Position moveForwardFrom(Position position) {
		return new Position(position.getX() + 1, position.getY());
	}

	public Cardinal rotateRight() {
		return new South();
	}

	public Cardinal rotateLeft() {
		return new North();
	}

}