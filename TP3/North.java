//package nemo;
//
//public class North extends Coordinate {
//	
//	private int x;
//	private int y;
//	private int z;
//	
//	public North(int x, int y, int z) {
//		super(x, y, z, "North");
//		this.x=x;
//		this.y=y;
//		this.z=z;
//	}
//	
//	public Nemo MoveForward() {
//		return new Nemo(x, y+=1, z, "North");
//	}
//
//}

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