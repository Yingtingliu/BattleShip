package BattleShip;

public class SmallBattleship extends BattleShip{
	
	private static int defaultHealth = 1;
	private static int defaultSize = 1;	
	
	public SmallBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultHealth;
		this.size = defaultSize;
	}
	
}
