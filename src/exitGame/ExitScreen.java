package exitGame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

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
		
	
		JButton button = new JButton("Exit Game");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(250, 364, 171, 82);
		exitFrame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Restart Game");
		button_1.setBounds(250, 255, 171, 82);
		exitFrame.getContentPane().add(button_1);
		
		exitFrame.setVisible(true);

		
	}
}
