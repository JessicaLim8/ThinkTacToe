package mathGame;


public class MathGameState {
	
	private int[] scores;
	private int player;
	private int cscore;
	private int[][] nums;
	private char[] op;
	private int goal;
	private boolean lastResult;
	
	public MathGameState() {
		this.scores = new int[]{0, 0};
		this.player = 1;
		this.resetValues();
	}
	
	public boolean nextPlayer() {
		if (this.player == 1) {
			this.scores[0] = cscore;
			this.player = 2;
			return true;
		}
		endGame();
		return false;
	}
	
	public void endGame() {
		this.scores[1] = cscore;
	}
	
	private void resetValues() {
		this.cscore = 0;
		this.nums = new int[2][2];
		this.op = new char[2];
		this.goal = 0;
	} 
	
	public int[] getScores() {
		return this.scores;
	}
	
	public int getPlayer() {
		return this.player;
	}
	
	public int getGoal() {
		return this.goal;
	}
	
	public int getCScore() {
		return cscore;
	}
	
	public boolean getLastResult() {
		return this.lastResult;
	}
	
	public boolean checkCorrect(int id) {
		if (id == 2) {
			lastResult = solveEquation(0) == solveEquation(1);
		} else if (goal == 1) {
			lastResult = solveEquation(id) > solveEquation((id + 1) % 2);
		} else {
			lastResult = solveEquation(id) < solveEquation((id + 1) % 2);
		}
		this.cscore += lastResult ? 1 : -1;
		return lastResult;
	}
	
	private double solveEquation(int id) {
		double result = 0;
		int a = this.nums[id][0];
		int b = this.nums[id][1];
				
		switch(this.op[id]) {
			case '+': result = a + b;
			case '-': result = a + b;
			case '*': result = a + b;
			case '/': result = a + b;
		}
		
		return result;
	}
	
	public String[] generateEquations() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.nums[i][j] = randInt();
			}
		}
		
		this.op[0] = this.randOp();
		this.op[1] = this.randOp();
		
		this.goal = Math.random() > 0.5 ? 1 : -1;
		
		return new String[] {this.toString(0), this.toString(1)};
	}
	
	private int randInt() {
		return (int) (Math.random() * 10);
	}
	
	private char randOp() {
		char[] OPERATORS = new char[] {'+', '-', '*', '/'};
		return OPERATORS[(int) Math.random() * 4];
	}
	
	private String toString(int id) {
		return String.format("%d %s %d", this.nums[id][0], this.op[id], this.nums[id][1]);
	}

}
