package cuatroEnLinea;

public class ModeB extends WinMode{

	protected char getMode() {
		return 'B';
	}
	
	protected boolean isThereVictory(Linea game) {
		char player = game.getEstadoDeJuego().getToken();
		return (game.checkDiagonal(player));
	}
}
