package mathGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;

public class MathGameUI {

	private JFrame frame;
	private JPanel gameArea;
	
	
	private JTextField textField;
	
	private JTextField coordinateField;
	private JTextArea statusMessage;

	/**
	 * @wbp.nonvisual location=980,771
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathGameUI window = new MathGameUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MathGameUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("MathGameScreen");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel titlePanel = new JPanel();
        JPanel creditPanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(800,200));
        creditPanel.setPreferredSize(new Dimension(800,30));
        
        // Credit Panel
        JLabel author = new JLabel("3A04 - Software Design III  |  T2 Group 3");
        creditPanel.add(author);
        
        // Credit Panel
        JLabel gameTitle = new JLabel("Speed Math");
        titlePanel.add(gameTitle);
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, titlePanel);
        frame.getContentPane().add(BorderLayout.SOUTH, creditPanel);
        mathGameScreen();
        frame.setVisible(true);
	}
	
	private void initialMathScreen() {
		this.gameArea = new JPanel();
		JLabel intro = new JLabel(String.format("Hello Player %d", 1));
		JButton start = new JButton("Start Game");
		intro.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		p1.add(intro);
		p1.add(start);
		
		gameArea.add(p1);
        frame.getContentPane().add(BorderLayout.CENTER, gameArea);
        
        start.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				mathGameScreen();
				System.out.println("hello print");
			}
		});
	}
	
	private void endMathScreen() {
		this.gameArea = new JPanel();
		JLabel intro = new JLabel(String.format("Congrats Player %d", 1));
		JLabel score = new JLabel(String.format("Minigame Score: %d", 1));
		JButton end = new JButton("End Game");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(intro);
		p1.add(score);
		p1.add(end);
		
		gameArea.add(p1);
        frame.getContentPane().add(BorderLayout.CENTER, gameArea);
        
        end.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				mathGameScreen();
				System.out.println("hello print");
			}
		});
	}
	
	private void gameOverScreen() {
		this.gameArea = new JPanel();
		JLabel intro = new JLabel("Final Results");
		JLabel result = new JLabel(String.format("Winner: Player %d", 1));
		JLabel scores = new JLabel(String.format("Player 1: %d | Player 2: %d", 1, 10));
		JButton gameover = new JButton("Exit Minigame");

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(intro);
		p1.add(result);
		p1.add(scores);
		p1.add(gameover);
		
		gameArea.add(p1);
        frame.getContentPane().add(BorderLayout.CENTER, gameArea);
        
        gameover.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				mathGameScreen();
				System.out.println("hello print");
			}
		});
	}
	
	private void mathGameScreen() {
		this.gameArea = new JPanel();
		JLabel question = new JLabel(String.format("Select the %s equation", "larger"));
		question.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton eq1 = new JButton("Equation1");
		JButton eq2 = new JButton("Equation2");
		eq1.setPreferredSize(new Dimension(45,50));
		eq2.setPreferredSize(new Dimension(45,50));
		eq1.setAlignmentX(Component.CENTER_ALIGNMENT);
		eq2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel score = new JLabel(String.format("Current Score: ", "1"));
		score.setAlignmentX(Component.CENTER_ALIGNMENT);
	 
	    this.gameArea.setLayout(new BoxLayout(this.gameArea, BoxLayout.PAGE_AXIS));
	    this.gameArea.add(question);
	    this.gameArea.add(eq1);
	    this.gameArea.add(eq2);
	    this.gameArea.add(score);
	    
		
        eq1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				mathGameScreen();
				System.out.println("hello print");
			}
		});
		    
        eq2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				mathGameScreen();
				System.out.println("hello print");
			}
		});
	    
	    frame.getContentPane().add(BorderLayout.CENTER, gameArea);
	}

}
