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

import java.time.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MathGameUI {

	private JFrame frame;
	private MathGameState state;
	private Timer t;

	/**
	 * @wbp.nonvisual location=980,771
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Create the application.
	 */
	public MathGameUI(MathGameState state) {
		initialize(state);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MathGameState state) {
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
        initialScreen(state);
        frame.setVisible(true);
	}
	
	private void initialScreen(MathGameState state) {
		JPanel initalScreen = new JPanel();
		JLabel intro = new JLabel(String.format("Hello Player %d", state.getPlayer()));
		JButton start = new JButton("Start Game");
		intro.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		p1.add(intro);
		p1.add(start);
		
		initalScreen.add(p1);
        frame.getContentPane().add(BorderLayout.CENTER, initalScreen);
        
        start.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(initalScreen);
				mathScreen(state);
				frame.invalidate();
				frame.validate();
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
        frame.setVisible(true);
	}
	
	private void scoreScreen(MathGameState state) {
		JPanel endScreen = new JPanel();
		JLabel intro = new JLabel(String.format("Congrats Player %d", state.getPlayer()));
		JLabel score = new JLabel(String.format("Minigame Score: %d", state.getCScore()));
		JButton end = new JButton("Finish");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(intro);
		p1.add(score);
		p1.add(end);
		
		endScreen.add(p1);
        frame.getContentPane().add(BorderLayout.CENTER, endScreen);
        
        end.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(endScreen);
				boolean isP1 = state.nextPlayer();
				if (isP1) {
					initialScreen(state);
				} else {
					gameOverScreen(state);
				}
				frame.invalidate();
				frame.validate();
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
	}
	
	private void gameOverScreen(MathGameState state) {
		int[] results = state.getScores();
		
		String scoreLabel;
		if (results[0] == results[1]) {
			scoreLabel = "It's a tie, Play Again!";
		} else {
			scoreLabel = String.format("Winner: Player %d", results[0] > results[1] ? 1 : 2);
		}
		
		
		JPanel goScreen = new JPanel();
		JLabel intro = new JLabel("Final Results");
		JLabel result = new JLabel(scoreLabel);
		JLabel scores = new JLabel(String.format("Player 1: %d | Player 2: %d", results[0], results[1]));
		JButton gameover = new JButton("Exit Minigame");

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(intro);
		p1.add(result);
		p1.add(scores);
		p1.add(gameover);
		
		goScreen.add(p1);
        frame.getContentPane().add(BorderLayout.CENTER, goScreen);
        
        gameover.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(goScreen);
				if (results[0] == results[1]) {
					initialize(new MathGameState());
				}
				frame.invalidate();
				frame.validate();
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
	}
	
	private void mathScreen(MathGameState state) {
		String[] eq = state.generateEquations();
		JPanel gameArea = new JPanel();
		JLabel title = new JLabel(String.format("Player %d", state.getPlayer()));
		JLabel question = new JLabel(String.format("Select equation with the %s value", state.getGoal() == -1 ? "LOWER" : "HIGHER"));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		question.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton eq1 = new JButton(eq[0]);
		JButton eq2 = new JButton(eq[1]);
		JButton eq3 = new JButton("Equal");
		eq1.setPreferredSize(new Dimension(45,50));
		eq2.setPreferredSize(new Dimension(45,50));
		eq3.setPreferredSize(new Dimension(45,50));
		eq1.setAlignmentX(Component.CENTER_ALIGNMENT);
		eq2.setAlignmentX(Component.CENTER_ALIGNMENT);
		eq3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton end = new JButton("End Turn");
		end.setPreferredSize(new Dimension(45,50));
		end.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel score = new JLabel(String.format("Current Score: %d", state.getCScore()));
		score.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		int countdown = 30;
		Date startDate = new Date();
		
		JLabel timerLabel = new JLabel(String.format("Time Remaining: %d", countdown));
		timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);		
	 
	    gameArea.setLayout(new BoxLayout(gameArea, BoxLayout.PAGE_AXIS));
	    gameArea.add(title);
	    gameArea.add(question);
	    gameArea.add(eq1);
	    gameArea.add(eq2);
	    gameArea.add(eq3);
	    gameArea.add(score);
	    gameArea.add(timerLabel);
	    
	    if (t != null) {
	    	t.stop();
	    }
	    
		t = new javax.swing.Timer(1000, new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Date now = new Date();
		    	  float ctime = getDateDiff(startDate, now, TimeUnit.SECONDS);
		    	  timerLabel.setText(String.format("Time Remaining: %d", countdown - (int) ctime));
		          timerLabel.repaint();
		    	  if (ctime >= countdown) {
		    		  frame.getContentPane().remove(gameArea);
		    		  t.stop();
		    		  scoreScreen(state);
		    	  }
		      }
		   }
		);
		
		t.start();
	    
		
        eq1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				state.checkCorrect(0);
				updateGameState(state, eq1, eq2, question, score);
			}
		});
		    
        eq2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				state.checkCorrect(1);
				updateGameState(state, eq1, eq2, question, score);
			}
		});
        
        eq3.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				state.checkCorrect(2);
				updateGameState(state, eq1, eq2, question, score);
			}
		});
        
        end.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(gameArea);
				scoreScreen(state);
				frame.invalidate();
				frame.validate();
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
	    
	    frame.getContentPane().add(BorderLayout.CENTER, gameArea);
	}
	
	private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	private void updateGameState(MathGameState state, JButton eq1, JButton eq2, JLabel question, JLabel score) {
		String[] eq = state.generateEquations();
		eq1.setText(eq[0]);
		eq2.setText(eq[1]);
		question.setText(String.format("Select equation with the %s value", state.getGoal() == -1 ? "LOWER" : "HIGHER"));
		score.setText(String.format("Current Score: %d", state.getCScore()));
	}

}
