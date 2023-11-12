package cuatroEnLinea;

public class JuegaAzul extends State {

	public char getToken() {
		return teamBlueToken;
	}

	public State jugarRojo(Linea juego, int column) {
		throw new RuntimeException(InvalidTurn);
	}

	public State jugarAzul(Linea juego , int column) {
		juego.jugar(column);
		
		if (juego.checkDraw()) {
			return new Empate();
		} else if (juego.checkForVictories()) {
			return new Winner(getTitle());
		}
		return new JuegaRojo();
	}

	public String getTitle() {
		return teamBlueName;
	}
	
	public boolean isGameFinished() {
		return false;
	}

}
