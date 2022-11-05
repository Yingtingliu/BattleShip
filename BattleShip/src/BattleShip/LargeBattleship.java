package BattleShip;

public class LargeBattleship extends BattleShip{
	
	private static int defaultHealth = 1;
	private static int defaultSize = 1;	
	
	public LargeBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultHealth;
		this.size = defaultSize;
	}
	
}
