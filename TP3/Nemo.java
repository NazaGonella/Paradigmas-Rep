package nemo;

public class Nemo {
	
  private Position position;
  private Cardinal facingDirection;
  private NivelDeSuperficie nivelDeSuperficie;
	
  public Nemo(Position position, Cardinal facingDirection) {
	
	this.position = position;
	this.facingDirection = facingDirection;
	nivelDeSuperficie = new NivelDeSuperficie0();
  }
	
  public Position getPosition() {
  	return position;
  }
  public Cardinal getDirection() {
	return facingDirection;
  }
  public NivelDeSuperficie getSurfaceLevel() {
	return nivelDeSuperficie;
  }
	
  public Nemo Command(String command) {
	for (int i = 0; i < command.length(); i++) {
	  char letra = command.charAt(i);
	  if (letra == 'u') {
		nivelDeSuperficie = nivelDeSuperficie.moveUp();  	
	  }
	  if (letra == 'd') {
		nivelDeSuperficie = nivelDeSuperficie.moveDown();
	  }
	  if (letra == 'm') {
		nivelDeSuperficie = nivelDeSuperficie.lanzarCapsula();
	  }
	  if (letra == 'f') {
		position = facingDirection.moveForwardFrom(position);
	  }
	  if (letra == 'r') {
		facingDirection = facingDirection.rotateRight();
	  }
	  if (letra == 'l') {
		facingDirection = facingDirection.rotateLeft();
	  }
	}
	return this;
	
  }
  
}
