package nemo;

public class SurfaceLevel1 extends Surface {

	@Override
	public Surface moveUp() {
		// TODO Auto-generated method stub
		//return new NivelDeSuperficie0();
		return new SurfaceLevel0();
	}

	@Override
	public Surface moveDown() {
		// TODO Auto-generated method stub
		return new SurfaceLevelDepths(this);
	}

	@Override
	public Surface releaseCapsule() {
		// TODO Auto-generated method stub
		return this;
	}

}
