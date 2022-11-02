package BattleField;


public class BattleShipGameMain {

	public static void main(String[] args) {	
		
//		Square s1 = new Square(0,0,true,true,true);
//		System.out.println(s1.toString());
		int row = 10;
		int column = 10;
		Board b1 = new Board();
		Square[][] b2 =b1.gameBord(row,column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				
				b2[i][j].toString();
			}
		}
		
	}

}
