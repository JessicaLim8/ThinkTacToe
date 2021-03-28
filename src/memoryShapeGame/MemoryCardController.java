package memoryShapeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MemoryCardController {

	// TODOs:
	// Rules Screen
	// Display which players turn

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
	
	private boolean forfeit = false;
	
	private MemoryCardController() {
		this.gameScreen = MemoryCardScreen.getInstance(this);
	}
	
	public static MemoryCardController getInstance() {
		return instance;
	}
	
	public Card[] initCards() {
		List<String> shuffledList = Arrays.asList(shapes);
		Collections.shuffle(shuffledList);
		shuffledList.toArray(shapes);
		for (int i = 0; i < shapes.length; i++) {
        	Card card = new Card(shapes[i]);
        	card.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
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
    	        	
    	        }
    	     });
        	this.cards[i] = card;
        }
		return this.cards;
	}
	
	public int startGame() {
		this.gameScreen.showScreen();
		this.cardsLeft = 16;
		this.moves = 0;
		gameScreen.updateCardsLeft(cardsLeft);
		gameScreen.updateMoves(moves);
		while(this.cardsLeft != 0) { 
			gameScreen.updateCardsLeft(cardsLeft);
		}
		System.out.println("Game ended");
		return this.moves;
	}
	
//	private void restartGame() {
//		this.cardsLeft = 16;
//		this.moves = 0;
//	}
//	
	
	public static void main(String[] args) {
		MemoryCardController gc = MemoryCardController.getInstance();
		int moves = gc.startGame();
		System.out.println(moves);
		moves = gc.startGame();
		System.out.println(moves);
	}
}
