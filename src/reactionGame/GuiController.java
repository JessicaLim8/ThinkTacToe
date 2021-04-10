package reactionGame;
import java.util.Random;
public class GuiController {
	public void playMinigame() {
		Gui.main(null);
	}
	public static int calcRand() {
		Random rand = new Random();
		int randInt = rand.nextInt(10);
		return randInt;
	}
	public static void calcSleep() {
		try {
			long randTime = Math.round(Math.random() * 3000) + 1000;
			Thread.sleep(randTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static long calcTime(long startTime, long endTime) {
		return endTime - startTime;
	}
	public static long calcAvg(int player, int i) {
		long[] scores = GuiAbstraction.getScore(player);
		long avg = 0;
		for (int j = 0; j < i + 1; j++) {
			avg += scores[j];
		}
		return avg/(i+1);
		}
	public static int calcWinner() {
		long avg1 = calcAvg(1,2);
		long avg2 = calcAvg(2,2);
		if (avg1 > avg2) {
			return 2;
		}
		else
			return 1;
}
}

