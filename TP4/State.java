package cuatroEnLinea;

public abstract class State {
    protected Linea juego;

    public State(Linea juego) {
        this.juego = juego;
    }
    
    public abstract State changeState();
    
    public abstract char getToken();
    public abstract String getTitle();
    public abstract boolean isGameOver();
    
    public abstract void jugarRojo(int column);
    public abstract void jugarAzul(int column);
}


