//package nemo;
//
//public class East extends Nemo {
//	
//	private int x;
//	private int y;
//	private int z;
//	private String angle;
//	
//	public East(int x, int y, int z, String angle) {
//		super(x, y, z, angle);
//		this.x=x;
//		this.y=y;
//		this.z=z;
//		this.angle=angle;
//	}
//	
//	public Nemo MoveForward() {
//		return new Nemo(x+=1, y, z, angle);
//	}
//
//}

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