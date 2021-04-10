package thinktactoeGame;

import java.util.Random;

import memoryShapeGame.MemoryCardController;

public class GameController {
	
	private GameScreen gameScreen;
	private GameBoard gameBoard;
	
	private static GameController instance = new GameController();
	
	private final int sizeX = 3;
	private final int sizeY = 3;
	
	private char turn;
	private int tempRow;
	private int temoCol;
	private int gameNum = 0;
	
	private GameController() {
		this.gameScreen = GameScreen.getInstance(this);
		this.gameBoard = new GameBoard(sizeX, sizeY);
		this.turn = 'X';
		Random rand = new Random();
		this.gameNum = rand.nextInt(5) + 1;
	}
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
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
		this.tempRow = row;
		this.temoCol = col;
		launchGame();	
//		dropPiece(row, col);
	}
	
	private String validateMove(int row, int col) {
		if (this.gameBoard.isOccupied(row, col) == true) {
			return "Place is already occupied";
		}
		return "Valid Move!";
	}
	
	private void launchGame() {
		this.gameScreen.hide();
		this.gameNum = this.gameNum % 5 + 1;
		
		// remove this section when brick breaker works
		if (this.gameNum == 3) {
			this.gameNum += 1;
		}
		(new MinigameController(this.turn, this.gameNum)).start();
	}
	
	public void dropPiece(boolean result) {
		if (result == true) {
			this.gameBoard.dropPiece(this.tempRow, this.temoCol, turn);
		}
		nextTurn();
		this.gameScreen.updateTurn(this.turn);
		this.gameScreen.show();
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
		GameController gc = GameController.getInstance();
		gc.showGameScreen();
	}

}
