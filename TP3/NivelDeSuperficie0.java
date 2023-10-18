package nemo;

public class NivelDeSuperficie0 extends NivelDeSuperficie {

	@Override
	public NivelDeSuperficie moveUp() {
		return this;
	}

	@Override
	public NivelDeSuperficie moveDown() {
		// TODO Auto-generated method stub
		return new NivelDeSuperficie1();
	}

	@Override
	public NivelDeSuperficie lanzarCapsula() {
		// TODO Auto-generated method stub
		return this;
	}

}
