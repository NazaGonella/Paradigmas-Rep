package cuatroEnLinea;

public class Winner extends StateOfGame{
	
	private String winner;
	
	public Winner(String winner) {
		this.winner = winner;
	}

	public char getToken() {
		return 0;
	}

	public StateOfGame jugarRojo(Linea juego, int column) {
		throw new RuntimeException(GameIsOver);
	}

	public StateOfGame jugarAzul(Linea juego, int column) {
		throw new RuntimeException(GameIsOver);
	}

	public String getTitle() {
		return WinMessage + winner;
	}
	
	public boolean isGameFinished() {
		return true;
	}
	
}
