package nemo;

public class SurfaceLevel0 extends Surface {

	@Override
	public Surface moveUp() {
		return this;
	}

	@Override
	public Surface moveDown() {
		// TODO Auto-generated method stub
		return new SurfaceLevel1();
	}

	@Override
	public Surface releaseCapsule() {
		// TODO Auto-generated method stub
		return this;
	}

}
