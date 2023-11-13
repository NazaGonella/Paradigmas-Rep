package cuatroEnLinea;

public class JuegaAzul extends State {

	public char getToken() {
		return teamBlueToken;
	}

	public State jugarRojo(Linea game, int promptAsInt) {
		throw new RuntimeException(InvalidTurn);
	}

	public State jugarAzul(Linea game , int promptAsInt) {
		game.jugar(promptAsInt);
		
		return game.checkDraw() ? new Empate() : (game.checkForVictories() ? new Winner(getTitle()) : new JuegaRojo());
	}

	public String getTitle() {
		return teamBlueName;
	}
	
	public boolean isGameFinished() {
		return false;
	}

}
