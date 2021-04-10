package RulesWork;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class RulesScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void startRules(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesScreen frame = new RulesScreen(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RulesScreen(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(33, 10, 823, 52);
		contentPane.add(lblTitle);
		
		JLabel lblRules = new JLabel("");
		lblRules.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRules.setBounds(45, 77, 786, 523);
		contentPane.add(lblRules);
		
		JButton exitButton = new JButton("Exit Rules");
		exitButton.setBounds(662, 24, 127, 38);
		contentPane.add(exitButton);

		exitButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		if (id == 0) {
			lblTitle.setText("Think-Tac-Toe Rules");
			lblRules.setText("Think-Tac-Toe plays very similarly to the classic Tic-Tac-Toe. Each player will be given a chance to put down a piece. Once a player has selected a spot to place their piece, they must beat their opponent in a cognitive minigame for the piece to be placed on that spot. If the player fails in placing their piece, their opponent may now select a spot. The opponent will have to win their minigame to place their piece as well. The winner is determined when a player places 3 pieces in a straight line.");
		}
		else if (id == 1) {
			lblTitle.setText("Pattern Minigame Rules");
			lblRules.setText("<html>After stating the game it will display the pattern. Upon clicking ready \n the pattern will disapear. You must then repeat back the pattern \n using the color button. If you get it correct it will switch players and go again as the pattern grows until \n one player gets it wrong.</html>");
		}
		else if (id == 2) {
			lblTitle.setText("Memory Shape Minigame Rules");
			lblRules.setText("<html>- Click on the card to reveal the shape behind it <br> - Only two shapes can bee seen at a time <br> - Two consecutive cards with the same shape will get eliminated <br> - The game ends when all cards get eliminated <br>  - The player wins the game with less moves made than the other player</html>");

		}
		else if (id == 3) {
			lblTitle.setText("Brick Breaker Minigame Rules");
			lblRules.setText("<html>When you have joined the Brick Breaker Game, press either left or right arrow key to start the game. \n Move the paddle around to keep the ball in the board and break the bricks \n and make sure the ball doesn't hit the ground. \n if you are able to break all the bricks, you'll win. else you'll lose.</html>");

		}
		else if (id == 4) {
			lblTitle.setText("Select the equation that evaluates HIGHER or LOWER than the other, depending on the instruction above. Click the equals button if they evaluate to the same value");
		}
		else if (id == 5) {
			lblTitle.setText("Reaction Time Minigame Rules");
			lblRules.setText("<html>Player 1 must press the �Player 1 Start Game� button. Then, the user must click on the button labeled �Click Me!� \n as fast as they can. After pressing the button, the user must click on the �Press Again� button which will give the user another �Click Me!� button. This process repeats five times until it is Player 2�s turn. Player 2 will press the �Player 2 Start Game� button, and repeat the process Player 1 has gone through. At the end, each of the player�s average reaction speed will be calculated and a winner will be announced on the screen. Press the �Exit Game� button to exit the minigame.</html>");
		}
		
	}
}
