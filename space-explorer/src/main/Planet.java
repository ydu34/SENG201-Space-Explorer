package main;

/**
 * Represents a planet.
 */
public class Planet {
	private String name;
	private boolean transporterDiscovery = true;
	private SpaceOutpost outpost;
	
	/**
	 * Creates a planet.
	 * @param name      A string name of the planet.
	 * @param outpost   A SpaceOutpost object.
	 */
	public Planet(String name, SpaceOutpost outpost) {
		this.name = name;
		this.outpost = outpost;
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
