package cuatroEnLinea;

public class Empate extends StateOfGame{

	public char getToken() {
		return 0;
	}

	public StateOfGame jugarRojo(Linea juego, int column) {
		throw new RuntimeException(GameIsOver);
	}

	public StateOfGame jugarAzul(Linea juego, int column) {
		throw new RuntimeException(GameIsOver);
	}
	
	public boolean isGameFinished() {
		return true;
	}

	public String getTitle() {
		return ItsADraw;
	}
	
}
