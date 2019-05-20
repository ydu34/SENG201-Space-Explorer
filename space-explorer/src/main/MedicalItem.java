package main;


/**
 * Represents a medical item.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class MedicalItem extends Item{

	private int restoreHealthAmount;
	private boolean removePlague;
	
	/**
	 * Creates a medical item.
	 * @param name                 A string name of the medical item.
	 * @param price                An int of the medical item price.
	 * @param description          A string description of the medical item.
	 * @param restoreHealthAmount  An int of restore health amount when the medical item is consumed. 
	 * @param removePlague         A boolean expression of whether the medical item is a cure to the space plague.
	 */
	public MedicalItem(String name, int price, String description, int restoreHealthAmount, boolean removePlague) {
		super(name, price, description);
		this.restoreHealthAmount = restoreHealthAmount;
		this.removePlague = removePlague;
	}
	
	/**
	 * Gets the restore health amount of the medical item.
	 * @return An int of the restore health amount of the medical item.
	 */
	public int getRestoreHealthAmount() {
		return restoreHealthAmount;
	}

	/**
	 * Sets the restore health amount of the medical item.
	 * @param restoreHealthAmount   An int of restore health amount when the medical item is consumed.
	 */
	public void setRestoreHealthAmount(int restoreHealthAmount) {
		this.restoreHealthAmount = restoreHealthAmount;
	}

	/**
	 * Checks if the medical item is the cure to the space plague.
	 * @return True if the medical item is the cure to the space plague, false otherwise.
	 */
	public boolean isRemovePlague() {
		return removePlague;
	}

	/**
	 * Sets the medical item as the cure to the space plague.
	 * @param removePlague   A boolean expression of whether the medical item is a cure to the space plague.
	 */
	public void setRemovePlague(boolean removePlague) {
		this.removePlague = removePlague;
	}





}
