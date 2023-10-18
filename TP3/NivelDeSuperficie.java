package nemo;

public abstract class NivelDeSuperficie {
	public boolean equals(Object obj) {

		return getClass().equals(obj.getClass());
	}
	public abstract NivelDeSuperficie moveUp();
	public abstract NivelDeSuperficie moveDown();
	public abstract NivelDeSuperficie lanzarCapsula();
}
