package BattleShip;


public class text1 {

	public static void main(String[] args) {	
		
		int row = 10;
		int column = 10;
		text2 b1 = new text2(row,column);
		b1.toString(b1);
		
		text4 b2 = new text4(null, null);
		b2.takeTurn(b2, null);
	}

}
