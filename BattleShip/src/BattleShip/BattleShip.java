package BattleShip;

public class BattleShip {
	
	private boolean sunk; //True for sunk
	protected int health; //remaining health
	protected int size; //size of the ship
	
	private int defaultBattleShip = 2;	
	
	public BattleShip(boolean sunk) {
		this.sunk = sunk;
		this.health = defaultBattleShip;
		this.size = defaultBattleShip;
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