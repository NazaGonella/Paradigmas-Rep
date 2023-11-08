package cuatroEnLinea;

public class JuegaAzul extends State {
    public JuegaAzul(Linea juego) {
        super(juego);
    }

	public State changeState() {
		return juego.isFinished() ? new FinishedGame(juego) : new JuegaRojo(juego);
	}

	public char getToken() {
		return 'O';
	}

	public void jugarRojo(int column) {
		throw new RuntimeException("Turno inválido");
	}

	public void jugarAzul(int column) {
		juego.jugar(column);
	}

}
