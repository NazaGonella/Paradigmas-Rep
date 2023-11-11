package cuatroEnLinea;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class WinMode {
	
	private static ArrayList<WinMode> winModes = new ArrayList<>(Arrays.asList(
			  new ModeA(), 
			  new ModeB(), 
			  new ModeC()));
	
	public static WinMode getWinMode(char variante) {
        return winModes.stream()
                .filter(game -> game.getMode() == variante)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid type of game"));
    }

	protected abstract char getMode();

	public abstract boolean isThereVictory(Linea game);
}
