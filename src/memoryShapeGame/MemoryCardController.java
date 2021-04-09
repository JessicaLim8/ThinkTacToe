package memoryShapeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import thinktactoeGame.Minigame;

public class MemoryCardController implements Minigame {

	private static MemoryCardController instance = new MemoryCardController();
	
	private MemoryCardScreen gameScreen;
	
	private String[] shapes = {"triangle", "triangle", "star", "star",
			  "hexagon", "hexagon", "trapezoid", "trapezoid",
			  "kite", "kite", "octagon", "octagon",
			  "parallelogram", "parallelogram", "diamond", "diamond"};
	
	private Card[] cards = new Card[16];
	
	private Queue<Card> pq = new LinkedList<>();
	
	private int cardsLeft = 16;
	private int moves = 0;
	
	private char turn;
	
	private MemoryCardController() {
		this.gameScreen = MemoryCardScreen.getInstance(this);
	}
	
	public static MemoryCardController getInstance() {
		return instance;
	}
	
//	public String getRules() {
//		 String rules = " - Click on the card to reveal the shape behind it \n" +
//                 " - Two consecutive cards with the same shape will get eliminated \n" +
//                 " - The game ends when all cards get eliminated \n" +
//                 " - The player wins the game with less moves made than the other player";
//		 return rules;
//	}
	
	public Card[] initCards() {
//		List<String> shuffledList = Arrays.asList(shapes);
//		Collections.shuffle(shuffledList);
//		shuffledList.toArray(shapes);
		for (int i = 0; i < shapes.length; i++) {
        	Card card = new Card(shapes[i]);
        	card.addActionListener(e -> {
				moves = moves + 1;
				gameScreen.updateMoves(moves);
				if (pq.size() >= 2) {
					Card temp = pq.poll();
					Card temp1 = pq.poll();
					temp.flip();
					temp1.flip();
				}
				else if (pq.size() == 1) {
					Card prev = pq.peek();
					if (prev == card) {
						return;
					}
					if(prev.getShape() == card.getShape()) {
						card.flip();
						prev = pq.poll();
						prev.eliminate();
						card.eliminate();
						cardsLeft = cardsLeft-2;
						gameScreen.updateCardsLeft(cardsLeft);
						return;
					}
				}
				card.flip();
				pq.add(card);

});
        	this.cards[i] = card;
        }
		return this.cards;
	}
	
	private int initGame(char player) {
		// Launch the minigame in a new window
		this.gameScreen.showScreen();
		this.gameScreen.updateTurn("Player " + player);
		this.cardsLeft = 16;
		this.moves = 0;
		gameScreen.updateCardsLeft(cardsLeft);
		gameScreen.updateMoves(moves);
		while(this.cardsLeft != 0) { 
			gameScreen.updateCardsLeft(cardsLeft);
		}
		return this.moves;
	}
	
	@Override
	public boolean startGame(char player) {
		this.turn = player;
		int firstPlayerMoves = initGame(turn);
		this.gameScreen.close();
		this.turn = this.turn == 'X' ? 'O' : 'X';
		int secondPlayerMoves = initGame(turn);
		this.gameScreen.updateTurn("GAME OVER!");
		this.gameScreen.close();
		// returns who wins the game
		// True: if the first player wins the game
		return firstPlayerMoves < secondPlayerMoves;
	}
}
