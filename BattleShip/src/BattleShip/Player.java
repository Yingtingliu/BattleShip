package BattleShip;

import java.util.Scanner;

public class Player {
	private Board board;
	private String name;
	private int score;	
	
	//constructor
	public Player(Board board, String name) {
		this.board = board;
		this.name = name;		
	}
	
	public boolean takeTurn(Board board, Square[][] gameboard,BattleShip[] battleShipArray) {

		int row;
		int column;
		boolean fire;
		boolean gameOver = false;;

		//print the original board
		board.toString();
		board.toStringViewShip();	//this is for testing	

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
		
		//check if this square is fired or not
		fire = gameboard[row][column].isFire();	
		// if fire is true, return false and take turn to another player
		// if fire is false, set it fired and check if it hits a ship
		if(!fire) {
//		Each Battleship object will be checked against whenever a player fires into the board on a particular square.		
			// the square been hit, set fire as true
			gameboard[row][column].setFire(true);
			
			// hit the square, check if there's ship inside		
			if(gameboard[row][column].isShipInSquare()) {
				//if there's ship, get the battle ship number
				int battleShipNumber = gameboard[row][column].getBattleShipNumber();
				// check current health number
				int currentHealth = battleShipArray[battleShipNumber].getHealth();
				//deduct the health
				battleShipArray[battleShipNumber].setHealth(currentHealth-1);
				System.out.println("Good Job! You hit a ship!");
				
				//if the current health number is 1, deduct the number and set it as sink
				if(currentHealth==1) { 
					battleShipArray[battleShipNumber].setSunk(true);
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
			//inform the player this square has been fired
			System.out.println("This squre had been fired before!! You can't hit it!");	
		}// end if		
		
		//print the result board
		System.out.println("This is the result game board: ");
		board.toString();
		System.out.println("--------------------------------------");
		
		return gameOver;		    
	} // end of takeTurn method
	

	//getter and setter
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
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
