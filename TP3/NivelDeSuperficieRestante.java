package nemo;

public class NivelDeSuperficieRestante extends NivelDeSuperficie {
	
	private NivelDeSuperficie previousSurfaceLevel;
	
    public NivelDeSuperficieRestante(NivelDeSuperficie previousSurfaceLevel) {
    	this.previousSurfaceLevel = previousSurfaceLevel;
    }
    @Override
    public NivelDeSuperficie moveUp() {
    	return previousSurfaceLevel;
    }

	@Override
	public NivelDeSuperficie moveDown() {
		// TODO Auto-generated method stub
		return new NivelDeSuperficieRestante(this);
	}

	@Override
	public NivelDeSuperficie lanzarCapsula() {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede lanzar la cápsula");
	}

}
