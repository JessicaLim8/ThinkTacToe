package reactionGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Gui extends JFrame {
	JButton btnStartGame2;
	JLabel lblPlayer2;
	JLabel lblPlayer1;
	JButton btnStartGame1;
	long startTime, endTime;
	long clickTime, score;
	boolean final1 = false;
	boolean final2 = false;
	int player = 1;
	int i = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWinner = new JLabel("");
		lblWinner.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWinner.setBounds(295, 109, 209, 37);
		contentPane.add(lblWinner);
		
		
		JLabel lblScore = new JLabel("");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblScore.setBounds(295, 70, 209, 37);
		contentPane.add(lblScore);
		
		JButton btnExit = new JButton("Exit Game");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//send int winner somewhere
				System.exit(0);
			}
		});
		btnExit.setBounds(350, 164, 101, 21);
		contentPane.add(btnExit);
		btnExit.setVisible(false);
		
		JButton btn0 = new JButton("Click Me!");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn0.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				i++;
			}
		});
		btn0.setBounds(31, 189, 135, 21);
		contentPane.add(btn0);
		btn0.setVisible(false);
		
		JButton btn1 = new JButton("Click Me!");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn1.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn1.setBounds(42, 540, 124, 62);
		contentPane.add(btn1);
		btn1.setVisible(false);
		
		JButton btn2 = new JButton("Click Me!");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn2.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn2.setBounds(216, 156, 124, 507);
		contentPane.add(btn2);
		btn2.setVisible(false);

		JButton btn3 = new JButton("Click Me!");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn3.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn3.setBounds(42, 292, 164, 163);
		contentPane.add(btn3);
		btn3.setVisible(false);

		JButton btn4 = new JButton("Click Me!");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn4.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn4.setBounds(475, 160, 367, 28);
		contentPane.add(btn4);
		btn4.setVisible(false);

		JButton btn5 = new JButton("Click Me!");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn5.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn5.setBounds(713, 574, 112, 28);
		contentPane.add(btn5);
		btn5.setVisible(false);

		JButton btn6 = new JButton("Click Me!");		
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn6.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});

		btn6.setBounds(463, 464, 367, 28);
		contentPane.add(btn6);
		btn6.setVisible(false);

		JButton btn7 = new JButton("Click Me!");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn7.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn7.setBounds(475, 363, 167, 92);
		contentPane.add(btn7);
		btn7.setVisible(false);

		JButton btn8 = new JButton("Click Me!");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn8.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn8.setBounds(549, 257, 293, 37);
		contentPane.add(btn8);
		btn8.setVisible(false);

		JButton btn9 = new JButton("Click Me!");		
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				endTime = System.currentTimeMillis();
				clickTime = GuiController.calcTime(startTime, endTime);
				GuiAbstraction.setScore(player, i, clickTime);
				score = GuiController.calcAvg(player, i);
				lblScore.setText("Average reaction time: " + score + "ms");
				btn9.setVisible(false);
				i++;
				if (final1) {
					btnStartGame2.setVisible(true);
					final1 = false;
					i=0;
					player = 2;
				}
				if (final2) {
					int winner = GuiController.calcWinner();
					lblWinner.setText("Player " +winner+ " is victorious!");
					btnExit.setVisible(true);
					long score1 = GuiController.calcAvg(1, 4);
					long score2 = GuiController.calcAvg(2, 4);
					lblPlayer1.setText("Player 1 time: " + score1 + "ms");
					lblPlayer2.setText("Player 2 time: " + score2 + "ms");
					lblScore.setText("");
					btnStartGame2.setVisible(false);
				}
				
			}
		});
		btn9.setBounds(450, 582, 192, 13);
		contentPane.add(btn9);
		btn9.setVisible(false);
		
		btnStartGame2 = new JButton("Player 2 Start Game");
		btnStartGame2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnStartGame2.setText("Press Again \n Attempt " + (i+1) + "/5");
				for (int j = 0; j < 1; j++) {
					int randButton = GuiController.calcRand();
					GuiController.calcSleep();
					startTime = System.currentTimeMillis();
					if (randButton == 0) {
						btn0.setVisible(true);
					}
					else if (randButton == 1) {
						btn1.setVisible(true);
					}
					else if (randButton == 2) {
						btn2.setVisible(true);
					}
					else if (randButton == 3) {
						btn3.setVisible(true);
					}
					else if (randButton == 4) {
						btn4.setVisible(true);
					}
					else if (randButton == 5) {
						btn5.setVisible(true);
					}
					else if (randButton == 6) {
						btn6.setVisible(true);
					}
					else if (randButton == 7) {
						btn7.setVisible(true);
					}
					else if (randButton == 8) {
						btn8.setVisible(true);
					}
					else if (randButton == 9) {
						btn9.setVisible(true);
					}
					if (i == 4) {
						final2 = true;
					}
				}
			}
		});
		btnStartGame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStartGame2.setBounds(533, 23, 226, 106);
		contentPane.add(btnStartGame2);
		btnStartGame2.setVisible(false);
		
		btnStartGame1 = new JButton("Player 1 Start Game");
		btnStartGame1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnStartGame1.setText("Press Again \n Attempt " + (i+1) + "/5");
				for (int j = 0; j < 1; j++) {
					int randButton = GuiController.calcRand();
					GuiController.calcSleep();
					startTime = System.currentTimeMillis();
					if (randButton == 0) {
						btn0.setVisible(true);
					}
					else if (randButton == 1) {
						btn1.setVisible(true);
					}
					else if (randButton == 2) {
						btn2.setVisible(true);
					}
					else if (randButton == 3) {
						btn3.setVisible(true);
					}
					else if (randButton == 4) {
						btn4.setVisible(true);
					}
					else if (randButton == 5) {
						btn5.setVisible(true);
					}
					else if (randButton == 6) {
						btn6.setVisible(true);
					}
					else if (randButton == 7) {
						btn7.setVisible(true);
					}
					else if (randButton == 8) {
						btn8.setVisible(true);
					}
					else if (randButton == 9) {
						btn9.setVisible(true);
					}

					if (i == 4) {
						btnStartGame1.setVisible(false);
						final1 = true;
					}
				}
			}
		});
		btnStartGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStartGame1.setBounds(31, 23, 226, 106);
		contentPane.add(btnStartGame1);
		
		
		JLabel lblTitle = new JLabel("Reaction Time Minigame");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(314, 10, 209, 74);
		contentPane.add(lblTitle);
		
		lblPlayer1 = new JLabel("");
		lblPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPlayer1.setBounds(41, 130, 209, 28);
		contentPane.add(lblPlayer1);
		
		lblPlayer2 = new JLabel("");
		lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPlayer2.setBounds(530, 130, 209, 28);
		contentPane.add(lblPlayer2);
		

		
		

	}
}
