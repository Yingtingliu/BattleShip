package BattleShip;

public class SmallBattleship extends BattleShip{
	
	private int defaultSize = 1;
	int permissibleShips = 3;
	
	public SmallBattleship(boolean sunk) {
		// specify to the super class constructor
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
