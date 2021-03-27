package thinktactoeGame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Piece extends JLabel{

	private boolean occupied;
	private char player;
	
	public Piece() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.player = '\0';
		this.occupied = false;
	}
	
	public void occupy(char player, Icon playerIcon) {
		this.player = player;
		this.setIcon(playerIcon);
		this.occupied = true;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public char occupiedBy() {
		return this.player;
	}

}
