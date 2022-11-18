package BattleShip;

import java.util.Scanner;

public class PlayerOld {
	BoardOld board;
	String name;
	int score;	
	
	//constructor
	public PlayerOld(BoardOld b1, String name) {
		this.board = b1;
		this.name = name;		
	}
	
	public boolean takeTurn(BoardOld board,PlayerOld player, Square[][] gameboard,BattleShip[] battleShipArray) {
		
		int row;
		int column;
		boolean fire;
		boolean gameOver = false;

		//print the original board
		board.toString();
//		board.toStringViewShip();	//this is for testing	

		//Use scanner to get player's input
		String temp, firstWord, secondWord;
		// the users should be prompted for their names and have this be used as input to the constructors. 
		System.out.println("Hi " + this.name + ", please enter the position x y from 0-9, eg: 0 1");
		Scanner in = new Scanner(System.in);
		temp = in.nextLine();
		in = new Scanner(temp);
		//extract input to two words
		firstWord = in.next(); 
		secondWord = in.next();
		//row and column from user
		row = Integer.valueOf(firstWord); 
		column = Integer.valueOf(secondWord); 
		
		
		//check for areas that have already been fired at		
		fire = gameboard[row][column].isFire();	
		
		// if fire is true, return false and take turn to another player
		// if fire is false, set it fired and check if it hits a ship
		if(!fire) {
//		Each Battleship object will be checked against whenever a player fires into the board on a particular square.		
			
			// the square been hit, set fire as true
			gameboard[row][column].setFire(true);
			
			// hit the square, check if there's ship inside	
			BattleShip battleShip = gameboard[row][column].getBattleShip();
			
			// cannot hit the ship in the same square twice and have it count
			if(battleShip != null) {				
				// check current health number
				int currentHealth = battleShip.getHealth();
				//deduct the health
				battleShip.setHealth(currentHealth-1);
				System.out.println("Good Job! You hit a ship!");
				
				//if the current health number is 1, deduct the number and set it as sink
				if(currentHealth==1) { 
					battleShip.setSunk(true);
					score = score+1;
					System.out.println("This ship also sink! Great work!");
				} 			
			} else {
				System.out.println("Sorry, you fired and missed!!");
			}
			
			// check if the game is over, by checking if all the ship is sunk 
			// if game over return true			
			if(battleShipArray.length == score) {
				gameOver = true;
			}
			
		} else{
			//if fire is true, which means it has been fired before.
			//In the event the player enters coordinates that have been checked prior, they will lose their turn.
			System.out.println("This squre had been fired before!! You can't hit it!");	
		}// end if		
		
		//print the result board
		System.out.println("This is the result game board: ");
		board.toString();
		System.out.println("--------------------------------------");
		
		return gameOver;		    
	} // end of takeTurn method
		
//		//print the board
//		board.toString(board,gameboard);
//		board.toStringViewShip(board,gameboard);		
//		
//		//Use scanner to get player's input
//		String temp, firstWord, secondWord;
//		System.out.println("Hi " + player.name + ", please enter the position x y from 0-9, eg: 0 1");
//		Scanner in = new Scanner(System.in);
//		temp = in.nextLine();
//		in = new Scanner(temp);
//		//extract input to two words
//		firstWord = in.next(); 
//		secondWord = in.next();
//		int row = Integer.valueOf(firstWord);
//		int column = Integer.valueOf(secondWord);		
//		
//		// hit the square		
//		if(gameboard[row][column].isShipInSquare()) {
//			//if there's ship, get the battle ship number
//			int battleShipNumber = gameboard[row][column].getBattleShipNumber();
//			// check current health number
//			int currentHealth = battleShipArray[battleShipNumber].getHealth();
//			battleShipArray[battleShipNumber].setHealth(currentHealth-1);
//			//if the current health number is 1, deduct the number and set it as sink
//			if(currentHealth==1) { 
//				battleShipArray[battleShipNumber].setSunk(true);
//			} 			
//		} 
//		gameboard[row][column].setFire(true);
//		
//		for(BattleShip b : battleShipArray) if(!b.isSunk()) return false;
//	    return true;
//	}
	
	
	

	//getter and setter
	public BoardOld getBoard() {
		return board;
	}
	public void setBoard(BoardOld board) {
		this.board = board;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
