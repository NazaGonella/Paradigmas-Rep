package cuatroEnLinea;

public class ModeA extends WinMode{

	protected char getMode() {
		return 'A';
	}
	
	public boolean isThereVictory(Linea game) {
		char player = game.getTurno().getToken();
		return (game.checkHorizontal(player) || game.checkVertical(player));
	}
}
