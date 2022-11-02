package BattleField;

public class Square {
	
	private int row;
	private int column;
	private boolean shipInSquare;
	private boolean shipCurrentStatus;
	private boolean fire;
	
	//constructor	
	public Square(int row, int column, boolean shipInSquare, boolean shipCurrentStatus, boolean fire) {
		super();
		this.row = row;
		this.column = column;
		this.shipInSquare = shipInSquare;
		this.shipCurrentStatus = shipCurrentStatus;
		this.fire = fire;
	}
	
	public Square() {
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
			return " X ";
		} else if(!shipCurrentStatus){
			return " B ";
		} else {
			return " - ";
		}		
		
	}
	
	
	
	

}
