package nemo;

public class NivelDeSuperficie1 extends NivelDeSuperficie {

	@Override
	public NivelDeSuperficie moveUp() {
		// TODO Auto-generated method stub
		//return new NivelDeSuperficie0();
		return new NivelDeSuperficie0();
	}

	@Override
	public NivelDeSuperficie moveDown() {
		// TODO Auto-generated method stub
		return new NivelDeSuperficieRestante(this);
	}

	@Override
	public NivelDeSuperficie lanzarCapsula() {
		// TODO Auto-generated method stub
		return this;
	}

}
