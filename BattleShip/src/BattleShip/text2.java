package BattleField;

import java.util.Scanner;

public class text2 {
	
	public static int pB = 5;
	public static int cB = 5;
	
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
	


	
	
}