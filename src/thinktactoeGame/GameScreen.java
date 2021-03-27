package thinktactoeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen {
	
	private static GameScreen instance;
	
	private GameController gameController;
	
	private JTextField coordinateField;
	private JTextArea statusMessage;
	private JPanel gameArea;
	
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
		JFrame frame = new JFrame("Think-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 830);
        
        JPanel inputPanel = new JPanel();
        JPanel creditPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(200,800));
        creditPanel.setPreferredSize(new Dimension(1000,30));

        
        this.gameArea = this.gameController.getBoard();
               
        JLabel label1 = new JLabel("Enter a coordinate:");
        this.coordinateField = new JTextField("Eg: 23",2);
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        this.statusMessage = new JTextArea("");
        this.statusMessage.setLineWrap(true);
        this.statusMessage.setPreferredSize(new Dimension(200,50));
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        
        p1.setLayout(new GridLayout(0,1));
        p4.add(label1);
        p1.add(p4);
        p1.add(coordinateField);
        
        p3.setLayout(new GridLayout(0,2));
        p3.add(submit);
        p3.add(clear);
        p1.add(p3);
        
        p2.add(statusMessage);
        p2.setPreferredSize(new Dimension(200,630));
        
        
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.add(p1);
        inputPanel.add(p2);
        
        // Credit Panel
        JLabel author = new JLabel("3A04 - Software Design III  |  T2 Group 3");
        creditPanel.add(author);
        
        submit.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	String coord = coordinateField.getText();
        	if (coord.length() != 2 || !isNumeric(coord)) {
        		updateStatusMessage("Invalid Coordinate! \nExample Usage: 23");
        		return;
        	}
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
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.EAST, inputPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, creditPanel);
        
        frame.getContentPane().add(BorderLayout.CENTER, gameArea);
        frame.setVisible(true);
	}

	
	public void updateStatusMessage(String msg) {
		statusMessage.setText(msg);
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
	
	
	public void showScreen(){
		initialScreen();
	}


}
