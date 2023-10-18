package nemo;


public abstract class Cardinal {
	public boolean equals(Object obj) {

		return getClass().equals(obj.getClass());
	}
	public abstract Position moveForwardFrom(Position coordenadas);
	public abstract Cardinal rotateRight();
	public abstract Cardinal rotateLeft();
}
