package assignment5;

public abstract class Employee {
	private String Name;
	private int paymentPerHour;

	public Employee(String name, int paymentPerHour) {
		
	}
	
	public abstract int calculateSalary();
	public String getName() {
		return Name;		
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPaymentPerHour() {
		return paymentPerHour;
	}
	public void setPaymentPerHour(int paymengPerHour) {
		this.paymentPerHour = paymengPerHour;
	}
	
}
