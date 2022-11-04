package BattleShip;

public class text5 {
	
	private boolean sunk; //True for sunk
	private int health; //remaining health
	private int size; //size of the ship
	private text3 square1;
	private text3 square2;
	
	
	private final static int defaultHealth = 2;
	private final static int defaultSize = 2;	
	
	public text5(boolean sunk) {
		this.sunk = sunk;
		this.health = defaultHealth;
		this.size = defaultSize;
	}
	
	public text5(boolean sunk, Integer health, Integer size) {
		this.sunk = sunk;
		this.health = health;
		this.size = size;
	}
	
	public text3[][] addSquare(text3[][] gameBord, int[] shipCoordinates,text5 battleShip) {
		this.square1 = gameBord[shipCoordinates[0]][shipCoordinates[1]];
		this.square2 = gameBord[shipCoordinates[2]][shipCoordinates[3]];
		
		square1.setShipInSquare(true);
		square2.setShipInSquare(true);
		
		return gameBord;
	}
	
	public text5 hitBattleShip(text3[][] gameBord, int[] shipCoordinates, text5 battleShip) {
		
		gameBord[shipCoordinates[0]][shipCoordinates[1]].setShipCurrentStatus(true); //sunk
		
		return battleShip;
	}
	
	public boolean hitAllShips() {
		boolean flag = false;
		text5[] b1 = new text5[5];
		for(text5 b : b1) {
			if(!b.square1.isFire()) {
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
