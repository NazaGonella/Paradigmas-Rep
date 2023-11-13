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
		assertTrue(finishByVerticalRed(lineaTenByTenInMode('C')));
	}
	
	@Test public void test03RedCanWinHorizontal() {
		Linea game = lineaTenByTenInMode('C');
		finishByHorizontalRed(game);
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test04RedCanWinVertical() {
		Linea game = lineaTenByTenInMode('C');
		finishByVerticalRed(game);
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test05RedCanWinDiagonalAsc() {
		Linea game = lineaTenByTenInMode('C');
		finishByDiagonalAscRed(game);
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test06RedCanWinDiagonalDes() {
		Linea game = lineaTenByTenInMode('C');
		finishByDiagonalDesRed(game);
		assertEquals((State.WinMessage + State.teamRedName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test07BlueCanWinHorizontal() {
		Linea game = lineaTenByTenInMode('C');
		finishByHorizontalBlue(game);
		assertEquals((State.WinMessage + State.teamBlueName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test08BlueCanWinVertical() {
		Linea game = lineaTenByTenInMode('C');
		finishByVerticalBlue(game);
		assertEquals((State.WinMessage + State.teamBlueName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test09BlueCanWinDiagonalAsc() {
		Linea game = lineaTenByTenInMode('C');
		finishByDiagonalAscBlue(game);
		assertEquals((State.WinMessage + State.teamBlueName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test10BlueCanWinDiagonalDes() {
		Linea game = lineaTenByTenInMode('C');
		finishByDiagonalDesBlue(game);
		assertEquals((State.WinMessage + State.teamBlueName), game.getStateOfGame().getTitle());
	}
	
	@Test public void test11WinGameDisplaysCorrectMessageForRed() {
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
	
	@Test public void test12PromptOutOfRangeThrowsException() {
		Linea game = lineaTenByTenInMode('C');
		
		assertThrowsLike(() -> game.playRedAt(11), Linea.InvalidPrompt);
		
	}	
	
	@Test public void test13WinGameDisplaysCorrectMessageForBlue() {
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
	
	@Test public void test14PlayingWrongTurnThrowsError() {
		Linea game = lineaTenByTenInMode('C');
		game.playRedAt(1);
		assertThrowsLike(() -> game.playRedAt(1), State.InvalidTurn);
	}
	
	@Test public void test15GameEndsInTieWhenTheBoardIsFull() {
		Linea game = lineaFourByFourInMode('A');
		tieSetupFourFour(game);
		assertEquals(State.ItsADraw, game.getStateOfGame().getTitle());
		
	}
	
	@Test public void test16CantAddTokensWhenColumnIsFull() {
		Linea game = lineaFourByFourInMode('A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike(() -> game.playRedAt(1), Linea.FullColumn);
		
	}
	
	@Test public void test17CantPlayWhenMatchIsOverByWin() {
		Linea game = lineaTenByTenInMode('C');
		finishByVerticalRed(game);
		assertThrowsLike(() -> game.playBlueAt(3), State.GameIsOver);
	}
		
	@Test public void test18CantPlayWhenMatchIsOverByTie() {
		Linea game = lineaFourByFourInMode('A');
		tieSetupFourFour(game);
		assertThrowsLike(() -> game.playRedAt(3), State.GameIsOver);
	}
	
	@Test public void test19HorizontalInModeA() {
		assertTrue(finishByHorizontalRed(lineaTenByTenInMode('A')));
	}
	
	@Test public void test20VerticalInModeA() {
		assertTrue(finishByVerticalRed(lineaTenByTenInMode('A')));
	}
	
	@Test public void test21DiagonalAscInModeA() {
		assertFalse(finishByDiagonalAscRed(lineaTenByTenInMode('A')));
	}
	
	@Test public void test22DiagonalDesInModeA() {
		assertFalse(finishByDiagonalDesRed(lineaTenByTenInMode('A')));
	}
	
	@Test public void test23HorizontalInModeB() {
		assertFalse(finishByHorizontalRed(lineaTenByTenInMode('B')));
	}
	
	@Test public void test24VerticalInModeB() {
		assertFalse(finishByVerticalRed(lineaTenByTenInMode('B')));
	}
	
	@Test public void test25DiagonalAscInModeB() {
		assertTrue(finishByDiagonalAscRed(lineaTenByTenInMode('B')));
	}
	
	@Test public void test26DiagonalDesInModeB() {
		assertTrue(finishByDiagonalDesRed(lineaTenByTenInMode('B')));
	}
	
	@Test public void test27HorizontalInModeC() {
		assertTrue(finishByHorizontalRed(lineaTenByTenInMode('C')));
	}

	@Test public void test28VerticalInModeC() {
		assertTrue(finishByVerticalRed(lineaTenByTenInMode('C')));
	}
	
	@Test public void test29DiagonalAscInModeC() {
		assertTrue(finishByDiagonalAscRed(lineaTenByTenInMode('C')));
	}
	
	@Test public void test30DiagonalDesInModeC() {
		assertTrue(finishByDiagonalDesRed(lineaTenByTenInMode('C')));
	}
	
	@Test public void test31BoardDisplayedCorrectly() {
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
	
	@Test public void test32RedTokenDisplayedCorrectly() {
		Linea game = lineaFourByFourInMode('C');
		game.playRedAt(2);
		char teamRedToken = State.teamRedToken;
		assertEquals(game.show(), 
				  "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | " + teamRedToken + " |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}
	
	@Test public void test33StackedTokensDisplayedCorrectly() {
		Linea game = lineaFourByFourInMode('C');
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		char teamRedToken = State.teamRedToken;
		char teamBlueToken = State.teamBlueToken;
		assertEquals(game.show(), 
				  "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | " + teamRedToken + " |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | " + teamBlueToken + " |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | " + teamRedToken + " |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}
	
	@Test public void test34ConsecutiveTokensDisplayedCorrectly() {
		Linea game = lineaFourByFourInMode('C');
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(4);
		char teamRedToken = State.teamRedToken;
		char teamBlueToken = State.teamBlueToken;
		assertEquals(game.show(), "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   |   |   |   |\n"
				+ "+---+---+---+---+\n"
				+ "|   | " + teamRedToken + " | " + teamBlueToken + " | " + teamRedToken + " |\n"
				+ "+---+---+---+---+\n"
				+ "");
	}

	private boolean finishByHorizontalRed(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		
		return game.finished();
	}
	
	private boolean finishByVerticalRed(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		
		return game.finished();
	}
	
	private boolean finishByDiagonalAscRed(Linea game) {
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
	
	private boolean finishByDiagonalDesRed(Linea game) {
		
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(5);
		
		return game.finished();
	}
	
	private boolean finishByHorizontalBlue(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(5);
		
		return game.finished();
	}
	
	private boolean finishByVerticalBlue(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(3);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(2);
		game.playBlueAt(3);
		
		return game.finished();
	}
	
	private boolean finishByDiagonalAscBlue(Linea game) {
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(5);
		game.playBlueAt(5);
		game.playRedAt(5);
		game.playBlueAt(5);
		
		return game.finished();
	}
	
	private boolean finishByDiagonalDesBlue(Linea game) {
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
