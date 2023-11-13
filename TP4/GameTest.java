package cuatroEnLinea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.function.Executable;

import org.junit.Test;

public class GameTest {
	
	@Test public void test01GameStartsFinished() {
		assertFalse(lineaTenByTenInMode('C').finished());
	}
	
	@Test public void test02VictoryFinishesGame() {
		assertTrue(finishByVertical(lineaTenByTenInMode('C')));
	}
	
	@Test public void test03WinGameDisplaysCorrectMessageForRed() {
		Linea game = lineaTenByTenInMode('C');
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test04PromptOutOfRangeThrowsException() {
		Linea game = lineaTenByTenInMode('C');
		
		assertThrowsLike(() -> game.playRedAt(11), Linea.InvalidPrompt);
		
	}	
	
	@Test public void test05WinGameDisplaysCorrectMessageForBlue() {
		Linea game = lineaTenByTenInMode('C');
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(2);
		assertEquals((State.WinMessage + State.teamBlueName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test06PlayingWrongTurnThrowsError() {
		Linea game = lineaTenByTenInMode('C');
		game.playRedAt(1);
		assertThrowsLike(() -> game.playRedAt(1), State.InvalidTurn);
	}
	
	@Test public void test07GameEndsInTieWhenTheBoardIsFull() {
		Linea game = lineaFourByFourInMode('A');
		tieSetupFourFour(game);
		assertEquals(State.ItsADraw, game.getStateOfGame().getTitle());
		
	}
	
	@Test public void test08CantAddTokensWhenColumnIsFull() {
		Linea game = lineaFourByFourInMode('A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike(() -> game.playRedAt(1), Linea.FullColumn);
		
	}
	
	@Test public void test09CantPlayWhenMatchIsOverByWin() {
		Linea game = lineaTenByTenInMode('C');
		finishByVertical(game);
		assertThrowsLike(() -> game.playBlueAt(3), State.GameIsOver);
	}
		
	@Test public void test10CantPlayWhenMatchIsOverByTie() {
		Linea game = lineaFourByFourInMode('A');
		tieSetupFourFour(game);
		assertThrowsLike(() -> game.playRedAt(3), State.GameIsOver);
	}
	
	@Test public void test11HorizontalInModeA() {
		assertTrue(finishByHorizontal(lineaTenByTenInMode('A')));
	}
	
	@Test public void test12VerticalInModeA() {
		assertTrue(finishByVertical(lineaTenByTenInMode('A')));
	}
	
	@Test public void test13DiagonalAscInModeA() {
		assertFalse(finishByDiagonalAsc(lineaTenByTenInMode('A')));
	}
	
	@Test public void test14DiagonalDesInModeA() {
		assertFalse(finishByDiagonalDes(lineaTenByTenInMode('A')));
	}
	
	@Test public void test15HorizontalInModeB() {
		assertFalse(finishByHorizontal(lineaTenByTenInMode('B')));
	}
	
	@Test public void test16VerticalInModeB() {
		assertFalse(finishByVertical(lineaTenByTenInMode('B')));
	}
	
	@Test public void test17DiagonalAscInModeB() {
		assertTrue(finishByDiagonalAsc(lineaTenByTenInMode('B')));
	}
	
	@Test public void test18DiagonalDesInModeB() {
		assertTrue(finishByDiagonalDes(lineaTenByTenInMode('B')));
	}
	
	@Test public void test19HorizontalInModeC() {
		assertTrue(finishByHorizontal(lineaTenByTenInMode('C')));
	}

	@Test public void test20VerticalInModeC() {
		assertTrue(finishByVertical(lineaTenByTenInMode('C')));
	}
	
	@Test public void test21DiagonalAscInModeC() {
		assertTrue(finishByDiagonalAsc(lineaTenByTenInMode('C')));
	}
	
	@Test public void test22DiagonalDesInModeC() {
		assertTrue(finishByDiagonalDes(lineaTenByTenInMode('C')));
	}
	
	@Test public void test23BoardDisplayedCorrectly() {
		assertEquals(lineaFourByFourInMode('C').show(), 
				  "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}
	
	@Test public void test24RedTokenDisplayedCorrectly() {
		Linea game = lineaFourByFourInMode('C');
		game.playRedAt(2);
		assertEquals(game.show(), 
				  "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | X |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}
	
	@Test public void test25StackedTokensDisplayedCorrectly() {
		Linea game = lineaFourByFourInMode('C');
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		assertEquals(game.show(), 
				  "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | X |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | O |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | X |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}
	
	@Test public void test26ConsecutiveTokensDisplayedCorrectly() {
		Linea game = lineaFourByFourInMode('C');
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(4);
		assertEquals(game.show(), "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | X | O | X |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}

	private boolean finishByHorizontal(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		
		return game.finished();
	}
	
	private boolean finishByVertical(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		
		return game.finished();
	}
	
	private boolean finishByDiagonalAsc(Linea game) {
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
		
		return game.finished();
	}
	
	private boolean finishByDiagonalDes(Linea game) {
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
		
		return game.finished();
	}
	
	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message, assertThrows(Exception.class, executable).getMessage());

	}
	
	private void tieSetupFourFour(Linea game) {
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
	}
	
	private Linea lineaTenByTenInMode(char mode) {
		return new Linea(10, 10, mode);
	}
	
	private Linea lineaFourByFourInMode(char mode) {
		return new Linea(4, 4, mode);
	}
}
