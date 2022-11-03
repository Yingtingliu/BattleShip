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
		Scanner in = new Scanner(System.in);
		//printout player's input 
		temp = in.nextLine();
		System.out.println(temp);
		
		in = new Scanner(temp); // make it a scanner
		firstWord = in.next(); // get the first word
		secondWord = in.next();
		int row = Integer.valueOf(firstWord);
		int column = Integer.valueOf(secondWord);
		
		gameboard[row][column].setShipCurrentStatus(true);
		
		
		
		return false;		
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
