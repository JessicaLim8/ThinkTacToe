package mainMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuUI {
	
	private JFrame frame;
	private JButton returnButton;
	private JButton exitButton;
	private JButton rulesButton;
	
	/**
	 * @wbp.nonvisual location=980,771
	 */
	private final JPanel panel = new JPanel();

	public MainMenuUI() throws Exception {
		createFrame();
		buttonListeners();
		
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
		
		JLabel patternGameTitle = new JLabel("Main Menu");
		patternGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		patternGameTitle.setBounds(314, 11, 161, 14);
		frame.getContentPane().add(patternGameTitle);
		
		returnButton = new JButton("Return To Game");
		returnButton.setBounds(293, 135, 161, 44);
		frame.getContentPane().add(returnButton);
		
		rulesButton = new JButton("Show Rules");
		rulesButton.setBounds(293, 233, 161, 44);
		frame.getContentPane().add(rulesButton);
		
		exitButton = new JButton("Exit Application");
		exitButton.setBounds(293, 323, 161, 44);
		frame.getContentPane().add(exitButton);
		
		frame.setVisible(true);
	    
	}
	
	private void buttonListeners() throws Exception {
		returnButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.returnToPatternGame();
				frame.dispose();
			}
		});
		
		exitButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	
}
