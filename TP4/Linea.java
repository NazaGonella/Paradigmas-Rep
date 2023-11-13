package cuatroEnLinea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
	
	public static final String FullColumn = "Full column";
	public static final String InvalidPrompt = "Invalid prompt";

	private StateOfGame stateOfGame = new JuegaRojo();
	
	private ArrayList<ArrayList> columns = new ArrayList();
	
	private WinMode modoDeVictoria;
	private int base;
	private int height;
	
	private boolean finished = false;
	
	public Linea(int base, int altura, char variante) {
		this.base = base;
		this.height = altura;
		this.modoDeVictoria = WinMode.getWinMode(Character.toUpperCase(variante));
		
		IntStream.range(0, base)
        .forEach(i -> {
            ArrayList<Character> column = new ArrayList<>();
            this.columns.add(column);
        });
	}

	public boolean finished() {
		return finished;
	}

	public String show() {
		String display = "+---".repeat(base) + "+\n" +
		        IntStream.range(0, height)
		                .mapToObj(fila ->
		                        IntStream.range(0, base)
		                                .mapToObj(columna ->
		                                        insideBoard(columna, fila)
		                                                ? "| " + getTokenAt(columna, fila) + " "
		                                                : "|   "
		                                )
		                                .collect(Collectors.joining(""))
		                                + "|\n" +
		                                "+---".repeat(base) + "+\n"
		                )
		                .collect(Collectors.collectingAndThen(
		                        Collectors.toList(),
		                        list -> {
		                            Collections.reverse(list);
		                            return list.stream().collect(Collectors.joining());
		                        }
		                ));
		
		if (finished()) {
	    	display += (stateOfGame.getTitle());
	    }
	    return display;
	}

	public void playRedAt(int promptAsInt) {
		stateOfGame = stateOfGame.jugarRojo(this, promptAsInt - 1);
		checkGameOver();
	}

	public void playBlueAt(int promptAsInt) {
		stateOfGame = stateOfGame.jugarAzul(this, promptAsInt - 1);
		checkGameOver();
	}

	public void jugar(int promptAsInt) {
		if ( promptAsInt < 0 || promptAsInt >= columns.size()) {
			throw new RuntimeException(InvalidPrompt);
		}
		if (this.columns.get(promptAsInt).size() >= height) {
			throw new RuntimeException(FullColumn);
		}
		this.columns.get(promptAsInt).add(stateOfGame.getToken());
	}

	public boolean checkForVictories() {
		return modoDeVictoria.isThereVictory(this);
	}
	
	public boolean checkVertical(char player) {
		return IntStream.range(0, base)
                .anyMatch(fila -> IntStream.range(0, height - 3)
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> getTokenAt(column, fila + i) == player)));
	    
	}
	
	public boolean checkHorizontal(char player) {
		return IntStream.range(0, height)
                .anyMatch(fila -> IntStream.range(0, base - 3)
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> getTokenAt(column + i, fila) == player)));
		
	}
	
	public boolean checkDiagonal(char player) {
		return IntStream.range(0, height + base)
		        .anyMatch(i -> {
		            String diagonalAscendente = IntStream.range(0, height)
		                    .mapToObj(j -> String.valueOf(getTokenAt(i + j,j)))
		                    .collect(Collectors.joining());
		            String diagonalDescendente = IntStream.range(0, height)
		            		.mapToObj(j -> String.valueOf(getTokenAt(i - j,j)))
		                    .collect(Collectors.joining());

		            return diagonalAscendente.contains(String.valueOf(player).repeat(4)) || diagonalDescendente.contains(String.valueOf(player).repeat(4));
		        });
	}
	
	public boolean checkDraw() {
        return this.columns.stream().allMatch(column -> column.size() >= height);
    }
	
	public StateOfGame getTurno() {
		return stateOfGame;
	}
	
	public StateOfGame getStateOfGame() {
		return stateOfGame;
	}
	
	public void checkGameOver() {
		finished = stateOfGame.isGameFinished();
	}
	
	public boolean insideBoard(int columna, int fila) {
		return (columna >= 0 && columna < base) && (fila < this.columns.get(columna).size());
	}
	
	public char getTokenAt(int columna, int fila) {
		if (insideBoard(columna, fila)) {
			return (char) this.columns.get(columna).get(fila);
		}
		return ' ';
	}
}

//+---+---+---+---+---+
//|   |   |   |   |   |
//+---+---+---+---+---+
//|   |   |   |   |   |
//+---+---+---+---+---+
//|   |   |   |   |   |
//+---+---+---+---+---+
//|   |   |   |   |   |
//+---+---+---+---+---+
//|   |   |   |   |   |
//+---+---+---+---+---+
