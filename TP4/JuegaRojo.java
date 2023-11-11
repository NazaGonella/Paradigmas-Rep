package cuatroEnLinea;

public class JuegaRojo extends State{
    
	public State changeTurno() {
		return new JuegaAzul();
	}

	public char getToken() {
		return 'X';
	}

	public void jugarRojo(Linea juego, int column) {
		juego.jugar(column);
	}

	public void jugarAzul(Linea juego, int column) {
		throw new RuntimeException("Turno inválido");
	}

	public String getTitle() {
		return "rojo";
	}
	
}
