package cuatroEnLinea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
	
	@Test public void test01() {
		Linea game = new Linea(10, 10, 'A');
		assertFalse(game.finished());
	}
	
	@Test public void test04VerticalWorks() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		assertTrue(game.checkVertical('X'));
	}
	
	@Test public void test05HorizontalWorks() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(0);
		game.playBlueAt(0);
		game.playRedAt(1);
		game.playBlueAt(0);
		game.playRedAt(2);
		game.playBlueAt(0);
		game.playRedAt(3);
		assertTrue(game.checkHorizontal('X'));
	}
	
	@Test public void test06VictoryFinishesGame() {
		Linea game = new Linea(10, 10, 'C');
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		assertTrue(game.finished());
	}
	
	@Test public void test07DiagonalWorks() {
		Linea game = new Linea(10, 10, 'C');
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(5);
		game.playRedAt(4);
		game.playBlueAt(5);
		game.playRedAt(5);
		game.playBlueAt(6);
		game.playRedAt(6);
		game.playBlueAt(6);
		game.playRedAt(6);
		
		assertTrue(game.checkDiagonal('X'));
	}
	
	@Test public void test08() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(1);
		
		try {
			game.playRedAt(1);
		} catch (RuntimeException nombre) {
		    assertEquals(nombre.getMessage(), "Turno inválido");
		}

	}
	
	@Test public void test09WinnerIsWinner() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		
		assertEquals("Red", Winner.getWinner());
	}
}
