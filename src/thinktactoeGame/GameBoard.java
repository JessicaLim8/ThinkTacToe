package thinktactoeGame;


public class GameBoard {
	private int turn;
	private char[][] board;
	private char empty = '\0';
	
	
	public GameBoard() {
		this.turn = 1;
		this.board = new char[3][3];
		// initialize board to empty chars
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.board[i][j] = empty;
			}
		}
	}
	
	public char[][] getBoard() {
		return this.board;
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public void nextTurn() {
		this.turn = this.turn == 1 ? 2 : 1;
	}
	
	public void dropPiece(int row, int col) {
		if (!this.validLocation(row, col)) {
			System.out.println("Invalid Location");	
		}
		this.board[row][col] = turn == 1 ? 'x' : 'o';
		this.nextTurn();
		
	}
	
	public boolean validLocation(int row, int col) {
		// make sure location is empty
		if (this.board[row][col] != empty) {
			return false;
		}
		return true;
	}
	
	public void drawBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(this.board[i][j]);
			}
			System.out.println();
		}
	}

}
