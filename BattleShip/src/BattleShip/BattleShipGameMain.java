package BattleShip;


public class BattleShipGameMain {

	public static void main(String[] args) {	
		
		int row = 10;
		int column = 10;
		Board b1 = new Board(row,column);
		Board b2 = new Board(row,column);
		Square[][] gameBoard1 = b1.gameBord(row, column);
		b1.toString(b1,gameBoard1);
		b1.toStringViewShip(b1,gameBoard1);
//		b2.toString(b2);
//		b2.toStringViewShip(b2)	;
		
		boolean turn = false;		
		Player p1 = new Player(b1, "Player1");
		Player p2 = new Player(b2, "Player2");
		while(!turn ) {			
			turn = p1.takeTurn(p1, gameBoard1);
			if(turn) {break;}
			turn = p2.takeTurn(p2, null);
		}
		
		p1.gameOver(p1,p2);
	}

}
