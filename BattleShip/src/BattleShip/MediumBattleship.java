package BattleShip;

public class MediumBattleship extends BattleShip{
	
	private static int defaultSize = 2;
	
//	you are to specify a static attribute for each sub class. 
//	This attribute should specify the total number of permissible ships of that class on the board.
	static int permissibleShips = 2;
	
	public MediumBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
