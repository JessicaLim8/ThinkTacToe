package mathGame;

import java.awt.EventQueue;

import thinktactoeGame.Minigame;

public class MathGameController implements Minigame{
	
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

	@Override
	public String getRules() {
		return "rules";
	}
	
	@Override
	public boolean startGame(char player) {
		// TODO Auto-generated method stub
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
		int[] results = state.getScores();
		return results[0]>results[1];
	}	
	
}