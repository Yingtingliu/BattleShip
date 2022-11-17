package BattleShip;


public class BattleShipGameMain {
	
	//define the board
	static int row = 10;
	static int column = 10;
	//define the ships
	final static int smallShipAmount = 3;
	final static int mediumShipAmount = 2;
	final static int largeShipAmount = 1;

	public static void main(String[] args) {		
		
		int totalShips = smallShipAmount+mediumShipAmount+largeShipAmount;
		
		Board b1 = new Board(row,column);
		Board b2 = new Board(row,column);
		
		BattleShip[] shipArray1 = new BattleShip[totalShips];
		BattleShip[] shipArray2 = new BattleShip[totalShips];
		
		Square[][] gameBoard1 = b1.placeGameBord(row, column,shipArray1,smallShipAmount,mediumShipAmount,largeShipAmount);
		Square[][] gameBoard2 = b2.placeGameBord(row, column,shipArray2,smallShipAmount,mediumShipAmount,largeShipAmount);
		
		//Create two player and take turns
		boolean turn = false;		
		Player player1 = new Player(b1, "Player1 - Micky");
		Player player2 = new Player(b2, "Player2 - Orange");
		
		// take turns until turn== true and the game ends
		while(!turn ) {			
			turn = player1.takeTurn(b1,player1, gameBoard1,shipArray1);
			if(turn) { //player 1 win 
				System.out.println(player1.getName() + ", You won the battle! ");
				break;
			}
			turn = player2.takeTurn(b2, player2, gameBoard2,shipArray2);
			if(turn) {//player 2 win 
				System.out.println(player2.getName() + ", You won the battle! ");
				break;
			}
		}			
		
	}

}
