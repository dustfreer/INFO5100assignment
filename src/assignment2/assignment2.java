package Assignment2;

/**
 * Designed by Kai Tian;
 */
public class Assignment2 {
	
	class Employee{
		private int ID;
		private String name;
		private int age;
		private double salary;
		
		
		public String getFirstName(Employee employee) {
			String str = employee.name;
			String[] splitStr = str.split(" ", 3); // split the name into 3 part: FirstName, MiddleName, LastName;
			return splitStr[0];
		}
		
		public void raiseSalary(Employee employee, double byPercent) {
			employee.salary = salary * byPercent;
		}
		
	}
	
	
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
    	double sum = 0.0;
    	for (int i = 0; i < employees.length; i++) {
    		if(employees[i].salary > 5000.0)
    			sum = sum + employees[i].salary;
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
    	if (employee.ID % 3 == 0)
    		System.out.println("Fizz");
    	else if (employee.ID % 5 == 0)
    		System.out.println("Buzz");
    	else if (employee.ID % 5 == 0 && employee.ID % 3 == 0)
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
    	if (employee.salary <= 2500.0)
    		tax = employee.salary * 0.1;
    	else if (employee.salary <= 5000.0 && employee.salary > 2500.0)
    		tax = employee.salary * 0.25;
    	else
    		tax = employee.salary * 0.35;
        return tax;
    }
    
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
    	double temp;
    	temp = firstEmployee.salary;
    	firstEmployee.salary = secondEmployee.salary;
    	secondEmployee.salary = temp;
    
    }

    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
    	int count = 0;
    	for (int i = 0; i < employees.length; i++) {
    		if (employees[i].age > 50)
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
    	String firstName = employee.getFirstName(employee);
    	char[] char1 = firstName.toCharArray();
    	StringBuffer reverseName = new StringBuffer();
    	for( int i = char1.length-1; i >= 0; i-- )
    		reverseName.append(char1[i]);
    	
    }

    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        // @TODO
    	String firstName = employee.getFirstName(employee);
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
    	employee.raiseSalary(employee, 3.0);
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
         	employees[i].ID = Integer.valueOf(str[0]);
         	employees[i].name = str[1]; // I define name in class employee, and a new method getFirstName;
         	employees[i].age = Integer.valueOf(str[2]);
         	employees[i].salary = Double.valueOf(str[3]);
         }
         
         return employees;
    }
}
