package BattleShip;

public class BattleShip {
	
	private boolean sunk; //True for sunk
	protected int health; //remaining health
	protected int size; //size of the ship
	
	
	private static int defaultHealth = 2;
	private static int defaultSize = 2;	
	
	public BattleShip(boolean sunk) {
		this.sunk = sunk;
		this.health = defaultHealth;
		this.size = defaultSize;
	}
	
	//getter and setter
	public boolean isSunk() {
		return sunk;
	}

	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}	

}