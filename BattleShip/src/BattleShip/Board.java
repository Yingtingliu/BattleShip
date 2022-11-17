package BattleShip;

import java.util.Random;

public class Board {

	private int row; // 10
	private int column; // 10
	
	static int count = 0; //for counting existing ships
	
	public Board() {		
	}
	
	public Board(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	// populate the board data structure with Square objects
	public Square[][] gameBord (
			int row, int column,  BattleShip[] b1, int smallShips, int mediumShip, int largeShip){
		Square[][] gameBord = new Square[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				gameBord[i][j] = new Square(i,j,false,-1,false);
			}
		}
		return placeShips(gameBord,row,column,b1,smallShips,mediumShip,largeShip);
	}
	
	// generating battleships
	private static Square[][] placeShips(
			Square[][] gameBord,int row, int column, BattleShip[] b1, int smallShips, int mediumShip, int largeShip) {		
		
		int[] shipCoordinates = null;
		int totalShips = smallShips + mediumShip + largeShip; //6
		count = 0;
		boolean s1,s2,s3;
		for(int i=0;i<totalShips;i++) { //run 0-5, total 6 times
			
			shipCoordinates = generateShipCoordinates(row, column, smallShips, mediumShip, largeShip);	
			Square square1,square2,square3;
			switch(count) {				
			// count started at 0, count will be added after checking duplicate and then add to an battle ship.
				
				// case 0,1,2 is for generating small ships
				case 0: case 1: case 2:
					square1 = gameBord[shipCoordinates[0]][shipCoordinates[1]];
					//check if ship will be duplicate
					s1 = square1.isShipInSquare();
					if(!s1) {
						//create a small battle ship
						b1[i] = new SmallBattleship(false);
						square1.setShipInSquare(true);						
						square1.setBattleShipNumber(i);						
						count++;
					}else {
						i--;
					}					
					break;
					
				// case 3,4 is for generating medium ships
				case 3: case 4:	
					square1 = gameBord[shipCoordinates[0]][shipCoordinates[1]];
					square2 = gameBord[shipCoordinates[2]][shipCoordinates[3]];
					s1 = square1.isShipInSquare();
					s2 = square2.isShipInSquare();
					
					if(!s1 && !s2) {
						b1[i] = new MediumBattleship(false);
						square1.setShipInSquare(true);
						square2.setShipInSquare(true);
						square1.setBattleShipNumber(i);
						square2.setBattleShipNumber(i);
						count++;
					}else {
						i--;
					}					
					break;
					
				// case 5 is for generating large ships coordinator
				case 5: 
					square1 = gameBord[shipCoordinates[0]][shipCoordinates[1]];
					square2 = gameBord[shipCoordinates[2]][shipCoordinates[3]];
					square3 = gameBord[shipCoordinates[4]][shipCoordinates[5]];
					s1 = square1.isShipInSquare();
					s2 = square2.isShipInSquare();
					s3 = square3.isShipInSquare();
					
					if(!s1 && !s2 && !s3) {
						b1[i] = new LargeBattleship(false);
						square1.setShipInSquare(true);
						square2.setShipInSquare(true);
						square3.setShipInSquare(true);
						square1.setBattleShipNumber(i);
						square2.setBattleShipNumber(i);
						square3.setBattleShipNumber(i);
						count++;
					}else {
						i--;
					}					
					break;
			}//switch case ended
		}
		return gameBord;
	}


	private static int[] generateShipCoordinates(int row, int column, int smallShips, int mediumShip, int largeShip) {
		int[] coordinates = new int[(smallShips+mediumShip+largeShip)];

		//random position
		Random r = new Random();
		int randomRow = r.nextInt(10);
		int randomColumn = r.nextInt(10);		
		//random direction, if true add one column to second coordinates, if false add one to row 		
		boolean direction = r.nextBoolean();
		
		//put random numbers into the coordinates
		switch(count) {
			
			// case 0,1,2 is for generating small ships coordinator
			case 0: case 1: case 2:
				//first coordinate
				coordinates[0] = randomRow;
				coordinates[1] = randomColumn;
				break;
				
			// case 3,4 is for generating medium ships coordinator
			case 3: case 4:
				//generate medium ship coordinator
				// row and column range from 0-8
				if(randomRow<(row-1) && randomColumn<(column-1) && direction) {
					//first coordinate
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					//second coordinate
					coordinates[2] = randomRow;
					coordinates[3] = randomColumn+1;
				} else if(randomRow<(row-1) && randomColumn<(column-1) && !direction){
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					coordinates[2] = randomRow+1;
					coordinates[3] = randomColumn;
				// row or column range from 0-8
				} else if((randomRow == 9 || randomColumn == 9) && direction){
					// if random number add one will be unavailable to put in, so I deduct one
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					coordinates[2] = randomRow;
					coordinates[3] = Math.abs(randomColumn-1);
				} else if((randomRow == 9 || randomColumn == 9) && !direction){
					// if random number add one will be unavailable to put in, so I deduct one
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					coordinates[2] = Math.abs(randomRow-1);
					coordinates[3] = randomColumn;
				}
				break;
				
			// case 5 is for generating large ships coordinator
			case 5: 
				//generate medium ship coordinator
				if(randomRow<(row-2) && randomColumn<(column-2) && direction) {
					//random row and column 0-7 and add at direction column
					//first coordinate
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					//second coordinate
					coordinates[2] = randomRow;
					coordinates[3] = randomColumn+1;
					//third coordinate
					coordinates[4] = randomRow;
					coordinates[5] = randomColumn+2;
					
				} else if(randomRow<(row-2) && randomColumn<(column-2) && !direction){
					//random row and column 0-7 and add at direction row
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					coordinates[2] = randomRow+1;
					coordinates[3] = randomColumn;
					coordinates[4] = randomRow+2;
					coordinates[5] = randomColumn;
					
				} else if((randomRow>=(row-2) || randomColumn>=(column-2)) && direction){
					// if random number is 8 or 9 add one or two will be unavailable to put in, so I deduct
					//random row and column 8-9 and add at direction column
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					coordinates[2] = randomRow;
					coordinates[3] = Math.abs(randomColumn-1);
					coordinates[4] = randomRow;
					coordinates[5] = Math.abs(randomColumn-2);
					if(coordinates[5]==coordinates[1]) {
						//this means you get x,1,x,0,x,1 to make it a large ship, turn -1 to 2
						//result will be 1,x,0,x,2,x 
						coordinates[5]+=1;
					}
					
				} else if((randomRow>=(row-2) || randomColumn>=(column-2)) &&!direction){
					// if random number is 8 or 9 add one or two will be unavailable to put in, so I deduct
					//random row and column 8-9 and add at direction row
					coordinates[0] = randomRow;
					coordinates[1] = randomColumn;
					coordinates[2] = Math.abs(randomRow-1);
					coordinates[3] = randomColumn;
					coordinates[4] = Math.abs(randomRow-2);
					coordinates[5] = randomColumn;
					if(coordinates[4]==coordinates[0]) {
						//this means you get 1,x,0,x,1,x to make it a large ship, turn -1 to 2
						//result will be 1,x,0,x,2,x 
						coordinates[4]+=1;
					}					
				}
				break;
		}						
		return coordinates;
	}
	
	//print out game board
	public String toString(Board board, Square[][] gameBoard) {		
		
		System.out.println("------Game Borad Starts Here-----");
		System.out.print("  ");
		for (int i = 0; i < column; i++) {
			System.out.print(" "+ i+" ");
		}
		System.out.println();
		for (int i = 0; i < column; i++) {
			System.out.print(i+ " ");
			for (int j = 0; j < row; j++) {
				System.out.print(gameBoard[i][j].toString());				
			}
			System.out.println();
		}		
		System.out.println("------Game Borad Ends-----");
		
		return null;
	}
	
	
	
	//this is for testing	
	//print out game board view where's the ship
//	public String toStringViewShip (Board board, Square[][] gameBoard) {		
//		System.out.println("------Ship Borad Starts Here-----");
//		System.out.print("  ");
//		for (int i = 0; i < column; i++) {
//			System.out.print(" "+ i+" ");
//		}
//		System.out.println();
//		for (int i = 0; i < column; i++) {
//			System.out.print(i+ " ");
//			for (int j = 0; j < row; j++) {
//				System.out.print(gameBoard[i][j].toStringViewShip());				
//			}
//			System.out.println();
//		}
//		
//		System.out.println("------Ship Borad Ends-----");
//		
//		return null;
//	}
	
	
		
}
