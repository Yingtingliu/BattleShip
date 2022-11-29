package BattleShip;

public class SmallBattleship extends BattleShip{
	
	private static int defaultSize = 1;
	
//	you are to specify a static attribute for each sub class. 
//	This attribute should specify the total number of permissible ships of that class on the board.	
	static int permissibleShips = 3;
	
	public SmallBattleship(boolean sunk) {
		// specify to the super class constructor
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
