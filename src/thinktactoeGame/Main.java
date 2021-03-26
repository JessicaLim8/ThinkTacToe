package thinktactoeGame;

public class Main {
	
	public static void main(String[] args) {
		testBoard();
	}
	
	private static void testBoard() {
		GameBoard board = new GameBoard();
		board.dropPiece(0, 0);
		board.nextTurn();
		board.dropPiece(0, 1);
		board.dropPiece(0, 2);
		board.dropPiece(2, 2);
		board.drawBoard();
	}

}
