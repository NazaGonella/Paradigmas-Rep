//package nemo;
//
//public class West extends Nemo {
//	
//	private int x;
//	private int y;
//	private int z;
//	private String angle;
//	
//	public West(int x, int y, int z, String angle) {
//		super(x, y, z, angle);
//		this.x=x;
//		this.y=y;
//		this.z=z;
//		this.angle=angle;
//	}
//	
//	public Nemo MoveForward() {
//		return new Nemo(x-=1, y, z, angle);
//	}
//
//}

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