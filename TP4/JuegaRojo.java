package cuatroEnLinea;

public class JuegaRojo extends State{
	
    public JuegaRojo(Linea juego) {
        super(juego);
    }
    
	public State changeState() {
		return juego.isFinished() ? new FinishedGame(juego) : new JuegaAzul(juego);
	}

	public char getToken() {
		return 'X';
	}

	public void jugarRojo(int column) {
		juego.jugar(column);
	}

	public void jugarAzul(int column) {
		throw new RuntimeException("Turno inválido");
	}
	
}
