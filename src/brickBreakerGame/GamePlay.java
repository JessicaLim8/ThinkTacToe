package brickBreakerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import thinktactoeGame.GameController;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
	public static boolean play = false;
	private int score = 0;
	private int totalBricks = 30;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 350;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	public int player1 = 0;
	public int player2 = 0;
	public int gameCount = 0;
	
	private MapGenerator map;
	
	public GamePlay(){
		map = new MapGenerator(3, 10);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g){ 
		// background
		g.setColor(Color.cyan);
		g.fillRect(1, 1, 792, 692);
		
		// drawing map
		map.draw((Graphics2D) g);
		
		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 692);
		g.fillRect(0, 0, 792, 3);
		g.fillRect(781, 0, 3, 692);
		
		// the scores 		
		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString("Score: "+score, 670, 30);
		
		// the scores 		
		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.ITALIC, 25));
		g.drawString("Press Esc to Pause Game",30 ,30);

		// Player
		if(player1 == 0 && player2 == 0){
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD, 25));
			g.drawString("Player 1",350 ,30);
		}
		else{
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD, 25));
			g.drawString("Player 2",350 ,30);
		}
		
		// the paddle
		g.setColor(Color.blue);
		g.fillRect(playerX, 650, 170, 8);
		
		// the ball
		g.setColor(Color.black);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		// Paused Game
		if(!play) {
			g.setColor(Color.darkGray);
	        g.setFont(new Font("serif",Font.ITALIC, 30));
	        g.drawString("Press any arrow key to start the game", 200,300);
		}
		
	
		// when you won the game
		if(totalBricks <= 0){
			 play = false;
             ballXdir = 0;
     		 ballYdir = 0;
     		 
             g.setColor(Color.darkGray);
             g.setFont(new Font("serif",Font.BOLD, 30));
             g.drawString("You Won", 300,300);
             
             g.setColor(Color.darkGray);
             g.setFont(new Font("serif",Font.BOLD, 20));           
             g.drawString("Press (Enter) to Restart", 300,350);  
             
             gameTracker();
             
		}
		
		// when you lose the game
		if(ballposY > 670){
			 play = false;
             ballXdir = 0;
     		 ballYdir = 0;
     		 
             g.setColor(Color.darkGray);
             g.setFont(new Font("serif",Font.BOLD, 30));
             g.drawString("Game Over, Scores: "+score, 250,300);
             
             g.setColor(Color.darkGray);
             g.setFont(new Font("serif",Font.BOLD, 20));           
             g.drawString("Press (Enter) to Restart for next Player", 300,350);   
             
             gameTracker();
        }
		
		g.dispose();
	}	

	public static void pauseGame() {    
		if(play) {
			play = false; 		
		}
		else {
			play = true;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pauseGame();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){        
			if(playerX >= 600){
				playerX = 600;
			}
			else{
				moveRight();
			}
        }
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT){          
			if(playerX < 10){
				playerX = 10;
			}
			else{
				moveLeft();
			}
        }		
		if (e.getKeyCode() == KeyEvent.VK_ENTER){          
			if(!play){
				play = true;
				ballposX = 120;
				ballposY = 350;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 350;
				score = 0;
				totalBricks = 30;
				map = new MapGenerator(3, 10);
				
				repaint();
			}
        }		
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public void moveRight(){
		play = true;
		playerX+=20;	
	}
	
	public void moveLeft(){
		play = true;
		playerX-=20;	 	
	}
	
	public void gameEnd(boolean result) {
		GameController gc = GameController.getInstance();
        gc.dropPiece(result);
	}

	public void gameTracker(){
		if(player1 == 0 && player2 == 0){
			player1 = score;
			score = 0;
		}
		if(player1 != 0 && player2 == 0){
			player2 = score;
			score = 0;
		}
		if(player1 != 0 && player2 != 0){
			boolean res =  player1 > player2;
			player1 = 0;
			player2 = 0;
			System.out.println(player1 > player2);
			GameController gc = GameController.getInstance();
			gc.dropPiece(res);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play){			
//			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 650, 170, 8))){
//				ballYdir = -ballYdir;
//				ballXdir = -2;
//			}
//			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 650, 30, 8))){
//				ballYdir = -ballYdir;
//				ballXdir = ballXdir + 1;
//			}
//			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 650, 40, 8))){
//				ballYdir = -ballYdir;
//			}
			
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 650, 170, 8))){
				ballYdir = -ballYdir;
			}
			
			// check map collision with the ball		 
			A: for(int i = 0; i < map.map.length; i++){
				for(int j = 0; j < map.map[0].length; j++){

					if(map.map[i][j] > 0){
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);					
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)){	
											
							map.setBrickValue(0, i, j);
							score+=5;	
							totalBricks--;
							
							// when ball hit right or left of brick
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
								ballXdir = -ballXdir;
							}
							// when ball hits top or bottom of brick
							else{
								ballYdir = -ballYdir;				
							}
							
							break A;
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX < 0){
				ballXdir = -ballXdir;
			}
			if(ballposY < 0){
				ballYdir = -ballYdir;
			}
			if(ballposX > 760){
				ballXdir = -ballXdir;
			}		
			
			repaint();		
		}
	}
}
