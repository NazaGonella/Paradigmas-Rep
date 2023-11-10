package cuatroEnLinea;

public class JuegaAzul extends State {
    public JuegaAzul(Linea juego) {
        super(juego);
    }

	public State changeState() {
		return juego.finished() ? new Winner(juego) : new JuegaRojo(juego);
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

	public boolean isGameOver() {
		return false;
	}

	public String getTitle() {
		return "Azul";
	}

}
