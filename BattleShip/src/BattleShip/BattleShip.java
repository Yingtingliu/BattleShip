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
	
	public Square[][] addSquare(Square[][] gameBord, int[] shipCoordinates,BattleShip battleShip) {
		
		gameBord[shipCoordinates[0]][shipCoordinates[1]].setShipInSquare(true);
		gameBord[shipCoordinates[2]][shipCoordinates[3]].setShipInSquare(true);
		
		return gameBord;
	}
	
	public BattleShip hitBattleShip(Square[][] gameBord, int[] shipCoordinates, BattleShip battleShip) {
		
		gameBord[shipCoordinates[0]][shipCoordinates[1]].setShipCurrentStatus(true); //sunk
		
		return battleShip;
	}
	
	
	
	
	
//	Square[] s1 = new Square[2];

}
