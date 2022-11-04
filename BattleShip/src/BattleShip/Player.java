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
	
	public boolean takeTurn(Board board,Player player, Square[][] gameboard) {
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
		
		if(!hitAllShips()) {			
			return false;
		}else {
			//fired all the ships
			return true;
		}	
				
	}
	
	public boolean hitAllShips() {
		
		
		
		if() {
			
		}
		return false;
		
	}
	
	public void gameOver(Player p1, Player p2) {
		System.out.println("Your ships: " + p1.name + " | Computer ships: " + p2.name);
		if (p1.hitAllShips()) {
			System.out.println(p1.name + ",You won the battle! ");
			System.out.println(p2.name+",You lost the battle! ");
		}
		else if(p2.hitAllShips()) {
			System.out.println(p2.name + ",You won the battle! ");
			System.out.println(p1.name+",You lost the battle! ");
		}			
		System.out.println();
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
