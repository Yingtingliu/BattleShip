package BattleShip;

public class LargeBattleship extends BattleShip{
	
	private int defaultSize = 3;	
	
	public LargeBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
