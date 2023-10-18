package nemo;

public class Nemo {
	
  private Position position;
  private Cardinal facingDirection;
	
  public Nemo(Position position, Cardinal facingDirection) {
	
	this.position = position;
	this.facingDirection = facingDirection;
  }
	
  public Position getCoordenadas() {
  	return position;
  }
  
  public Cardinal getDirection() {
	return facingDirection;
  }
	
  public Nemo Command(String command) {
	for (int i = 0; i < command.length(); i++) {
	  char letra = command.charAt(i);
//	  if (letra == 'u') {
//		this.coordenadas.moveUp();
//	  }
//	  if (letra == 'd') {
//		this.coordenadas.moveDown();
//	  }
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
