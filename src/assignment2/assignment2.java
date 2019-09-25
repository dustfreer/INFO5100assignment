package assignment2;

import assignment2.Employee;

/**
 * Designed by Kai Tian;
 */

public class assignment2 {
	
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
    	double sum = 0.0;
    	
    	for (int i = 0; i < employees.length; i++) {
    		if(employees[i].getSalary() > 5000.0)
    			sum = sum + employees[i].getSalary();
    	}
        return sum;
    }

    
    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        // @TODO
    	int ID = employee.getID();
    	if (ID % 3 == 0)
    		System.out.println("Fizz");
    	else if (ID % 5 == 0)
    		System.out.println("Buzz");
    	else if (ID % 5 == 0 && ID % 3 == 0)
    		System.out.println("FizzBuzz");
    	else 
    		System.out.println("");
    }

    
    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        // @TODO
    	double tax;
    	double salary = employee.getSalary();
    	if (salary <= 2500.0)
    		tax = salary * 0.1;
    	else if (salary <= 5000.0 && salary > 2500.0)
    		tax = salary * 0.25;
    	else
    		tax = salary * 0.35;
        return tax;
    }
    
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
    	double temp;
    	double firstSalary = firstEmployee.getSalary();
    	double SecondSalary = secondEmployee.getSalary();
    	temp = firstSalary;
    	firstSalary = SecondSalary;
    	SecondSalary = temp;
    	firstEmployee.setSalary(firstSalary);
    	secondEmployee.setSalary(SecondSalary);
    }

    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
    	int count = 0;
    	for (int i = 0; i < employees.length; i++) {
    		if (employees[i].getAge() > 50)
    			count++;
    	}
        return count;
    }

    
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO
    	String firstName = employee.getFirstName();
    	char[] char1 = firstName.toCharArray();
    	StringBuffer reverseName = new StringBuffer();
    	for( int i = char1.length-1; i >= 0; i-- )
    		reverseName.append(char1[i]);
    	employee.setFirstName(reverseName.toString());
    }

    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        // @TODO
    	String firstName = employee.getFirstName();
    	char[] char1 = firstName.toCharArray();
    	int digitNumber = 0;
    	for(int i = 0; i< char1.length; i++) {
    		if ( char1[i] <= '9' && char1[i] >= '0')
    			digitNumber++;
    	}
    	if (digitNumber > 0)
    		System.out.println("true");
    	else
    		System.out.println("false");
    }

    
     /*
        Write a method to raise an employee's salary to three times of his/her original salary.
        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
        DO NOT change the input in this method.
        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
        Call this new method.
     */
    public void tripleSalary(Employee employee) {
        // @TODO
    	employee.raiseSalary(3.0);
    }
    
    
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
    	 Employee[] employees = new Employee[employeesStr.length];
         // @TODO
         for (int i = 0; i < employeesStr.length; i++) {
         	String[] str = employeesStr[i].split(",", 0);
         	employees[i].setID(Integer.valueOf(str[0]));
         	employees[i].setFirstName(str[1]); 
         	employees[i].setAge(Integer.valueOf(str[2]));
         	employees[i].setSalary(Double.valueOf(str[3]));
         }
         
         return employees;
    }
}
