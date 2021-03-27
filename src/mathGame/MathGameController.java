package mathGame;

import java.awt.EventQueue;

public class MathGameController {
	
	public static void main(String[] args) {
		MathGameState state = new MathGameState();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathGameUI window = new MathGameUI(state);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
}
