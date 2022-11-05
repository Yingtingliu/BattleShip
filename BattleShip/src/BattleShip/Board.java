package BattleShip;

import java.util.Random;

public class Board {
	private String board;
	private int row;
	private int column;
	private final static int shipAmount = 5;
	
	
	public Board() {		
	}
	
	public Board(Integer row, Integer column) {
		this.row = row;
		this.column = column;
	}
	
	public Square[][] gameBord (int row, int column,  BattleShip[] b1){
		Square[][] gameBord = new Square[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				gameBord[i][j] = new Square(i,j,false,-1,false);
			}
		}
		return placeShips(gameBord,row,column,b1);
	}

	private static Square[][] placeShips(Square[][] gameBord,int row, int column, BattleShip[] b1) {		
		
		int[] shipCoordinates = null;
		for(int i=0;i<shipAmount;i++) {
			shipCoordinates = generateShipCoordinates(row,column);
			Square square1 = gameBord[shipCoordinates[0]][shipCoordinates[1]];
			Square square2 = gameBord[shipCoordinates[2]][shipCoordinates[3]];
			boolean s1 = square1.isShipInSquare();
			boolean s2 = square2.isShipInSquare();
			
			if(!s1 && !s2) {
				b1[i] = new BattleShip(false);
				square1.setShipInSquare(true);
				square2.setShipInSquare(true);
				square1.setBattleShipNumber(i);
				square2.setBattleShipNumber(i);
			}else {
				i--;
			}
		}
		return gameBord;
	}


	private static int[] generateShipCoordinates(int row, int column) {
		int[] coordinates = new int[4];

		//random position
		Random r = new Random();
		int randomRow = r.nextInt(10);
		int randomColumn = r.nextInt(10);		
		//ramdom direction		
		boolean direction = r.nextBoolean();
		
		//put random numbers into the coordinates
		if(randomRow<(row-1) && randomColumn<(column-1) && direction) {
			coordinates[0] = randomRow;
			coordinates[1] = randomColumn;
			coordinates[2] = randomRow;
			coordinates[3] = randomColumn+1;
		} else if(randomRow<(row-1) && randomColumn<(column-1) && !direction){
			coordinates[0] = randomRow;
			coordinates[1] = randomColumn;
			coordinates[2] = randomRow+1;
			coordinates[3] = randomColumn;
		} else if(randomRow == 9 || randomColumn == 9 && direction){
			// if random number add one will be unavailable to put in, so I deduct one
			coordinates[0] = randomRow;
			coordinates[1] = randomColumn;
			coordinates[2] = randomRow;
			coordinates[3] = randomColumn-1;
		} else if(randomRow == 9 || randomColumn == 9 && !direction){
			// if random number add one will be unavailable to put in, so I deduct one
			coordinates[0] = randomRow;
			coordinates[1] = randomColumn;
			coordinates[2] = randomRow-1;
			coordinates[3] = randomColumn;
		}						
		return coordinates;
	}
	

	public String toString(Board board, Square[][] gameBoard) {		
		
		System.out.println("------Game Borad Starts Here-----");
//		Square[][] b2 = board.gameBord(row,column);
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(gameBoard[i][j].toString());				
			}
			System.out.println();
		}		
		System.out.println("------Game Borad Ends-----");
		
		return null;
	}
	
	public String toStringViewShip (Board board, Square[][] gameBoard) {		
		System.out.println("------Ship Borad Starts Here-----");
//		Square[][] b2 = board.gameBord(row,column);
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(gameBoard[i][j].toStringViewShip());				
			}
			System.out.println();
		}
		
		System.out.println("------Ship Borad Ends-----");
		
		return null;
	}
	
	
		
}
