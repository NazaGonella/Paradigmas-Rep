package cuatroEnLinea;

public class Empate extends State{

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
		return "It's a tie";
	}
	
}
