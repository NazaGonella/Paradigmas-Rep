//package nemo;
//
//public class South extends Nemo {
//	
//	private int x;
//	private int y;
//	private int z;
//	private String angle;
//	
//	public South(int x, int y, int z, String angle) {
//		super(x, y, z, angle);
//		this.x=x;
//		this.y=y;
//		this.z=z;
//		this.angle=angle;
//	}
//	
//	public Nemo MoveForward() {
//		return new Nemo(x, y-=1, z, angle);
//	}
//
//}

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