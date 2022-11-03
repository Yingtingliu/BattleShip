package BattleShip;

import java.util.Scanner;

public class Player {
	Board board;
	String name;
	Integer score;	
	
	//constructor
	public Player(Board board, String name) {
		this.board = board;
		this.name = name;		
	}
	
	public boolean takeTurn(Player player, Board board) {
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
