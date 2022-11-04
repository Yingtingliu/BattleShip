package BattleShip;


public class text1 {

	public static void main(String[] args) {	
		
		int row = 10;
		int column = 10;
		text2 b1 = new text2(row,column);
		text2 b2 = new text2(row,column);
		text3[][] gameBoard1 = b1.gameBord(row, column);
		b1.toString(b1,gameBoard1);
		b1.toStringViewShip(b1,gameBoard1);
//		b2.toString(b2);
//		b2.toStringViewShip(b2)	;
		
		boolean turn = false;		
		text4 p1 = new text4(b1, "Player1");
		text4 p2 = new text4(b2, "Player2");
		while(!turn ) {			
			turn = p1.takeTurn(b1,p1, gameBoard1);
			if(turn) {break;}
			turn = p2.takeTurn(b2, p2, null);
		}		
		p1.gameOver(p1,p2);
	}

}
