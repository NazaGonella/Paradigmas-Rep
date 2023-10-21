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
		return new SurfaceLevelDepths(this);
	}

	public Surface releaseCapsule() {
		throw new RuntimeException(Nemo.Boooooooooom);
	}
	
	public int getDepthLevel() {
		return previousSurfaceLevel.getDepthLevel() + 1;
	}

}
