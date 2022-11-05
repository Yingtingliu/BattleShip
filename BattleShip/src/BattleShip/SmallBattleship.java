package BattleShip;

public class SmallBattleship extends BattleShip{
	
	private int defaultSize = 1;	
	
	public SmallBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
