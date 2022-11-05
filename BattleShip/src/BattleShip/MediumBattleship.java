package BattleShip;

public class MediumBattleship extends BattleShip{
	
	private static int defaultHealth = 3;
	private static int defaultSize = 3;	
	
	public MediumBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultHealth;
		this.size = defaultSize;
	}
	
}
