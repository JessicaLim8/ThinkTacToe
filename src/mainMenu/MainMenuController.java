package mainMenu;

import java.awt.EventQueue;
import patternGame.PatternGameUI;

public class MainMenuController {
	public static void displayMenu(String ID) {
//		PatternGameState state = new PatternGameState();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("ID: " + ID);
					MainMenuUI window = new MainMenuUI();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void returnToPatternGame() {
		PatternGameUI.returnToGame();
	}
		
}
