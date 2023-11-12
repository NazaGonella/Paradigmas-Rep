package cuatroEnLinea;

public class JuegaRojo extends State{

	public char getToken() {
		return teamRedToken;
	}

	public State jugarRojo(Linea juego, int column) {
		juego.jugar(column);
		
//		if (juego.checkDraw()) {
//			return new Empate();
//		} else if (juego.checkForVictories()) {
//			return new Winner(getTitle());
//		}
//		return new JuegaAzul();
		return juego.checkDraw() ? new Empate() : (juego.checkForVictories() ? new Winner(getTitle()) : new JuegaAzul());

		
	}

	public State jugarAzul(Linea juego, int column) {
		throw new RuntimeException(InvalidTurn);
	}

	public String getTitle() {
		return teamRedName;
	}

	public boolean isGameFinished() {
		return false;
	}
	
}
