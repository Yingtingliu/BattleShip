package BattleShip;

import java.util.Random;

public class text2 {
	private String board;
	private int row;
	private int column;
	
	private final static int shipAmount = 5;
	
	public text2() {		
	}
	
	public text2(Integer row, Integer column) {
		this.row = row;
		this.column = column;
	}
	
	public text3[][] gameBord (int row, int column){
		text3[][] gameBord = new text3[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				gameBord[i][j] = new text3(i,j,false,false,false);
			}
		}
		return placeShips(gameBord,row,column);
	}

	private static text3[][] placeShips(text3[][] gameBord,int row, int column) {
		
		text5[] b1 = new text5[shipAmount];
		int[] shipCoordinates = null;
		for(int i=0;i<shipAmount;i++) {
			shipCoordinates = generateShipCoordinates(row,column);
			boolean s1 = gameBord[shipCoordinates[0]][shipCoordinates[1]].isShipInSquare();
			boolean s2 = gameBord[shipCoordinates[2]][shipCoordinates[3]].isShipInSquare();
			
			if(!s1 && !s2) {
				b1[i] = new text5(false);
				gameBord = b1[i].addSquare(gameBord, shipCoordinates,b1[i]);
			}else {
				i--;
			}
//			gameBord[0][0].setShipInSquare(false);
		}
		return gameBord;
	}


	private static int[] generateShipCoordinates(int row, int column) {
		int[] cooridnates = new int[4];

		//random position
		Random r = new Random();
		int randomRow = r.nextInt(9);
		int randomColumn = r.nextInt(9);		
		//ramdom direction		
		boolean direction = r.nextBoolean();
		
		if(randomRow<(row-1) && randomColumn<(column-1) && direction) {
			cooridnates[0] = randomRow;
			cooridnates[1] = randomColumn;
			cooridnates[2] = randomRow;
			cooridnates[3] = randomColumn+1;
		} else if(randomRow<(row-1) && randomColumn<(column-1) && !direction){
			cooridnates[0] = randomRow;
			cooridnates[1] = randomColumn;
			cooridnates[2] = randomRow+1;
			cooridnates[3] = randomColumn;
		}		
		return cooridnates;
	}
	
//	public void attack( Board board, int row, int column) {
//		
//		board[row][column].setShipCurrentStatus(true);
//	}
	


	public String toString(text2 board, text3[][] gameBoard) {		
		
		System.out.println("------Game Borad Starts Here-----");
		text3[][] b2 = board.gameBord(row,column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(b2[i][j].toString());				
			}
			System.out.println();
		}
		
		System.out.println("------Game Borad Ends-----");
		
		return null;
	}
	
	public String toStringViewShip (text2 board, text3[][] gameBoard) {		
		System.out.println("------Ship Borad Starts Here-----");
		text3[][] b2 = board.gameBord(row,column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(b2[i][j].toStringViewShip());				
			}
			System.out.println();
		}
		
		System.out.println("------Ship Borad Ends-----");
		
		return null;
	}
	
	
		
}
