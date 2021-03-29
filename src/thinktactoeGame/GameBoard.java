package thinktactoeGame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel{
	
	private Piece[][] board;
	
	private Icon iconX = new ImageIcon("./src/thinktactoeGame/X.png");
	private Icon iconO = new ImageIcon("./src/thinktactoeGame/O.png");
	
	public GameBoard(int row, int col) {
		super();
		this.setLayout(new GridLayout(row,col));
		this.board = new Piece[row][col];
		// initialize board to empty chars
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Piece placeHolder = new Piece();
				this.board[i][j] = placeHolder;
				this.add(placeHolder);
			}
		}
	}
	
	public Piece[][] getBoard() {
		return this.board;
	}
	
	
	public void dropPiece(int row, int col, char turn) {
		Icon playerIcon = turn == 'X' ? iconX : iconO;
		this.board[row][col].occupy(turn, playerIcon);	
	}
	
	public boolean isOccupied(int row, int col) {
		return this.board[row][col].isOccupied();
	}
	
}
