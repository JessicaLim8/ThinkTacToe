package reactionMinigame;

public class GuiAbstraction {
	static long[] player1score = new long[6];
	static long[] player2score = new long[6];
	public static void setScore(int player, int i, long clickTime) {
		if (player == 1) {
			player1score[i] = clickTime;
		}
		else{
			player2score[i] = clickTime;
		}
	}
	public static long[] getScore(int player) {
		if (player == 1) {
			return player1score;
		}
		else{
			return player2score;
		}
	}
}
