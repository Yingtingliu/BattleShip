package BattleField;

public class text1 {

	public static void main(String[] args) {
		
		String[][] player = text3.drawBoard(10, 10);
		String[][] computer = text3.drawBoard(10, 10);
		String[][] playerControl = text3.controlBoard(10, 10);
		String[][] computerControl = text3.controlBoard(10, 10);

		while (text2.process()) {
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

			int[] playerChange = text2.attack(computer, playerControl);
			playerControl = text3.changeBoard("player", playerControl, playerChange);
			computer = text3.changeBoard("player", computer, playerChange);

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

			int[] computerChange = text2.attack2(player, computerControl);
			computerControl = text3.changeBoard("computer", computerControl, computerChange);
			player = text3.changeBoard("computer", player, computerChange);
			System.out.println(
					"--------------------------------------------叫我分隔線--------------------------------------------");
			System.out.println();
			text2.process();
		}
	}

}