package BattleShip;

public class MediumBattleship extends BattleShip{
	
	private int defaultSize = 2;	
	
	public MediumBattleship(boolean sunk) {
		super(sunk);
		this.health = defaultSize;
		this.size = defaultSize;
	}
	
}
