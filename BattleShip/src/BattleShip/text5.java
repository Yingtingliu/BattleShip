package BattleShip;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class text5 {
	public static int numRows = 10;
	public static int numCols = 10;
	public static int playerShips;
	public static int computerShips;
	public static String[][] grid = new String[numRows][numCols];
	public static int[][] missedGuesses = new int[numRows][numCols];

	public static void main(String[] args) {
		System.out.println("Welcome to Amiral Batti game");
		System.out.println("\nComputer: ");
		deployComputerShips();
		System.out.println("\n");
		System.out.println("\nHuman: ");
		deployPlayerShips();

		do {
			Battle();
		} while (text5.playerShips != 0 && text5.computerShips != 0);

		gameOver();
	}

	public static int FIELD_SIZE = 10;

	public static void deployPlayerShips() {
		Random random = new Random();
		int[][] field = new int[FIELD_SIZE][FIELD_SIZE];
		for (int i = 5; i > 0; i--) {
			int x = random.nextInt(field.length);
			int y = random.nextInt(field.length);
			boolean vertical = random.nextBoolean();

			if (vertical) {
				if (y + i > FIELD_SIZE) {
					y -= i;
				}
			} else if (x + i > FIELD_SIZE) {
				x -= i;
			}
			boolean isFree = true;

			if (vertical) {
				for (int m = y; m < y + i; m++) {
					if (field[m][x] != 0) {
						isFree = false;
						break;
					}
				}
			} else {
				for (int n = x; n < x + i; n++) {
					if (field[y][n] != 0) {
						isFree = false;
						break;
					}
				}
			}
			if (!isFree) {
				i++;
				continue;
			}

			if (vertical) {
				for (int m = Math.max(0, x - 1); m < Math.min(FIELD_SIZE, x + 2); m++) {
					for (int n = Math.max(0, y - 1); n < Math.min(FIELD_SIZE, y + i + 1); n++) {
						field[n][m] = 9;
					}
				}
			} else {
				for (int m = Math.max(0, y - 1); m < Math.min(FIELD_SIZE, y + 2); m++) {
					for (int n = Math.max(0, x - 1); n < Math.min(FIELD_SIZE, x + i + 1); n++) {
						field[m][n] = 9;
					}
				}
			}

			for (int j = 0; j < i; j++) {
				field[y][x] = i;
				if (vertical) {
					y++;
				} else {
					x++;
				}
			}
		}

		System.out.print(" ");
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		char[][] map = new char[FIELD_SIZE][FIELD_SIZE];
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				map[i][j] = field[i][j] == 0 || field[i][j] == 9 ? '.' : 'o';
			}
		}

		Arrays.stream(map).forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
	}

	public static void deployComputerShips() {
		Random random = new Random();
		int[][] field = new int[FIELD_SIZE][FIELD_SIZE];
		for (int i = 5; i > 0; i--) {

			int x = random.nextInt(field.length);
			int y = random.nextInt(field.length);
			boolean vertical = random.nextBoolean();

			if (vertical) {
				if (y + i > FIELD_SIZE) {
					y -= i;
				}
			} else if (x + i > FIELD_SIZE) {
				x -= i;
			}

			boolean isFree = true;

			if (vertical) {
				for (int m = y; m < y + i; m++) {
					if (field[m][x] != 0) {
						isFree = false;
						break;
					}
				}
			} else {
				for (int n = x; n < x + i; n++) {
					if (field[y][n] != 0) {
						isFree = false;
						break;
					}
				}
			}
			if (!isFree) {
				i++;
				continue;
			}

			if (vertical) {
				for (int m = Math.max(0, x - 1); m < Math.min(FIELD_SIZE, x + 2); m++) {
					for (int n = Math.max(0, y - 1); n < Math.min(FIELD_SIZE, y + i + 1); n++) {
						field[n][m] = 9;
					}
				}
			} else {
				for (int m = Math.max(0, y - 1); m < Math.min(FIELD_SIZE, y + 2); m++) {
					for (int n = Math.max(0, x - 1); n < Math.min(FIELD_SIZE, x + i + 1); n++) {
						field[m][n] = 9;
					}
				}
			}

			for (int j = 0; j < i; j++) {
				field[y][x] = i;
				if (vertical) {
					y++;
				} else {
					x++;
				}
			}
		}

		System.out.print(" ");
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		char[][] map = new char[FIELD_SIZE][FIELD_SIZE];
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				map[i][j] = field[i][j] == 0 || field[i][j] == 9 ? '.' : 'o';
			}
		}

		Arrays.stream(map).forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
	}

	public static void Battle() {
		playerTurn();
		computerTurn();

		printBoard();

		System.out.println();
		System.out.println("Your ships: " + text5.playerShips + " | Computer ships: " + text5.computerShips);
		System.out.println();
	}

	public static void playerTurn() {
		Scanner scn = new Scanner(System.in);
		System.out.println("\nHuman's turn: ");
		int x = -1, y = -1;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter row number: ");
			x = scn.nextInt();
			System.out.print("Enter column number: ");
			y = scn.nextInt();

			if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) {
				if (grid[x][y].equals("o")) {
					System.out.println("You sunk the ship!");
					grid[x][y] = "s";
					--text5.computerShips;
				} else if (grid[x][y].equals(".")) {
					System.out.println("You missed");
					grid[x][y] = "x";
				}
			} else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
				System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
		} while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));
	}

	public static void computerTurn() {
		System.out.println("\nComputer's turn: ");

		int x = -1, y = -1;
		do {
			x = (int) (Math.random() * 10);
			y = (int) (Math.random() * 10);
			System.out.println("Enter row number: " + x);
			System.out.println("Enter column number: " + y);

			if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) {
				if (grid[x][y].equals("o")) {
					System.out.println("The Computer sunk one of your ships!");
					grid[x][y] = "s";
					--text5.playerShips;
					++text5.computerShips;
				} else if (grid[x][y].equals(".")) {
					System.out.println("Computer missed");
					grid[x][y] = "x";
					if (missedGuesses[x][y] != 1)
						missedGuesses[x][y] = 1;
				}
			}
		} while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));
	}

	public static void gameOver() {
		System.out.println("Your ships: " + text5.playerShips + " | Computer ships: " + text5.computerShips);
		if (text5.playerShips > 0 && text5.computerShips <= 0)
			System.out.println("You won the battle! ");
		else
			System.out.println("You lost the battle! ");
		System.out.println();
	}

	public static void printBoard() {

		System.out.print(" ");
		System.out.println("0123456789");

		for (int x = 0; x < grid.length; x++) {
			System.out.print(x);

			for (int y = 0; y < grid[x].length; y++) {
				System.out.print(grid[x][y]);
			}
			System.out.println();
		}
		System.out.println();
	}

}