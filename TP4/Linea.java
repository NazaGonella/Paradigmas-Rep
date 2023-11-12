package cuatroEnLinea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
	
	public static final String FullColumn = "Full column";
	public static final String InvalidPrompt = "Invalid prompt";

	private State stateOfGame = new JuegaRojo();
	
	private char redToken = stateOfGame.getToken();
	private char blueToken = stateOfGame.getToken();
	
	private ArrayList<ArrayList> columns = new ArrayList();
	
	private WinMode modoDeVictoria;
	private int base;
	private int altura;
	private char variante;
	
	private boolean finished = false;
	
	public Linea(int base, int altura, char variante) {
		this.base = base;
		this.altura = altura;
		this.variante = Character.toUpperCase(variante);
		this.modoDeVictoria = WinMode.getWinMode(this.variante);
		
		IntStream.range(0, base)
        .forEach(i -> {
            ArrayList<Character> column = new ArrayList<>();
            columns.add(column);
        });
	}

	public boolean finished() {
		return finished;
	}

	public String show() {
//		String display = "+---".repeat(base) + "+\n" +
//		        IntStream.range(0, altura)
//		                .mapToObj(fila ->
//		                        IntStream.range(0, base)
//		                                .mapToObj(columna ->
//		                                        insideBoard(columna, fila)
//		                                                ? "| " + columns.get(columna).get(fila) + " "
//		                                                : "|   "
//		                                )
//		                                .collect(Collectors.joining(""))
//		                                + "|\n" +
//		                                "+---".repeat(base) + "+\n"
//		                )
//		                .collect(Collectors.collectingAndThen(
//		                        Collectors.toList(),
//		                        list -> {
//		                            Collections.reverse(list);
//		                            return list.stream().collect(Collectors.joining());
//		                        }
//		                ));
		
		String display = "+---".repeat(base) + "+\n" +
		        IntStream.range(0, altura)
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
		if ( promptAsInt < 0 || promptAsInt >= 10) {
			throw new RuntimeException(InvalidPrompt);
		}
		if (columns.get(promptAsInt).size() >= altura) {
			throw new RuntimeException(FullColumn);
		}
		System.out.println(promptAsInt);
		columns.get(promptAsInt).add(stateOfGame.getToken());
	}

	public boolean checkForVictories() {
		return modoDeVictoria.isThereVictory(this);
	}
	
	public boolean checkVertical(char player) {
		
//		return IntStream.range(0, columns.size())
//                .anyMatch(i -> IntStream.range(0, columns.get(i).size() - 3)
//                        .anyMatch(j -> columns.get(i).subList(j, j + 4).stream()
//                                .allMatch(ch -> ch.equals(player))));
		
		return IntStream.range(0, base)
                .anyMatch(fila -> IntStream.range(0, altura - 3)
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> getTokenAt(column, fila + i) == player)));
	    
	}
	
	public boolean checkHorizontal(char player) {
		
		return IntStream.range(0, altura)
                .anyMatch(fila -> IntStream.range(0, base - 3)
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> getTokenAt(column + i, fila) == player)));
		
	}
	
	public boolean checkDiagonal(char player) {
		
		return IntStream.range(0, altura + base)
		        .anyMatch(i -> {
		            String diagonalAscendente = IntStream.range(0, altura)
		                    .mapToObj(j -> String.valueOf(getTokenAt(i + j,j)))
		                    .collect(Collectors.joining());
		            String diagonalDescendente = IntStream.range(0, altura)
		            		.mapToObj(j -> String.valueOf(getTokenAt(i - j,j)))
		                    .collect(Collectors.joining());

		            return diagonalAscendente.contains(String.valueOf(player).repeat(4)) || diagonalDescendente.contains(String.valueOf(player).repeat(4));
		        });
	}
	
	public boolean checkDraw() {
        return columns.stream().allMatch(column -> column.size() >= altura);
    }
	
	public State getTurno() {
		return stateOfGame;
	}
	
	public State getStateOfGame() {
		return stateOfGame;
	}
	
	public void checkGameOver() {
		finished = stateOfGame.isGameFinished();
	}
	
	public boolean insideBoard(int columna, int fila) {
		return (columna >= 0 && columna < base) && (fila < columns.get(columna).size());
	}
	
	public char getTokenAt(int columna, int fila) {
		if (insideBoard(columna, fila)) {
			return (char) columns.get(columna).get(fila);
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
