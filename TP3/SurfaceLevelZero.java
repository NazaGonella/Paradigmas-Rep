package nemo;

public class SurfaceLevelZero extends Surface {

	public Surface moveUp() {
		return this;
	}

	public Surface moveDown() {
		return new SurfaceLevelOne();
	}
	
	public Surface releaseCapsule() {
		return this;
	}
	
	public int getDepthLevel() {
		return 0;
	}
	
}
