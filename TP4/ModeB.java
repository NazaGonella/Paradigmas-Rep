package cuatroEnLinea;

public class ModeB extends WinMode{

	protected char getMode() {
		return 'B';
	}
	
	public boolean isThereVictory(Linea game) {
		char player = game.getTurno().getToken();
		return (game.checkDiagonal(player));
	}
}
