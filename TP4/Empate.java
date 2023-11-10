package cuatroEnLinea;

public class Empate extends State{

	public Empate(Linea juego) {
		super(juego);
	}

	public State changeState() {
		throw new RuntimeException("Game is over");
	}

	public char getToken() {
		return 0;
	}

	public void jugarRojo(int column) {
		throw new RuntimeException("Game is over");
	}

	public void jugarAzul(int column) {
		throw new RuntimeException("Game is over");
	}
	
	public boolean isGameOver() {
		return true;
	}

	public String getTitle() {
		return "It's a tie";
	}
	
}
