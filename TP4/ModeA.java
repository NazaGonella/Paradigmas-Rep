package cuatroEnLinea;

public class ModeA extends WinMode{

	protected char getMode() {
		return 'A';
	}
	
	protected boolean isThereVictory(Linea game) {
		char player = game.getEstadoDeJuego().getToken();
		return (game.checkHorizontal(player) || game.checkVertical(player));
	}
}
