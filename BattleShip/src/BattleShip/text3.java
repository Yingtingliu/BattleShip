package BattleField;

public class text3 {
	
	public static String[][] drawBoard(int width, int height) {
		String[][] board = new String[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = "_";
			}
		}
		// 畫戰艦
		int finishBattleship = 1;
		while (finishBattleship > 0) {
			for (int q = 0; q < 5; q++) {
				int col = (int) (Math.random() * width);
				int row = (int) (Math.random() * height);
				board[col][row] = "B";
			}
			finishBattleship--;
		}
		return board;
	}
	
	public static String[][] controlBoard(int width, int height) {
		String[][] board = new String[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = "_";
			}
		}
		return board;
	}
	
	public static String[][] changeBoard(String side, String[][] board, int[] change) {
		if (change[0] == 1) {
			board[change[2]][change[1]] = "*";
			return board;
		} else {
			board[change[2]][change[1]] = "0";
			return board;
		}
	}

	public static int number(int[] change) {
		return change[3];
	}

}