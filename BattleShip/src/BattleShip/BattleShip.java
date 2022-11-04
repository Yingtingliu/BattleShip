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

	public boolean hitAllShips(BattleShip[] b1) {
		boolean flag = false;
//		b1 = new BattleShip[5];
		for(BattleShip b : b1) {
			if(!b.sunk) {
				flag = true;
			}
		}
		return flag;
		
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