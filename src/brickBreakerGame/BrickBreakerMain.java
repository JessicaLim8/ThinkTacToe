package brickBreakerGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainMenu.MainMenuController;
import thinktactoeGame.Minigame;

public class BrickBreakerMain implements Minigame{
	
	private static JFrame frame;
	
	public static void main(String[] args) {
		
		frame = new JFrame();	
		
		GamePlay gamePlay = new GamePlay();
		frame.setSize(800, 750);

		frame.setTitle("Brick Breaker");		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton menuButton = new JButton("Menu");
		frame.add(menuButton, BorderLayout.SOUTH);
		
		frame.add(gamePlay);
        frame.setVisible(true);
        
        menuButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.displayMenu(3);
				frame.setVisible(false);
				GamePlay.pauseGame();
			}
		});
        
	
	}
	
	public static void returnToGame() {
		frame.setVisible(true);
		frame.invalidate();
		frame.validate();
	}

	@Override
	public boolean startGame(char player) {
		frame = new JFrame();	
		
		GamePlay gamePlay = new GamePlay();
		frame.setSize(800, 750);

		frame.setTitle("Brick Breaker");		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton menuButton = new JButton("Menu");
		frame.add(menuButton, BorderLayout.SOUTH);
		
		frame.add(gamePlay);
        frame.setVisible(true);
        
        menuButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.displayMenu(3);
				frame.setVisible(false);
				GamePlay.pauseGame();
			}
		});
        return true;
	}

	@Override
	public String getRules() {
		// TODO Auto-generated method stub
		return null;
	}

}