package nemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Nemo {
	
  public static String Boooooooooom = "BOOOOOOOOOOM";
  private Position position;
  private Cardinal facingDirection;
  private Surface nivelDeSuperficie;
  private ArrayList<Command> commands = new ArrayList<>(Arrays.asList(
	  new MoveUp(), 
	  new MoveDown(), 
	  new ReleaseCapsule(), 
	  new MoveForward(), 
	  new RotateRight(), 
	  new RotateLeft()));
	
  public Nemo(Position position, Cardinal facingDirection) {
	this.position = position;
	this.facingDirection = facingDirection;
	nivelDeSuperficie = new SurfaceLevelZero();
  }
	
  public Position getPosition() {
  	return position;
  }
  public Cardinal getDirection() {
	return facingDirection;
  }
  public Surface getSurfaceLevel() {
	return nivelDeSuperficie;
  }
	
  public Nemo Command(String commands) {
	commands.chars().mapToObj(letra -> (char) letra).forEach(this::ApplyCommand);
	return this;
  }
  
  public void ApplyCommand(char singleCommand) {
	  commands.stream().filter(comando -> comando.applies(singleCommand)).forEach(comando -> comando.execute(this));;
  }
  
  public void moveUp() {
	nivelDeSuperficie = nivelDeSuperficie.moveUp();  
  }
  public void moveDown() {
	nivelDeSuperficie = nivelDeSuperficie.moveDown();
  }
  public void releaseCapsule() {
	nivelDeSuperficie = nivelDeSuperficie.releaseCapsule();
  }
  public void moveForward() {
	position = facingDirection.moveForwardFrom(position);
  }
  public void rotateRight() {
	facingDirection = facingDirection.rotateRight();
  }
  public void rotateLeft() {
	facingDirection = facingDirection.rotateLeft();
  }
  
}
