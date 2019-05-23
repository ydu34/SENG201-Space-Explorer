package main;

/**
 * Represents a planet, which has a name, an image, a space outpost, and if
 * their is a piece on this planet.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Planet {
	private String name;
	private boolean pieceDetected = true;
	private SpaceOutpost outpost = new SpaceOutpost();
	private String image;

	/**
	 * Creates a planet.
	 * 
	 * @param name  A string name of the planet.
	 * @param image A string holding the location of the image.
	 */
	public Planet(String name, String image) {
		this.name = name;
		this.image = image;
	}

	/**
	 * Checks if there is a ship piece on the planet.
	 * 
	 * @return A string of whether there is a ship piece on the planet.
	 */
	public String planetPieceDetected() {
		String text;
		if (pieceDetected) {
			text = "Yes";
		} else {
			text = "No";
		}
		return text;
	}

	/**
	 * Creates a string representation of the planet.
	 * 
	 * @return A string representation of the planet.
	 */
	public String toString() {
		return name;
	}

	/**
	 * Gets the name of the planet.
	 * 
	 * @return the name of the planet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the planet.
	 * 
	 * @param name A string name of the planet.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Checks if the ship piece on the planet has been found.
	 * 
	 * @return true if the ship piece on the planet has been found, false otherwise.
	 */
	public boolean isPieceDetected() {
		return pieceDetected;
	}

	/**
	 * Sets if the ship piece on the planet has been found.
	 * 
	 * @param shipPieceFound A boolean expression of whether the ship piece on the
	 *                       planet has been found.
	 */
	public void setPieceDetected(boolean shipPieceFound) {
		this.pieceDetected = shipPieceFound;
	}

	/**
	 * Gets the space outpost on the planet.
	 * 
	 * @return the space outpost.
	 */
	public SpaceOutpost getOutpost() {
		return outpost;
	}

	/**
	 * Sets the space outpost on the planet.
	 * 
	 * @param outpost A SpaceOutpost object.
	 */
	public void setOutpost(SpaceOutpost outpost) {
		this.outpost = outpost;
	}

	/**
	 * Gets the path location of the image.
	 * 
	 * @return the the path location of the image.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the link to the image.
	 * 
	 * @param image A string link to the image.
	 */
	public void setImage(String image) {
		this.image = image;
	}

}
