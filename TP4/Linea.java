package cuatroEnLinea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Linea {
	
	private State estadoDeJuego = new JuegaRojo(this);
	
	private char redToken = estadoDeJuego.getToken();
	private char blueToken = estadoDeJuego.getToken();
	
	private ArrayList<ArrayList> columns = new ArrayList();
	
	private int base;
	private int altura;
	private char estrategia;
	
	private boolean finished = false;
	
	public Linea(int base, int altura, char estrategia) {
		this.base = base;
		this.altura = altura;
		this.estrategia = estrategia;
		
		for (int i = 0; i < base; i++) {
			ArrayList<Character> column = new ArrayList();
			columns.add(column);
		}
	}

	public boolean isFinished() {
		return finished;
	}
	
	public int getColumnSize() {
		return columns.size();
	}
	
	public int getColumnSizeAt(int i) {
		return columns.get(i).size();
	}

	public String show() {
//        StringBuilder display = new StringBuilder();
//        for (int i = altura - 1; i >= 0; i--) {
//            for (int j = 0; j < base; j++) {
//                if (j < columns.size()) {
//                	if (i < columns.get(i).size()) {
//                		display.append(((State) columns.get(i).get(j)).getToken() + " ");
//                	} else {display.append("- ");}
//                } else {display.append("- ");}
//            }
//            display.append("\n");
//        }
//        return display.toString();
		return null;
	}

	public void playRedAt(int promptAsInt) {
//		if (columns.get(promptAsInt).size() < altura) {
//			columns.get(promptAsInt).add(redToken);
//			System.out.println("adad");
//		}
//		else {
//			throw new RuntimeException("Columna llena");
//		}
//		
//		estadoDeJuego = estadoDeJuego.changeState();
		estadoDeJuego.jugarRojo(promptAsInt);
	}

	public boolean checkForVictories() {
		boolean hayVictoria = false;
		if (estrategia == 'A' || estrategia == 'B' || estrategia == 'C') {
			System.out.println("ADAD");
			hayVictoria = checkVertical(estadoDeJuego .getToken());
			System.out.println(hayVictoria);
			if (!hayVictoria && (estrategia == 'B' || estrategia == 'C')) {
				hayVictoria = checkHorizontal(estadoDeJuego.getToken());
				if (!hayVictoria && (estrategia == 'C')) {
					hayVictoria = checkDiagonal(estadoDeJuego.getToken());
				}
			}
		}
		
		return hayVictoria;
		
	}

	public void playBlueAt(int promptAsInt) {
		estadoDeJuego.jugarAzul(promptAsInt);
	}

	public void jugar(int promptAsInt) {
		if (columns.get(promptAsInt).size() < altura) {
			columns.get(promptAsInt).add(estadoDeJuego.getToken());
			checkForVictories();
			estadoDeJuego = estadoDeJuego.changeState();
		}
		else {
			throw new RuntimeException("Columna llena");
		}
	}
	
	public boolean checkVertical(char player) {
	    for (int i = 0; i < columns.size(); i++) {
	        int count = 0;
	        for (int j = 0; j < columns.get(i).size(); j++) {
	            if ((char) columns.get(i).get(j) == player) {
	                count+=1;
	                if (count == 4) {
	                	finished = true;
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
							finished = true;
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
		int count = 0;
		int incremento = 0;
		for (int i = 0; i < altura; i++) {
			for (int j = 4 - base; j < base + 4; j++) {
				if (j >= 0 && j < base) {
					if (i + incremento < columns.get(j).size()) {
						if ((char) columns.get(j).get(i + incremento) == player) {
							count+=1;
							if (count == 4) {
								finished = true;
			                	return true;
							}
						}else {count = 0;}
					}else {count = 0;}
				}else {count = 0;}
				incremento++;
			}
			incremento = 0;
		}
		return false;
	}
	
//	public char getTokenAt(int i, int j) {
//		return (char) columns.get(i).get(j);
//	}
	
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
