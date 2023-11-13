package cuatroEnLinea;

public class JuegaRojo extends StateOfGame{

	public char getToken() {
		return teamRedToken;
	}

	public StateOfGame jugarRojo(Linea juego, int promptAsInt) {
		juego.jugar(promptAsInt);
		
		return juego.checkDraw() ? new Empate() : (juego.checkForVictories() ? new Winner(getTitle()) : new JuegaAzul());

		
	}

	public StateOfGame jugarAzul(Linea juego, int column) {
		throw new RuntimeException(InvalidTurn);
	}

	public String getTitle() {
		return teamRedName;
	}

	public boolean isGameFinished() {
		return false;
	}
	
}
