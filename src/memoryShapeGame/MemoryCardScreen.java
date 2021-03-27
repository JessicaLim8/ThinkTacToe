import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemoryCardScreen {
	
	private static MemoryCardScreen instance;
	
	private MemoryCardController controller;
	
	private JTextField moves;
	private JTextField cardsLeft;
	
	private MemoryCardScreen(MemoryCardController gc) {
		this.controller = gc;
	}
	
	public static MemoryCardScreen getInstance(MemoryCardController gc) {
		if (instance == null) {
			instance = new MemoryCardScreen(gc);
		}
		return instance;
	}
	
	private void initialScreen() {
		JFrame frame = new JFrame("Memory Card - 2D shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel info = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        JButton startGame = new JButton("Start Game");
        JButton displayRule = new JButton("Rule");
        p1.add(startGame);
        p1.add(displayRule);
        
        JLabel gameTitle = new JLabel("Memory Card - 2D shapes");
        p2.add(gameTitle);
        
        JLabel displayMoves = new JLabel("Moves:");
        this.moves = new JTextField("0");
        this.moves.setPreferredSize(new Dimension(40, 30));
        p3.add(displayMoves);
        p3.add(moves);
        
        JLabel displayCardsLeft = new JLabel("Cards Left:");
        this.cardsLeft = new JTextField("16");
        this.cardsLeft.setPreferredSize(new Dimension(40, 30));
        p3.add(displayCardsLeft);
        p3.add(cardsLeft);
        
        info.setLayout(new GridLayout(1,3));
        info.add(p1);
        info.add(p2);
        info.add(p3);
        
        JPanel game = new JPanel();
        game.setLayout(new GridLayout(4,4,2,2));
        Card[] cards = this.controller.initCards();
        for (Card card: cards) {
        	game.add(card);
        }

        frame.getContentPane().add(BorderLayout.NORTH, info);
        frame.getContentPane().add(BorderLayout.CENTER, game);
        frame.setVisible(true);
	}
	
	public void showScreen(){
		initialScreen();
	}
	
	public void updateCardsLeft(int left) {
		this.cardsLeft.setText(Integer.toString(left));
	}
	
	public void updateMoves(int moves) {
		this.moves.setText(Integer.toString(moves));
	}
}
