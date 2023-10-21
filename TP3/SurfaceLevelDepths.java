package nemo;

public class SurfaceLevelDepths extends Surface {
	
	private Surface previousSurfaceLevel;
	
    public SurfaceLevelDepths(Surface previousSurfaceLevel) {
    	this.previousSurfaceLevel = previousSurfaceLevel;
    }
    
    public Surface moveUp() {
    	return previousSurfaceLevel;
    }

	public Surface moveDown() {
		// TODO Auto-generated method stub
		return new SurfaceLevelDepths(this);
	}

	public Surface releaseCapsule() {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede lanzar la cápsula");
	}
	
	public int getDepthLevel() {
		return previousSurfaceLevel.getDepthLevel() + 1;
	}

}
