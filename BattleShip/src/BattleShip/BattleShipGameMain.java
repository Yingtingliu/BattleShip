package BattleShip;


public class BattleShipGameMain {
	
	//define the board
	static int row = 10;
	static int column = 10;
	final static int smallShipAmount = 3;
	final static int mediumShipAmount = 2;
	final static int largeShipAmount = 1;

	public static void main(String[] args) {		
		
		int totalShips = smallShipAmount+mediumShipAmount+largeShipAmount;
		
		Board b1 = new Board(row,column);
		Board b2 = new Board(row,column);
		
		BattleShip[] shipArray1 = new BattleShip[totalShips];
		BattleShip[] shipArray2 = new BattleShip[totalShips];
		
		Square[][] gameBoard1 = b1.gameBord(row, column,shipArray1,smallShipAmount,mediumShipAmount,largeShipAmount);
		Square[][] gameBoard2 = b2.gameBord(row, column,shipArray2,smallShipAmount,mediumShipAmount,largeShipAmount);
		
		//Create two player and take turns
		boolean turn = false;		
		Player p1 = new Player(b1, "Player1");
		Player p2 = new Player(b2, "Player2");
		while(!turn ) {			
			turn = p1.takeTurn(b1,p1, gameBoard1,shipArray1);
			if(turn) {
				System.out.println(p1.name + ",You won the battle! ");
				break;
			}
			turn = p2.takeTurn(b2, p2, gameBoard2,shipArray2);
			if(turn) {
				System.out.println(p2.name + ",You won the battle! ");
				break;
			}
		}			
		
	}

}
