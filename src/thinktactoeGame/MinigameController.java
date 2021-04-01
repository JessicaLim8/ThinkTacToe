package thinktactoeGame;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

import mathGame.MathGameController;
import memoryShapeGame.MemoryCardController;
import reactionGame.GuiController;

public class MinigameController {

	private static MinigameController instance = new MinigameController();
	
	private Dictionary<Integer, Minigame> minigames = new Hashtable<Integer,  Minigame>();
	private MathGameController math;
	private MemoryCardController memory;
	private GuiController reaction;
	
	//TODO Add brick breaker controller
	//TODO Add Miles' minigame
	
	private MinigameController() {
		this.math = new MathGameController();
		this.memory = MemoryCardController.getInstance();
		
		// TODO initialize reaction, Mile's, and brick breaker mini game
		// 1 - Andrew, 2 - Bill, 3 - Vansh, 4 - Jessica, 5 - Jack
//		minigames.put(1, );
		minigames.put(2, memory);
//		minigames.put(3, );
		minigames.put(4, math);
//		minigames.put(5, );
	}
	
	public static MinigameController getInstance() {
		if (instance == null) {
			instance = new MinigameController();
		}
		return instance;
	}
	
	public boolean launchGame(char player) {
		// Generate a random number between 1 and 5;
		Random rand = new Random();
		int number = rand.nextInt(5 - 1 + 1) + 1;
		
		number = 2;
		this.minigames.get(number).startGame(player);
		return false;
	}
	
	public static void main(String[] args) {
		MinigameController mc = MinigameController.getInstance();
		mc.launchGame('X');
	}

}
