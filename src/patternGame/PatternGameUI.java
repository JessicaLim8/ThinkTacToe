package patternGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mainMenu.MainMenuController;
import thinktactoeGame.GameController;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PatternGameUI {

	private static JFrame frame;
	private JButton startButton;
	private JButton readyButton;
	private JButton redButton;
	private JButton blueButton;
	private JButton greenButton;
	private JButton yellowButton;
	private JLabel patternLabel;
	private static int turn;
	private int currPlayer;
	private String inputString;
	private int numInputs;
	private String patternString;
	private int[] pattern;
	private boolean gameOver;
	private boolean gameStarted;
	private boolean activeTurn;
	private boolean p1Wins;
	
	/**
	 * @wbp.nonvisual location=980,771
	 */
	private final JPanel panel = new JPanel();
	private JButton menuButton;

	public PatternGameUI() throws Exception {
		createFrame();
		pattern = generatePattern();
		turn = 0;
		currPlayer = 1;
		gameOver = false;
		gameStarted = false;
		activeTurn = false;
		startButton();
		menuListener();
		
	}

	/**
	 * @throws Exception 
	 * @wbp.parser.entryPoint
	 */
	private void createFrame() throws Exception {
		frame = new JFrame("PatternGameScreen");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel patternGameTitle = new JLabel("Pattern Game");
		patternGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		patternGameTitle.setBounds(314, 11, 161, 14);
		frame.getContentPane().add(patternGameTitle);
		
		redButton = new JButton();
		redButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		redButton.setBackground(Color.RED);
		redButton.setForeground(Color.RED);
		redButton.setBounds(232, 292, 100, 100);
		frame.getContentPane().add(redButton);
		
		greenButton = new JButton();
		greenButton.setForeground(Color.GREEN);
		greenButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		greenButton.setBackground(Color.GREEN);
		greenButton.setBounds(417, 292, 100, 100);
		frame.getContentPane().add(greenButton);
		
		blueButton = new JButton();
		blueButton.setForeground(Color.BLUE);
		blueButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		blueButton.setBackground(Color.BLUE);
		blueButton.setBounds(232, 450, 100, 100);
		frame.getContentPane().add(blueButton);
		
		yellowButton = new JButton();
		yellowButton.setForeground(Color.YELLOW);
		yellowButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.setBounds(417, 450, 100, 100);
		frame.getContentPane().add(yellowButton);
	    
	    patternLabel = new JLabel("");
	    patternLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    patternLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    patternLabel.setBounds(10, 152, 764, 100);
	    frame.getContentPane().add(patternLabel);
	    
	    startButton = new JButton("Start Game");
	    startButton.setBounds(284, 59, 175, 31);
	    frame.getContentPane().add(startButton);
	    
	    readyButton = new JButton("Ready");
	    readyButton.setBounds(284, 101, 175, 31);
	    frame.getContentPane().add(readyButton);
	    
	    menuButton = new JButton("Menu");
	    menuButton.setBounds(10, 10, 89, 23);
	    frame.getContentPane().add(menuButton);
	    
	    frame.setVisible(true);
	}
	
	private void startButton() throws Exception {
		startButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				try {
					startButtonPressed();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void startButtonPressed() throws Exception {
		if (!gameOver) {
			patternString = patternString(pattern);
			patternLabel.setText(patternString);
			System.out.println(patternString);
			if (!gameStarted) {
				startButton.setText("Player 1's Turn");
			}
			frame.invalidate();
			frame.validate();
			SwingUtilities.updateComponentTreeUI(frame);
			
			readyButton.addActionListener(new ActionListener()
		    {
				public void actionPerformed(ActionEvent e) {
					numInputs = 0;
					inputString = "";
			
					if (!gameStarted) {
						startButtonListeners();
						gameStarted = true;
					} else if (!gameOver) {
						playerTurn();
						activeTurn = true;
					} 
				}
			});
		} else {
			frame.dispose();
			PatternGameController.endGame(p1Wins);
		}
		

		
	}
	
	private void menuListener() {
		menuButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.displayMenu(1);
				frame.setVisible(false);
			}
		});
	}
	
	public static void returnToGame() {
		System.out.println("Show Frame");
		frame.setVisible(true);
		frame.invalidate();
		frame.validate();
	}
	
	private void startNextTurn() throws Exception {
		
			patternString = patternString(pattern);
			patternLabel.setText(patternString);
			startButton.setText("Player " + currPlayer + "'s Turn");
			System.out.println(patternString);
			frame.invalidate();
			frame.validate();
			SwingUtilities.updateComponentTreeUI(frame);
		
		

		
	}
	
	
	private static int[] generatePattern() {
		Random rand = new Random();
		int[] pattern = new int[30];
		
		for (int i=0; i<30; i++) {
			pattern[i] = rand.nextInt(4);
		}
		System.out.println("P:" + pattern[0]);
		return pattern;
	}
	
	private static String patternString(int[] pattern) {
		String output = "";
		for (int i=0; i<(turn+3); i++) {
			System.out.println("PT:" + pattern[i]);
			if (pattern[i] == 0) {
				output = output + " RED";
			} else if (pattern[i] == 1) {
				output = output + " BLUE";
			} else if (pattern[i] == 2) {
				output = output + " GREEN";
			} else if (pattern[i] == 3) {
				output = output + " YELLOW";
			} 
		}
		System.out.println("O:" + output);
		return output;
	}
	
	private void playerTurn() {
		patternLabel.setText("");
		numInputs = 0;
		inputString = "";
		
	}
	
	private void startButtonListeners() {

		redButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				if (!activeTurn) return;
				inputString = inputString + " RED";
				numInputs += 1;
				try {
					checkInput();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		blueButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				if (!activeTurn) return;
				inputString = inputString + " BLUE";
				numInputs += 1;
				try {
					checkInput();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		greenButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				if (!activeTurn) return;
				inputString = inputString + " GREEN";
				numInputs += 1;
				try {
					checkInput();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		yellowButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				if (!activeTurn) return;
				inputString = inputString + " YELLOW";
				numInputs += 1;
				try {
					checkInput();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
//		if (checkInput() == 2) return;
	}
	
	private int checkInput() throws Exception {
		if (numInputs != (turn + 3)) return 0;
		if (inputString.equals(patternString)) {
			System.out.println("Pattern Matched");
			patternLabel.setText("Pattern Matched");
			activeTurn = false;
			nextTurn();
			return 1;
		} else {
			System.out.println("Pattern Didnt Match"  + inputString);
			gameOver = true;
			startButton.setText("Return to Main Game");
			patternLabel.setText("Pattern didnt Match - Player " + currPlayer + " Lost");
			p1Wins = currPlayer == 2;
			return 2;
		}
//		GameController gc = GameController.getInstance();
//		gc.dropPiece(results[0]>results[1]);
		
	}
	
	private void nextTurn() throws Exception {
		turn += 1;
		currPlayer = (turn%2) +1;
		inputString = null;
		inputString = "";
		numInputs = 0;
		startNextTurn();
	}
}
