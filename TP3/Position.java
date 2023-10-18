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
	public boolean equals(Object obj) {
		return getClass().equals(obj.getClass());
	}
}
