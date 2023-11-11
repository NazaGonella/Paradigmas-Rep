package cuatroEnLinea;

public class ModeC extends WinMode{

	protected char getMode() {
		return 'C';
	}

	public boolean isThereVictory(Linea game) {
		char player = game.getTurno().getToken();
		return (game.checkHorizontal(player) || game.checkVertical(player) || game.checkDiagonal(player));
	}

}
