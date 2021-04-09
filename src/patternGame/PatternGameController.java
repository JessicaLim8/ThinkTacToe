package patternGame;
import java.awt.EventQueue;

import thinktactoeGame.Minigame;

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
	public boolean startGame(char player) {
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
		return true;
	}
		

}
