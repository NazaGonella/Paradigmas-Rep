package cuatroEnLinea;

public class Winner extends State{
	
	static private String winner;
	
	public Winner(Linea juego) {
		super(juego);
		
		winner = juego.getEstadoDeJuego().getTitle();
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
		return "winner";
	}
	
	static public String getWinner() {
		return winner;
	}
}
