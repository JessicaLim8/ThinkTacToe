package brickBreakerGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator (int row, int col)	{
		map = new int[row][col];		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = 1;
			}			
		}
		
		brickWidth = 640/col;
		brickHeight = 150/row;
	}	
	
	public void draw(Graphics2D g)	{
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				
				if(map[i][j] > 0){
					// Brick Color
					g.setColor(Color.red);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

					// Brick separation lines
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.white);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);				
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col)	{
		map[row][col] = value;
	}
}
