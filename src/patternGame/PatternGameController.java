package patternGame;
import java.awt.EventQueue;

public class PatternGameController {
		
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
		

}
