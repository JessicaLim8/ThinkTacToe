package exitGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import thinktactoeGame.GameController;

public class ExitScreen {
	
	

	public static void main(String[] args) {
		
		JFrame exitFrame;
		
		exitFrame = new JFrame();
		exitFrame.getContentPane().setLayout(null);
		exitFrame.setSize(700, 600);
		exitFrame.setTitle("Game Over");
		exitFrame.setResizable(false);
		exitFrame.setVisible(true);
		exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		JButton exitButton = new JButton("Exit Game");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitButton.setBounds(250, 364, 171, 82);
		exitFrame.getContentPane().add(exitButton);
		
		JButton restartButton = new JButton("Restart Game");
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		restartButton.setBounds(250, 255, 171, 82);
		exitFrame.getContentPane().add(restartButton);
		

		JLabel label = new JLabel(GameController.Winner);
		label.setBounds(236, 137, 197, 107);
		label.setFont(new Font("Verdana",1,20));
		exitFrame.getContentPane().add(label);	

		
	}
}
