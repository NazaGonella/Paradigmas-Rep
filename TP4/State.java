package cuatroEnLinea;

public abstract class State {
    
    public abstract State changeTurno();
    
    public abstract char getToken();
    public abstract String getTitle();
    
    public abstract void jugarRojo(Linea juego, int column);
    public abstract void jugarAzul(Linea juego, int column);
}


