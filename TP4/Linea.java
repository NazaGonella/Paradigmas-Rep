package cuatroEnLinea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
	
	private State turno = new JuegaRojo();
	private State stateOfGame;
	
	private char redToken = turno.getToken();
	private char blueToken = turno.getToken();
	
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
		
		if (base < 4 || altura < 4) {
			throw new RuntimeException("Invalid dimensions");
		}
		
//		for (int i = 0; i < base; i++) {
//			ArrayList<Character> column = new ArrayList();
//			columns.add(column);
//		}
		
        IntStream.range(0, base)
        	.forEach(i -> columns.add(new ArrayList<>()));
	}

	public boolean finished() {
		return finished;
	}

	public String show() {
	    String display = "";
	    display += ("+---".repeat(base) + "+\n");
	    for (int fila = altura - 1; fila >= 0; fila--) {
	        for (int columna = 0; columna < base; columna++) {
	            if (fila < columns.get(columna).size()) {
	                display += ("| " + columns.get(columna).get(fila) + " ");
	            } else {
	                display += ("|   ");
	            }
	        }
	        display += ("|\n");
	        display += ("+---".repeat(base) + "+\n");
	    }
	    if (finished()) {
	    	display += (stateOfGame.getTitle());
	    }
	    return display;
	}

	public void playRedAt(int promptAsInt) {
		turno.jugarRojo(this, promptAsInt - 1);
	}

	public void playBlueAt(int promptAsInt) {
		turno.jugarAzul(this, promptAsInt - 1);
	}

	public void jugar(int promptAsInt) {
		if (columns.get(promptAsInt).size() < altura) {
			columns.get(promptAsInt).add(turno.getToken());
			checkGameOver();
			turno = turno.changeTurno();
		}
		else {
			throw new RuntimeException("Columna llena");
		}
	}

	public boolean checkForVictories() {
		return modoDeVictoria.isThereVictory(this);
	}
	
	public boolean checkVertical(char player) {
	    for (int i = 0; i < columns.size(); i++) {
	        int count = 0;
	        for (int j = 0; j < columns.get(i).size(); j++) {
	            if ((char) columns.get(i).get(j) == player) {
	                count+=1;
	                if (count == 4) {
	                	return true;
	                }
	            }
	            else {
	                count = 0;
	            }
	        }
	    }
	    return false;
	    
	}
	
	public boolean checkHorizontal(char player) {
		int count = 0;
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < base; j++) {
				if (i < columns.get(j).size()) {
					if ((char) columns.get(j).get(i) == player) {
						count+=1;
						if (count == 4) {
		                	return true;
						}
					}
					else {
						count = 0;
					}
				}
				else {
					count = 0;
				}
			}
		}
		return false;
		
	}
	
	public boolean checkDiagonal(char player) {
	    for (int i = -altura; i < base; i++) {
	        int count = 0;
	        for (int j = 0; j < altura; j++) {
	            int columnIndex = i + j;
	            if (columnIndex >= 0 && columnIndex < base) {
	                if (j < columns.get(columnIndex).size()) {
	                    if ((char) columns.get(columnIndex).get(j) == player) {
	                        count++;
	                    } else {
	                        count = 0;
	                    }
	                    if (count == 4) {
	                        return true;
	                    }
	                }
	            }
	        }
	    }

	    for (int i = altura + base; i > 0; i--) {
	        int count = 0;
	        for (int j = 0; j < altura; j++) {
	            int columnIndex = i - j;
	            if (columnIndex >= 0 && columnIndex < base) {
	                if (j < columns.get(columnIndex).size()) {
	                    if ((char) columns.get(columnIndex).get(j) == player) {
	                        count++;
	                    } else {
	                        count = 0;
	                    }
	                    if (count == 4) {
	                        finished = true;
	                        return true;
	                    }
	                }
	            }
	        }
	    }

	    return false;
	}
	
	public boolean checkDraw() {
        return columns.stream().allMatch(column -> column.size() >= altura);
    }
	
	public State getTurno() {
		return turno;
	}
	
	public State getStateOfGame() {
		return stateOfGame;
	}
	
	public void checkGameOver() {
		if (!finished) {
			finished = checkForVictories();
			stateOfGame = new Winner(turno.getTitle());
		}
		if (!finished) {
			finished = checkDraw();
			stateOfGame = new Empate();
		}
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
