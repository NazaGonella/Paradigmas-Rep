package cuatroEnLinea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
	
	
	
	@Test public void test01GameStartsFinished() {
		Linea game = new Linea(10, 10, 'A');
		assertFalse(game.finished());
	}
	
	@Test public void test02WinGameByVertical() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test05WinGameByHorizontal() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(10);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(4);
		assertEquals((State.WinMessage + State.teamBlueName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test06VictoryFinishesGame() {
		Linea game = new Linea(10, 10, 'C');
		verticalSetup(game);
		assertTrue(game.finished());
	}
	
	@Test public void test07DiagonalPositiveSlopeWorks() {
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
		
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test08PlayingWrongTurnThrowsError() {
		Linea game = new Linea(10, 10, 'A');
		game.playRedAt(1);
		
		try {
			game.playRedAt(1);
		} catch (RuntimeException error) {
		    assertEquals(error.getMessage(), State.InvalidTurn);
		}

	}
	
	@Test public void test10CantPlayWhenMatchIsOverByWin() {
		Linea game = new Linea(10, 10, 'A');
		verticalSetup(game);
		try {
			game.playBlueAt(3);
		} catch (RuntimeException nombre) {
		    assertEquals(nombre.getMessage(), State.GameIsOver);
		}
	}
		
	@Test public void test11CantPlayWhenMatchIsOverByTie() {
		Linea game = new Linea(10, 10, 'A');
		verticalSetup(game);
		try {
			game.playBlueAt(3);
		} catch (RuntimeException nombre) {
		    assertEquals(nombre.getMessage(), State.GameIsOver);
		}
	}
	
	@Test public void test12GameEndsInTieWhenTheBoardIsFull() {
		Linea game = new Linea(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(1);
		
		
		assertEquals(State.ItsADraw, game.getStateOfGame().getTitle());
		
	}
	
	@Test public void test13CantAddTokensWhenColumnIsFull() {
		Linea game = new Linea(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		
		try {
			game.playRedAt(1);
		} catch (RuntimeException error) {
		    assertEquals(error.getMessage(), game.FullColumn);
		}
		
	}
	@Test public void test14HorizontalInModeA() {
		Linea game = new Linea(10, 10, 'A');
		horizontalSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test15VerticalInModeA() {
		Linea game = new Linea(10, 10, 'A');
		verticalSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test16DiagonalAscInModeA() {
		Linea game = new Linea(10, 10, 'A');
		diagonalAscSetup(game);
		
		assertFalse(game.finished());
	}
	
	@Test public void test17DiagonalDesInModeA() {
		Linea game = new Linea(10, 10, 'A');
		diagonalDesSetup(game);
		
		assertFalse(game.finished());
	}
	
	@Test public void test18HorizontalInModeB() {
		Linea game = new Linea(10, 10, 'B');
		horizontalSetup(game);
		
		assertFalse(game.finished());
	}
	
	@Test public void test19VerticalInModeB() {
		Linea game = new Linea(10, 10, 'B');
		verticalSetup(game);
		
		assertFalse(game.finished());
	}
	
	@Test public void test20DiagonalAscInModeB() {
		Linea game = new Linea(10, 10, 'B');
		diagonalAscSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test21DiagonalDesInModeB() {
		Linea game = new Linea(10, 10, 'B');
		diagonalDesSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test22HorizontalInModeC() {
		Linea game = new Linea(10, 10, 'C');
		horizontalSetup(game);
		
		assertTrue(game.finished());
	}

	@Test public void test23VerticalInModeC() {
		Linea game = new Linea(10, 10, 'C');
		verticalSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test24DiagonalAscInModeC() {
		Linea game = new Linea(10, 10, 'C');
		diagonalAscSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test25DiagonalDesInModeC() {
		Linea game = new Linea(10, 10, 'C');
		diagonalDesSetup(game);
		
		assertTrue(game.finished());
	}
	
	@Test public void test26DiagonalDesInModeC() {
		Linea game = new Linea(10, 10, 'C');
		
		try {
			game.playRedAt(11);
		} catch (RuntimeException error) {
		    assertEquals(error.getMessage(), "Invalid prompt");
		}
	}
	
	private void horizontalSetup(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
	}
	
	private void verticalSetup(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
	}
	
	private void diagonalAscSetup(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(4);
	}
	
	private void diagonalDesSetup(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(2);
		game.playBlueAt(4);
	}
}
