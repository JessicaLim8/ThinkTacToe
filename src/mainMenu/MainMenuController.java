package mainMenu;


import java.awt.EventQueue;
import patternGame.PatternGameUI;
import brickBreakerGame.BrickBreakerMain;
import mathGame.MathGameUI;
import memoryShapeGame.MemoryCardScreen;
import reactionGame.Gui;
import RulesWork.RulesController;
import thinktactoeGame.GameScreen;

public class MainMenuController {
	
	private static int gameID;
	
	public static void displayMenu(int ID) {
//		PatternGameState state = new PatternGameState();
		gameID = ID;
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
	
	public static void returnToGame() {
		if (gameID == 0) {
			GameScreen.returnToGame();
		} else if (gameID == 1) {
			PatternGameUI.returnToGame();
		} else if (gameID == 2) {
			MemoryCardScreen.returnToGame();
		} else if (gameID == 3) {
			BrickBreakerMain.returnToGame();
		} else if (gameID == 4) {
			MathGameUI.returnToGame();
		} else if (gameID == 5) {
			Gui.returnToGame();
		} else if (gameID == 0) {
			
		}
		
	}
	
	public static void showRules() {
		RulesController.showRules(gameID);
	}
		
}