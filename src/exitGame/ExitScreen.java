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
		JPanel panel;
		JTextArea textArea;
		
		exitFrame = new JFrame();
		exitFrame.setSize(800, 700);
		exitFrame.setTitle("Game Over");
		exitFrame.setResizable(true);
		exitFrame.setVisible(true);
		exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setSize(600, 600);
		panel.setBackground(Color.BLACK);
		panel.setVisible(true);
		exitFrame.setVisible(true);
		
		exitFrame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Restart Game");
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		textArea = new JTextArea("Game Over");
		panel.add(textArea);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitFrame.setVisible(true);
		
		
		
	}

}
