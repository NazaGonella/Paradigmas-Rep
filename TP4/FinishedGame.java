package cuatroEnLinea;

public class FinishedGame extends State {

	public FinishedGame(Linea juego) {
		super(juego);
	}

	public State changeState() {
		return this;
	}

	public char getToken() {
		return 0;
	}

	public void jugarRojo(int column) {
		throw new RuntimeException("Juego terminado");
	}

	public void jugarAzul(int column) {
		throw new RuntimeException("Juego terminado");
	}
	
}
