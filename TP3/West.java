package nemo;

public class West extends Cardinal {

	public Position moveForwardFrom(Position position) {
		return new Position(position.getX() - 1, position.getY());
	}

	public Cardinal rotateRight() {
		return new North();
	}

	public Cardinal rotateLeft() {
		return new South();
	}

}