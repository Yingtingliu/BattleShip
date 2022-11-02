package BattleField;

import java.util.Arrays;
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
	
	public Square[][] gameBord (int row, int column){
		Square[][] gameBord = new Square[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				gameBord[i][j] = new Square(i,j,false,false,false);
			}
		}
		return placeShips(gameBord,row,column);
	}

	private static Square[][] placeShips(Square[][] gameBord,int row, int column) {
				
		for(int i=0;i<shipAmount;i++) {
			int[] ship = generateShipCoordinates(row,column);
			boolean s1 = gameBord[ship[0]][ship[1]].isShipInSquare();
			boolean s2 = gameBord[ship[2]][ship[3]].isShipInSquare();
			
			if(s1||s2) {
				i--;
			}else {
				gameBord[ship[0]][ship[1]].setShipInSquare(true);
				gameBord[ship[2]][ship[3]].setShipInSquare(true);
			}
			
		}

		return gameBord;
	}
	
	private static int[] generateShipCoordinates(int row, int column) {
		int[] cooridnates = new int[4];

		//random position
		Random r = new Random();
		int randomRow = r.nextInt(10);
		int randomColumn = r.nextInt(10);		
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
		
}
