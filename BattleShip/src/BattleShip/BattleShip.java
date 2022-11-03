package BattleShip;

public class BattleShip {
	
	private boolean sunk; //True for sunk
	private int health; //remaining health
	private int size; //size of the ship
	
	private final static int defaultHealth = 2;
	private final static int defaultSize = 2;
	
	
	public BattleShip(boolean sunk) {
		this.sunk = sunk;
		this.health = defaultHealth;
		this.size = defaultSize;
	}
	
	public BattleShip(boolean sunk, Integer health, Integer size) {
		this.sunk = sunk;
		this.health = health;
		this.size = size;
	}
	
	public Square[][] addBattleShip(Square[][] gameBord, int row1 ,int column1, int row2, int column2) {
		
		gameBord[row1][column1].setShipInSquare(true);
		gameBord[row2][column2].setShipInSquare(true);
		
		return gameBord;
	}
	
	
	
	
	
//	Square[] s1 = new Square[2];

}
