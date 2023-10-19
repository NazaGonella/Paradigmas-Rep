package nemo;

public class SurfaceLevelDepths extends Surface {
	
	private Surface previousSurfaceLevel;
	
    public SurfaceLevelDepths(Surface previousSurfaceLevel) {
    	this.previousSurfaceLevel = previousSurfaceLevel;
    }
    @Override
    public Surface moveUp() {
    	return previousSurfaceLevel;
    }

	@Override
	public Surface moveDown() {
		// TODO Auto-generated method stub
		return new SurfaceLevelDepths(this);
	}

	@Override
	public Surface releaseCapsule() {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede lanzar la cápsula");
	}

}
