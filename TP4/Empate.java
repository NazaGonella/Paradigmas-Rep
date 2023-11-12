package cuatroEnLinea;

public class Empate extends State{

	public char getToken() {
		return 0;
	}

	public State jugarRojo(Linea juego, int column) {
		throw new RuntimeException(GameIsOver);
	}

	public State jugarAzul(Linea juego, int column) {
		throw new RuntimeException(GameIsOver);
	}
	
	public boolean isGameFinished() {
		return true;
	}

	public String getTitle() {
		return ItsADraw;
	}
	
}
