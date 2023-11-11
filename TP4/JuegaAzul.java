package cuatroEnLinea;

public class JuegaAzul extends State {

	public State changeTurno() {
		return new JuegaRojo();
	}

	public char getToken() {
		return 'O';
	}

	public void jugarRojo(Linea juego, int column) {
		throw new RuntimeException("Turno inválido");
	}

	public void jugarAzul(Linea juego , int column) {
		juego.jugar(column);
	}

	public String getTitle() {
		return "azul";
	}

}
