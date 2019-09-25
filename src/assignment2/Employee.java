package assignment2;
/**
 * Designed by Kai Tian;
 */

public class Employee{
	private int ID;
	private String firstName;
	private int age;
	private double salary;
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void raiseSalary(double byPercent) {
		this.salary = this.salary * byPercent;
	}
	
}
