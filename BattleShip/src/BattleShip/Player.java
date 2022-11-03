package BattleShip;

import java.util.Scanner;

public class Player {
	Board board;
	String name;
	int score;	
	
	//constructor
	public Player(Board board, String name) {
		this.board = board;
		this.name = name;		
	}
	
	public boolean takeTurn(Player player, Square[][] gameboard) {
		String temp, firstWord, secondWord;
		System.out.println("Please enter the position x y from 0-9, eg: 0 1");
		Scanner in = new Scanner(System.in);
		//printout player's input 
		temp = in.nextLine();
		System.out.println(temp);
		
		in = new Scanner(temp); // make it a scanner
		firstWord = in.next(); 
		secondWord = in.next();
		int row = Integer.valueOf(firstWord);
		int column = Integer.valueOf(secondWord);		
		
		// hit the square		
		if(gameboard[row][column].isFire()) {
			//if there's ship
			gameboard[row][column].setShipCurrentStatus(true);
			gameboard[row][column].setFire(true);
		} else {
			//there's no ship
			gameboard[row][column].setFire(true);
		}		
		
		if(firstWord=="1") {
			
			return false;
		}else {
			//fired all the ships
			return true;
		}
		
		
		
				
	}
	

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
