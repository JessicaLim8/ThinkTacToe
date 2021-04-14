package thinktactoeGame;

import javax.swing.*;

import mainMenu.MainMenuController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen {
	
	private static GameScreen instance;
	
	private GameController gameController;
	
	private static JFrame frame;
	private JTextField coordinateField;
	private JTextArea statusMessage;
	private JPanel gameArea;
	private JLabel turn;
	private JButton menuButton;
	
	private GameScreen(GameController gc) {
		this.gameController = gc;
	}
	
	public static GameScreen getInstance(GameController gc) {
		if (instance == null) {
			instance = new GameScreen(gc);
		}
		return instance;
	}
	
	private void initialScreen() {
		this.frame = new JFrame("Think-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 830);
        
        JPanel inputPanel = new JPanel();
        JPanel creditPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(200,800));
        creditPanel.setPreferredSize(new Dimension(1000,30));

        // Center Tic-Tac-Toe board
        this.gameArea = this.gameController.getBoard(); 
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        
        // Enter coordinate
        JLabel label1 = new JLabel("Enter a coordinate:");
        this.coordinateField = new JTextField("Eg: 11",2);
        p1.setLayout(new GridLayout(0,1));
        p4.add(label1);
        p1.add(p4);
        p1.add(coordinateField);
        
        // Submit and Clear button
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        p3.setLayout(new GridLayout(0,2));
        p3.add(submit);
        p3.add(clear);
        p1.add(p3);
        
        menuButton = new JButton("Menu");
	    menuButton.setBounds(875, 750, 89, 23);
	    frame.getContentPane().add(menuButton);
        
        
        // Error or Success Message
        this.statusMessage = new JTextArea("");
        
        this.statusMessage.setPreferredSize(new Dimension(190,50));
        this.statusMessage.setEditable(false);
        p2.add(statusMessage);
        p1.setPreferredSize(new Dimension(200,100));
        
        JLabel l1 = new JLabel("Current Player Turn:");
        l1.setFont(new Font(l1.getFont().getName(), Font.PLAIN, 20));
        turn = new JLabel("Player " + this.gameController.getTurn());
        turn.setFont(new Font(l1.getFont().getName(), Font.PLAIN, 20));
        p5.add(l1);
        p5.add(turn);
        p5.setPreferredSize(new Dimension(200,90));
        
        
        // Rules
        JPanel rulePanel = new JPanel();
        rulePanel.setLayout(new GridLayout(2,1));
        JLabel l2 = new JLabel("ThinkTacToe Rules:");
        l2.setFont(new Font(l1.getFont().getName(), Font.PLAIN, 20));
//        l2.setPreferredSize(new Dimension(200,270));
        rulePanel.add(l2);
        
//        TODO Add rules for the game
        String rules = "-The first player to get 3 of his/her marks in a row (up, down, across, or diagonally) wins the game. \n\n"
        		+ "-When all squares on the baord are full, the game is over";
        
        JTextArea description = new JTextArea();
        description.setEditable(false);
        description.setLineWrap(true);
        description.setText(rules);
//        description.setPreferredSize(new Dimension(200,250));
        rulePanel.add(description);
        
        inputPanel.add(p5);
        inputPanel.add(p1);
        inputPanel.add(p2);
        inputPanel.add(rulePanel);
        // Credit Panel
        JLabel author = new JLabel("3A04 - Software Design III  |  T2 Group 3");
        creditPanel.add(author);
        
        submit.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	String coord = coordinateField.getText();
      		gameController.coordEntered(coord);
          }
        });
        
        clear.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	coordinateField.setText("");
        	statusMessage.setText(null);
          }
        });
        
        menuListener();
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.EAST, inputPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, creditPanel);
        
        frame.getContentPane().add(BorderLayout.CENTER, gameArea);
        frame.setVisible(true);
	}

	
	public void updateStatusMessage(String msg) {
		this.statusMessage.setText(msg);
	}
	
	public void updateTurn(char turn) {
		this.turn.setText("Player " + this.gameController.getTurn());
	}
	
	private boolean isNumeric(String coord) {
	    if (coord == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(coord);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public void hide() {
		this.frame.setVisible(false);
	}
	
	public void show() {
		this.frame.setVisible(true);
	}
	
	public void destroy() {
		this.frame.dispose();
	}
	
	public void showScreen(){
		initialScreen();
	}
	
	private void menuListener() {
		menuButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.displayMenu(0);
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


}
