package BattleField;

public class Player {
	Board board;
	String name;
	Integer score;	
	
	//constructor
	public Player(Board board, String name) {
		super();
		this.board = board;
		this.name = name;		
	}
	
	public boolean takeTurn() {
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
