package cuatroEnLinea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
	
	@Test public void test01() {
		Linea game = new Linea(10, 10, 'A');
		assertFalse(game.isFinished());
	}
	
	@Test public void test03() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		assertEquals(4, game.getColumnSizeAt(1));
		game.playRedAt(1);
		assertEquals(5, game.getColumnSizeAt(1));
		game.playBlueAt(1);
		assertEquals(6, game.getColumnSizeAt(1));
		game.playRedAt(5);
		assertEquals(1, game.getColumnSizeAt(5));
	}
	
	@Test public void test04() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		assertTrue(game.checkVertical('X'));
	}
	
	@Test public void test05() {
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
	
	@Test public void test06() {
		Linea game = new Linea(10, 10, 'C');
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		game.playBlueAt(1);
		game.playRedAt(0);
		assertTrue(game.isFinished());
	}
	
	@Test public void test07() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(3);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(2);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(1);
		game.playRedAt(0);
		game.playRedAt(0);
		game.playRedAt(0);
		game.playRedAt(0);
		game.playRedAt(0);
		game.playRedAt(0);
		game.playRedAt(0);
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
}
