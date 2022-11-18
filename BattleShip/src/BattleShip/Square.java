package BattleShip;

public class Square {
	
	private int row;
	private int column;
	
	private boolean shipInSquare; 
	// true: this square has a ship
	// default false
	
	// A reference to a battleship if one is currently on the Square
	private BattleShip battleShip;
	/*		A Square object can have a battleship associated with it
	 *		and this information should be used to inform the toString
	 *		method in the Square class 
	 */	
	
	private boolean fire; 
	// true: this square has been fired 
	// default false	

	private int battleShipNumber; 
	// number of the battle ship
	// default -1

	public Square(int row, int column, boolean shipInSquare, int battleShipNumber, boolean fire) {
		super();
		this.row = row;
		this.column = column;
		this.shipInSquare = shipInSquare;
		this.battleShipNumber = battleShipNumber;
		this.fire = fire;
	}

	//getter and setter
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public boolean isShipInSquare() {
		return shipInSquare;
	}
	public void setShipInSquare(boolean shipInSquare) {
		this.shipInSquare = shipInSquare;
	}
	public int getBattleShipNumber() {
		return battleShipNumber;
	}
	public void setBattleShipNumber(int battleShipNumber) {
		this.battleShipNumber = battleShipNumber;
	}

	public boolean isFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire = fire;
	}


	@Override
	public String toString() {
		
/*		A Square object can have a battleship associated with it
 *		and this information should be used to inform the toString
 *		method in the Square class 
 */
		if(fire && battleShipNumber!=-1) {
			//hit a ship
			String hitAShip = "x";			
			return String.format("%-3s",hitAShip);
//		} else if(fire && battleShipNumber==-1){
		} else if(fire && battleShip == null){
			//fired and missed
			String emptyCell = "o";			
			return String.format("%-3s",emptyCell);
		} else {
			String notFired = "-";			
			return String.format("%-3s",notFired);
		}		
		
	}
	
	public String toStringViewShip() {
		
		if(shipInSquare) {
			return " S ";
		} else {
			return " - ";
		}		
		
	}

}
