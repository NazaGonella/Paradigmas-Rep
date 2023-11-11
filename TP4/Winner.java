package cuatroEnLinea;

public class Winner extends State{
	
	private String winner;
	
	public Winner(String winner) {
		this.winner = winner;
	}

	public State changeTurno() {
		throw new RuntimeException("Game is over");
	}

	public char getToken() {
		return 0;
	}

	public void jugarRojo(Linea juego, int column) {
		throw new RuntimeException("Game is over");
	}

	public void jugarAzul(Linea juego, int column) {
		throw new RuntimeException("Game is over");
	}

	public String getTitle() {
		return "El ganador es " + winner;
	}
	
	
}
