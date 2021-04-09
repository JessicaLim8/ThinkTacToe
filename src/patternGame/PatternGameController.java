package patternGame;
import java.awt.EventQueue;

import thinktactoeGame.Minigame;
import thinktactoeGame.GameController;

public class PatternGameController implements Minigame {
		
	public static void main(String[] args) {
//		PatternGameState state = new PatternGameState();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternGameUI window = new PatternGameUI();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void startGame(char player) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternGameUI window = new PatternGameUI();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void endGame(boolean p1Wins) {
		GameController gc = GameController.getInstance();
		gc.dropPiece(p1Wins);
	}
		

}
