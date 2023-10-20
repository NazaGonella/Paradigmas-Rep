package nemo;

public class SurfaceLevel1 extends Surface {

	public Surface moveUp() {
		// TODO Auto-generated method stub
		//return new NivelDeSuperficie0();
		return new SurfaceLevel0();
	}

	public Surface moveDown() {
		// TODO Auto-generated method stub
		return new SurfaceLevelDepths(this);
	}

	public Surface releaseCapsule() {
		// TODO Auto-generated method stub
		return this;
	}

	public int getDepth() {
		return 1;
	}

}
