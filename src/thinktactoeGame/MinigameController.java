package thinktactoeGame;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

import brickBreakerGame.BrickBreakerMain;
import mathGame.MathGameController;
import memoryShapeGame.MemoryCardController;
import patternGame.PatternGameController;
import reactionGame.Gui;
import reactionGame.GuiController;

public class MinigameController extends Thread{
	
	private Dictionary<Integer, Minigame> minigames = new Hashtable<Integer,  Minigame>();
	private MathGameController math;
	private MemoryCardController memory;
	private Gui reaction;
	private PatternGameController pattern;
	private GameController gc = GameController.getInstance();
	private BrickBreakerMain breaker;
	private int number;
	
	private char turn = 'X';
	
	public MinigameController(char turn, int num) {
		this.math = new MathGameController();
		this.memory = MemoryCardController.getInstance();
		this.pattern = new PatternGameController();
		this.breaker = new BrickBreakerMain();
		this.reaction = new Gui();
		this.turn = turn;
		this.number = num;
		// TODO initialize reaction, Mile's, and brick breaker mini game
		// 1 - Miles, 2 - Bill, 3 - Vansh, 4 - Jessica, 5 - Jack
		minigames.put(1, pattern);
		minigames.put(2, memory);
		minigames.put(3, breaker);
		minigames.put(4, math);
		minigames.put(5, reaction);
	}
	
	public void setTurn(char player) {
		this.turn = player;
	}


	public void run() {
//		Random rand = new Random();
//		int number = rand.nextInt(5) + 1;
//		number = 5; // test a specific game
		this.minigames.get(number).startGame(this.turn);
//		this.gc.dropPiece(result);
	}
	
	public static void main(String[] args) {
		(new MinigameController('X', 1)).start();
	}

}
