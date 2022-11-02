package BattleField;

import java.util.Scanner;

public class text4 {

	public static int pB = 10;
	public static int cB = 10;

	public static String[][] drawBoard(int width, int height) {
		String[][] board = new String[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = "_";
			}
		}
		// 畫戰艦
		int finishBattleship = 5;
		while (finishBattleship > 0) {
			int col = (int) (Math.random() * width);
			int row = (int) (Math.random() * height);
			int x = (int) (Math.random() * 2);
			int y = (int) (Math.random() * 2);
			if ((x == 0 && y == 1) || (x == 1 && y == 0)) {
				if (board[col][row] != "B" && col < 9 && row < 9 && board[col + x][row + y] != "B") {
					board[col][row] = "B";
					board[col + x][row + y] = "B";
					finishBattleship--;
				}
			}
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

	public static int[] attack(String[][] computer, String[][] control) {
		boolean attack = false;
		Scanner input = new Scanner(System.in);
		while (!attack) {
			System.out.println();
			System.out.println("大胖豬1號請選擇投擲炸彈的那一排(1-10)");
			int row = input.nextInt();
			System.out.println("大胖豬1號請選擇投擲炸彈的列(1-10)");
			int col = input.nextInt();
			int[] result = new int[3];
			result[1] = row - 1;
			result[2] = col - 1;

			if (row >= 1 && row <= 10 && col >= 1 && col <= 10 && control[col - 1][row - 1] == "_") {
				if (computer[col - 1][row - 1] == "B") {
					System.out.println("你摧毀了大胖豬2號的戰艦！");
					result[0] = 1;
					cB--;
					return result; // 1 代表戰艦
				} else {
					System.out.println("你什麼都沒打中");
					result[0] = -1;
					System.out.println();
					return result; // -1 你什麼都沒打中
				}
			} else {
				System.out.println("未定義位置");
			}
		}
		return null;
	}

	public static int[] attack2(String[][] computer, String[][] control) {
		boolean attack = false;
		Scanner input = new Scanner(System.in);
		while (!attack) {
			System.out.println();
			System.out.println("大胖豬2號請選擇投擲炸彈的那一排(1-10)");
			int row = input.nextInt();
			System.out.println("大胖豬2號請選擇投擲炸彈的列(1-10)");
			int col = input.nextInt();
			int[] result = new int[3];
			result[1] = row - 1;
			result[2] = col - 1;

			if (row >= 1 && row <= 10 && col >= 1 && col <= 10 && control[col - 1][row - 1] == "_") {
				if (computer[col - 1][row - 1] == "B") {
					System.out.println("你摧毀了大胖豬1號的戰艦！");
					result[0] = 1;
					cB--;
					return result; // 1 代表戰艦
				} else {
					System.out.println("你什麼都沒打中");
					result[0] = -1;
					System.out.println();
					return result; // -1 你什麼都沒打中
				}
			} else {
				System.out.println("未定義位置");
			}
		}
		return null;
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

	public static boolean process() {
		if (cB <= 0) {
			System.out.println("大胖豬1號 贏了！");
			return false;
		} else if (pB <= 0) {
			System.out.println("大胖豬2號 贏了！");
			return false;
		} else {
			if (cB == 0) {
				System.out.println("你摧毀了大胖豬2號的戰艦！");
				cB--;
			}
			if (pB == 0) {
				System.out.println("你摧毀了大胖豬1號的戰艦！");
				pB--;
			}
			return true;
		}
	}

	public static void main(String[] args) {

		String[][] player = drawBoard(10, 10);
		String[][] computer = drawBoard(10, 10);
		String[][] playerControl = controlBoard(10, 10);
		String[][] computerControl = controlBoard(10, 10);

		while (process()) {
			System.out.println("大胖豬1號的戰艦圖");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(player[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
			System.out.println("大胖豬1號猜大胖豬2號圖");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(playerControl[i][j] + " ");
				}
				System.out.println();
			}

			int[] playerChange = attack(computer, playerControl);
			playerControl = changeBoard("player", playerControl, playerChange);
			computer = changeBoard("player", computer, playerChange);

			System.out.println();
			System.out.println(
					"--------------------------------------------叫我分隔線--------------------------------------------");
			System.out.println();
			System.out.println("大胖豬2號的戰艦圖");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(computer[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
			System.out.println("大胖豬2號猜大胖豬1號圖");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(computerControl[i][j] + " ");
				}
				System.out.println();
			}

			int[] computerChange = attack2(player, computerControl);
			computerControl = changeBoard("computer", computerControl, computerChange);
			player = changeBoard("computer", player, computerChange);
			System.out.println(
					"--------------------------------------------叫我分隔線--------------------------------------------");
			System.out.println();
			process();
		}
	}

}