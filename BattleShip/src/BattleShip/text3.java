package BattleShip;

public class text3 {
	
	private int row;
	private int column;
	
	private boolean shipInSquare; 
	// true: this square has a ship
	// default false
	
	private boolean shipCurrentStatus; 
	// true: battle ship hitted
	// default false
	
	private boolean fire; 
	//true: this square has been fired 
	// default false
	
	//constructor	
	public text3(int row, int column, boolean shipInSquare, boolean shipCurrentStatus, boolean fire) {
		super();
		this.row = row;
		this.column = column;
		this.shipInSquare = shipInSquare;
		this.shipCurrentStatus = shipCurrentStatus;
		this.fire = fire;
	}
	
	public text3() {
		super();
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
	public boolean isShipCurrentStatus() {
		return shipCurrentStatus;
	}
	public void setShipCurrentStatus(boolean shipCurrentStatus) {
		this.shipCurrentStatus = shipCurrentStatus;
	}
	public boolean isFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire = fire;
	}


	@Override
	public String toString() {
		
		if(fire) {
			return " x ";
		} else if(shipCurrentStatus){
			return " o ";
		} else {
			return " - ";
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
