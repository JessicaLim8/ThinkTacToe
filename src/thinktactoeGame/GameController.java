package thinktactoeGame;

import java.util.Random;

import exitGame.ExitScreen;
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
	public static String Winner;
	public int count = 0;
	
	
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
		
		(new MinigameController(this.turn, this.gameNum)).start();
	}
	
	public void dropPiece(boolean result) {
		if (result == true) {
			this.gameBoard.dropPiece(this.tempRow, this.temoCol, turn);
			checkGameOver();
			count++;
		}
		
		nextTurn();
		this.gameScreen.updateTurn(this.turn);
		this.gameScreen.show();
	}
//	TODO Check if the game is over
	private void checkGameOver() {
		System.out.println(gameBoard.occupiedBy(1, 1));
		
		String[][] boardPieces;
		String[] checks;
		boardPieces = new String[sizeX][sizeY];
		checks = new String[8];
		
		for(int i = 0; i < sizeX; i++){
			for (int j = 0; j < sizeY; j++){
				boardPieces[i][j] = String.valueOf(gameBoard.occupiedBy(i, j));
			}
		}

		checks[0] = boardPieces[0][0] + boardPieces[0][1] + boardPieces[0][2];
		checks[1] = boardPieces[1][0] + boardPieces[1][1] + boardPieces[1][2];
		checks[2] = boardPieces[2][0] + boardPieces[2][1] + boardPieces[2][2];

		checks[3] = boardPieces[0][0] + boardPieces[1][0] + boardPieces[2][0];
		checks[4] = boardPieces[0][1] + boardPieces[1][1] + boardPieces[2][1];
		checks[5] = boardPieces[0][2] + boardPieces[1][2] + boardPieces[2][2];
		
		checks[6] = boardPieces[0][0] + boardPieces[1][1] + boardPieces[2][2];
		checks[7] = boardPieces[2][0] + boardPieces[1][1] + boardPieces[0][2];	

		for (int i = 0; i < 8; i++){
			if(checks[i].equals("XXX")){
				
				Winner = "X Won the Game";
				ExitScreen.main(null);
			}
			else if(checks[i].equals("OOO")){
				
				Winner = "O Won the Game";
				ExitScreen.main(null);
			}
//			else{
//				// TODO call Draw game on exit screen
//				Winner = "Draw Game";
//				ExitScreen.main(null);
//			}
		}
		if(count == 9) {
			Winner = "Draw Game";
			ExitScreen.main(null);
		}
		
	}
	
//	TODO Initiate minigame
//	private void startMinigame() {
//		
//	}

	public static void main(String[] args) {
		GameController gc = GameController.getInstance();
		gc.showGameScreen();
	}

}
