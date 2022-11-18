package BattleShip;

import java.util.Scanner;

public class BattleShipGameMain {
	
	//define the board
	static int row = 10;
	static int column = 10;

	public static void main(String[] args) {		
		
		int smallShipAmount = new SmallBattleship(false).permissibleShips;
		int mediumShipAmount = new MediumBattleship(false).permissibleShips;
		int largeShipAmount = new LargeBattleship(false).permissibleShips;
		
		int totalShips = smallShipAmount+mediumShipAmount+largeShipAmount;
		
		Board b1 = new Board(row,column);
		Board b2 = new Board(row,column);
		
		BattleShip[] shipArray1 = new BattleShip[totalShips];
		BattleShip[] shipArray2 = new BattleShip[totalShips];
		
		Square[][] gameBoard1 = b1.placeGameBord(row, column,shipArray1,smallShipAmount,mediumShipAmount,largeShipAmount);
		Square[][] gameBoard2 = b2.placeGameBord(row, column,shipArray2,smallShipAmount,mediumShipAmount,largeShipAmount);
		
		//Create two player and take turns
		boolean turn = false;
		System.out.println("Welcome player one, please enter your name: ");
		Scanner in = new Scanner(System.in);
		String name1 = in.nextLine();
		System.out.println("Welcome player two, please enter your name: ");
		String name2 = in.nextLine();
		Player player1 = new Player(b1, name1);
		Player player2 = new Player(b2, name2);
		
		// take turns until turn== true and the game ends
		while(!turn ) {			
			turn = player1.takeTurn(b1, gameBoard1, shipArray1);
			int pOneScore;
			int pTwoScore;
			if(turn) { // player 1 win 
				pOneScore = player1.getScore();
				pTwoScore = player2.getScore();
				if(pOneScore>pTwoScore) {
					System.out.println(player1.getName() + ", You won the battle! " + "Score of You:Rival is: "+ pOneScore+":"+pTwoScore);
				} else if(pOneScore==pTwoScore){
					System.out.println("It's a draw.");
				}				
				break;
			}
			
			turn = player2.takeTurn(b2, gameBoard2, shipArray2);
			if(turn) { // player 2 win 
				pOneScore = player1.getScore();
				pTwoScore = player2.getScore();
				if(pOneScore<pTwoScore) {
					System.out.println(player2.getName() + ", You won the battle! " + "Score of You:Rival is: "+ pTwoScore+":"+pOneScore);
				} else if(pOneScore==pTwoScore){
					System.out.println("It's a draw.");
				}					
				break;
			}
		}			
		
	}

}
