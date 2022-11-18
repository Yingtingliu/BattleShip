package BattleShip;

public class LargeBattleship extends BattleShip{
	
	private static int defaultSize = 3;
	
//	you are to specify a static attribute for each sub class. 
//	This attribute should specify the total number of permissible ships of that class on the board.
	static int permissibleShips = 1;
	
	public LargeBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
