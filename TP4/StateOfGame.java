package cuatroEnLinea;

public abstract class StateOfGame {
    
	public static final String GameIsOver = "Game is over";
	public static final String ItsADraw = "It's a draw";
	public static final String FullColumn = "Full column";
	public static final String InvalidTurn = "Invalid turn";
	
	public static final String WinMessage = "And the winner is... ";
	
	public static final String teamRedName = "Red!";
	public static final String teamBlueName = "Blue!";
	
	public static final char teamRedToken = 'X';
	public static final char teamBlueToken = 'O';
	
	
    public abstract char getToken();
    public abstract String getTitle();
    public abstract boolean isGameFinished();
    
    public abstract StateOfGame jugarRojo(Linea juego, int column);
    public abstract StateOfGame jugarAzul(Linea juego, int column);
}


