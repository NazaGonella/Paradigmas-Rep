package cuatroEnLinea;

public class ModeC extends WinMode{

	protected char getMode() {
		return 'C';
	}

	protected boolean isThereVictory(Linea game) {
		char player = game.getEstadoDeJuego().getToken();
		return (game.checkHorizontal(player) || game.checkVertical(player) || game.checkDiagonal(player));
	}

}
