package memoryShapeGame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton{
	
	private String shape;
	private String face;
	private String imagePath = "./src/memoryShapeGame/images/";
	private Boolean eliminated;
	
	private Icon back = new ImageIcon("./src/images/memoryShapeGame/card_back.png");
	private Icon front;

	public Card(String shape){
		super(new ImageIcon("./src/images/memoryShapeGame/card_back.png"));
		this.shape = shape;
		this.face = "Fliped";
		this.front = new ImageIcon(imagePath+shape+".png");
		this.eliminated = false;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void flip() {
		if (eliminated == true) {
			return;
		}
		if (this.face.equals(this.shape)) {
			face = "Fliped";
			this.setIcon(back);
		}
		else {
			face = this.shape;
			this.setIcon(front);
		}
	}
	
	public void eliminate() {
		this.eliminated = true;
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setEnabled(false);
	}
	
	public String getShape() {
		return this.shape;
	}

}
