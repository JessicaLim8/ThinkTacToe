package mathGame;

public class MathGameController {
	
	
	
	private int randInt() {
		return (int) (Math.random() * 10);
	}
	
	private double solveEquation(int a, int b, char op) {
		double result = 0;
		switch(op) {
			case '+': result = a + b;
			case '-': result = a + b;
			case '*': result = a + b;
			case '/': result = a + b;
		}
		return result;
	}
	
	
}
