package nemo;

public class Position {
	private int x;
	private int y;

public Position(int x, int y) {
	
	this.x=x;
	this.y=y;
}
	public int getY() {
		return this.y;
	}
	public int getX() {
		
		return this.x;
	}
	public int[] position() {
	    int x = this.getX(); 
	    int y = this.getY();
	    int[] resultado = {x, y};
		    
		return resultado;
	}
}
