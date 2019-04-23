package main;

/**
 * Represents a planet.
 */
public class Planet {
	private String name;
	private boolean shipPieceFound = false;
	private SpaceOutpost outpost = new SpaceOutpost();
	
<<<<<<< HEAD
	/**
	 * Creates a planet.
	 * @param name      A string name of the planet.
	 * @param outpost   A SpaceOutpost object.
	 */
	public Planet(String name, SpaceOutpost outpost) {
=======
	public Planet(String name) {
>>>>>>> 1c1ed1b57f01f671e256ed7d1bd5929d4af23a8c
		this.name = name;
	}
	
	/**
	 * Creates a string representation of the planet.
	 * @return A string representation of the planet.
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the name of the planet.
	 * @return the name of the planet.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the planet.
	 * @param name  A string name of the planet.
	 */
	public void setName(String name) {
		this.name = name;
	}
<<<<<<< HEAD
	
	/**
	 * Checks if the transporter part for this planet has been found.
	 * @return true if the transporter part for this planet has been found, false otherwise.
	 */
	public boolean isTransporterDiscovery() {
		return transporterDiscovery;
	}
	
	/**
	 * Sets if the transporter part has been found.
	 * @param transporterDiscovery   A boolean expression of whether the transporter part has been found.
	 */
	public void setTransporterDiscovery(boolean transporterDiscovery) {
		this.transporterDiscovery = transporterDiscovery;
	}
	
	/**
	 * Gets the space outpost on this planet.
	 * @return the space outpost.
	 */
=======

	public boolean isShipPieceFound() {
		return shipPieceFound;
	}

	public void setShipPieceFound(boolean shipPieceFound) {
		this.shipPieceFound = shipPieceFound;
	}

>>>>>>> 1c1ed1b57f01f671e256ed7d1bd5929d4af23a8c
	public SpaceOutpost getOutpost() {
		return outpost;
	}
	
	/**
	 * Sets the space outpost on this planet.
	 * @param outpost   A SpaceOutpost object.
	 */
	public void setOutpost(SpaceOutpost outpost) {
		this.outpost = outpost;
	}
	
	
}
