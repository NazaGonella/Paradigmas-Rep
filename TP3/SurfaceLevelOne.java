package nemo;

public class SurfaceLevelOne extends Surface {

	public Surface moveUp() {
		return new SurfaceLevelZero();
	}

	public Surface moveDown() {
		return new SurfaceLevelDepths(this);
	}

	public Surface releaseCapsule() {
		return this;
	}
	
	public int getDepthLevel() {
		return 1;
	}

}
