package BattleShip;


public class BattleShipGameMain {

	public static void main(String[] args) {	
		
		//define the board
		int row = 10;
		int column = 10;
		Board b1 = new Board(row,column);
		Board b2 = new Board(row,column);
		Square[][] gameBoard1 = b1.gameBord(row, column);
		Square[][] gameBoard2 = b2.gameBord(row, column);
		
		//Create two player and take turns
		boolean turn = false;		
		Player p1 = new Player(b1, "Player1");
		Player p2 = new Player(b2, "Player2");
		while(!turn ) {			
			turn = p1.takeTurn(b1,p1, gameBoard1);
			if(turn) {break;}
			turn = p2.takeTurn(b2, p2, gameBoard2);
		}		
		p1.gameOver(p1,p2);
		
	}

}
