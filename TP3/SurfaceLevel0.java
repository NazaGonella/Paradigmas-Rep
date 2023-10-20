package nemo;

public class SurfaceLevel0 extends Surface {

	public Surface moveUp() {
		return this;
	}

	public Surface moveDown() {
		// TODO Auto-generated method stub
		return new SurfaceLevel1();
	}

	public Surface releaseCapsule() {
		// TODO Auto-generated method stub
		return this;
	}

	public int getDepth() {
		return 0;
	}

}
