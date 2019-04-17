package main;

public class MedicalItem extends Item{

	private int restoreHealthAmount;
	private boolean removePlague;
	
	public MedicalItem(String name, int price, String description, int restoreHealthAmount, boolean removePlague) {
		super(name, price, description);
		this.restoreHealthAmount = restoreHealthAmount;
		this.removePlague = removePlague;
	}

	public int getRestoreHealthAmount() {
		return restoreHealthAmount;
	}

	public void setRestoreHealthAmount(int restoreHealthAmount) {
		this.restoreHealthAmount = restoreHealthAmount;
	}

	public boolean isRemovePlague() {
		return removePlague;
	}

	public void setRemovePlague(boolean removePlague) {
		this.removePlague = removePlague;
	}

}
