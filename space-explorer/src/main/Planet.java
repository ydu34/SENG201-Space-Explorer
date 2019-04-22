package main;

public class Planet {
	private String name;
	private boolean shipPieceFound = false;
	private SpaceOutpost outpost = new SpaceOutpost();
	
	public Planet(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isShipPieceFound() {
		return shipPieceFound;
	}

	public void setShipPieceFound(boolean shipPieceFound) {
		this.shipPieceFound = shipPieceFound;
	}

	public SpaceOutpost getOutpost() {
		return outpost;
	}
	public void setOutpost(SpaceOutpost outpost) {
		this.outpost = outpost;
	}
	
	
}
