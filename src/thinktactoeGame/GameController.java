package thinktactoeGame;

public class GameController {
	
	private GameScreen gameScreen;
	private GameBoard gameBoard;
	
	private final int sizeX = 3;
	private final int sizeY = 3;
	
	private char turn;
	
	public GameController() {
		this.gameScreen = GameScreen.getInstance(this);
		this.gameBoard = new GameBoard(sizeX, sizeY);
		this.turn = 'X';
	}
	
	public void showGameScreen() {
		gameScreen.showScreen();
	}
	
	public char getTurn() {
		return this.turn;
	}
	
	public void nextTurn() {
		this.turn = this.turn == 'X' ? 'O' : 'X';
	}
	
	public GameBoard getBoard() {
		return this.gameBoard;
	}
	
	public void coordEntered(String coord) {
		int row = Character.getNumericValue(coord.charAt(0));
		int col = Character.getNumericValue(coord.charAt(1));
		if (row >= sizeX || col >= sizeY) {
			this.gameScreen.updateStatusMessage("Invalid Coordinate! \nExample Usage: 11");
			return;
		}
		String check = validateMove(row, col);
		this.gameScreen.updateStatusMessage(check);
		if (check != "Valid Move!") {
			return;
		}
		
		//TODO init a minigame here?
		
		//TODO if clause to check if the current player wins the minigame
		
		dropPiece(row, col);
		nextTurn();
		this.gameScreen.updateTurn(this.turn);
	}
	
	private String validateMove(int row, int col) {
		if (this.gameBoard.isOccupied(row, col) == true) {
			return "Place is already occupied";
		}
		return "Valid Move!";
	}
	
	private void dropPiece(int row, int col) {
		
		//TODO init a minigame here?
		
		this.gameBoard.dropPiece(row, col, turn);;
	}
	
//	TODO Check if the game is over
//	private void checkGameOver() {
//		
//	}
	
//	TODO Initiate minigame
//	private void startMinigame() {
//		
//	}

	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.showGameScreen();
	}

}
