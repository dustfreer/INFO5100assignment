package assignment5;

public class FullTime extends Employee{

	public FullTime(String name, int paymentPerHour) {
		super(name, paymentPerHour);
	}
	
	public int calculateSalary() {
		return super.getPaymentPerHour() * 8 * 30;
	}
}
