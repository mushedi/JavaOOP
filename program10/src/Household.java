public class Household {
	
	private int id, household;
	private double income;
	private String state;
	
	public Household(int id, double income, int household, String state){
		this.id = id;
		this.income = income;
		this.household = household;
		this.state = state;
	}
	
	public void setID(int num) {
		id = num;
	}
	
	public void setIncome(double income) {
		this.income = income;
	}
	
	public void setHousehold(int household) {
		this.household = household;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getID() {
		return id;
	}
	
	public double getIncome() {
		return income;
	}
	
	public int getHousehold() {
		return household;
	}
	
	public String getState() {
		return state;
	}
	
}