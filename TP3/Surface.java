package nemo;

public abstract class Surface {
	
	public boolean equals(Object obj) { return getClass().equals(obj.getClass()); }
	public abstract Surface moveUp();
	public abstract Surface moveDown();
	public abstract Surface releaseCapsule();
	public abstract int getDepthLevel();
	
}