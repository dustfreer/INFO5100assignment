package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Atm {
	private double availabeAmountMachine;
	private double transactionFee;
	private Map<String, User> userData ;
	private List<String> transaction;

	Atm(double availabeAmountMachine, double transactionFee){
		this.availabeAmountMachine = availabeAmountMachine;
		this.transactionFee = transactionFee;
		userData = new HashMap<String, User>(); //key represents bank account.
		transaction = new ArrayList<String>();
	}
	
	public double getAvailabeAmountMachine() {
		return availabeAmountMachine;
	}

	public void setAvailabeAmountMachine(double availabeAmountMachine) {
		this.availabeAmountMachine = availabeAmountMachine;
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("New User or Current User? please input 1 for NEW and 2 for CURRENT, exit for EXIT");

			String input = sc.nextLine();
			if ( input.equals("exit")) break;
			if ( input.equals("1") || input.equals("2") ) {
				if ( input.equals("1") ) {
					System.out.println("please set a bank account number");
					String bankAccountNumber = sc.nextLine();
					if ( checkIfAccountExist(bankAccountNumber) ) continue;
					
					System.out.println("please set a password");
					String password = sc.nextLine();
					createNewAccount(bankAccountNumber, password);
										
					System.out.println("please complete your account information"
							+ "please input your name");
					String name = sc.nextLine();
					System.out.println("please input your age");
					int age = Integer.valueOf(sc.nextLine());
					System.out.println("please input your address");
					String address = sc.nextLine();
					System.out.println("please input your phoneNumber");
					String phoneNumber = sc.nextLine();
					completeUserInformation(bankAccountNumber, name, age, address, phoneNumber);
					
					if ( !login(sc, bankAccountNumber, password) ) continue;
				}
				if ( input.equals("2")) {
					System.out.println("please input your bank account number");
					String bankAccountNumber = sc.nextLine();
					System.out.println("please input your password");
					String password = sc.nextLine();
					if ( !login(sc, bankAccountNumber, password) ) {
						System.out.println("if you forget password, please input forget");
						if ( sc.nextLine().equals("forget") ) {
							System.out.println("please input your name");
							String name = sc.nextLine();
							System.out.println("please input your age");
							int age = Integer.valueOf(sc.nextLine());
							System.out.println("please input your phoneNumber");
							String phoneNumber = sc.nextLine();
							if ( !validateInformation(bankAccountNumber, name, age, phoneNumber)) continue;
							
							System.out.println("please set your new password");
							password = sc.nextLine();
							resetPassword(bankAccountNumber, password);
						}
					}
				}
			}
			
		}
		sc.close();
	}
	
	public void createNewAccount(String bankAccountNumber, String password) {
		User user = new User();
		user.setBankAccountNumber(bankAccountNumber);
		user.setPassword(password);
		userData.put(bankAccountNumber,user);
		System.out.println("Create new account success!");
	}
	
	public void completeUserInformation(String bankAccountNumber, String name, int age, String address, String phoneNumber) {
		User user = userData.get(bankAccountNumber);
		user.setName(name);
		user.setAge(age);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		System.out.println("Update account information success!");
	}
	
	public boolean checkIfAccountExist(String bankAccountNumber) {
		if ( !userData.containsKey(bankAccountNumber)) return false;
		System.out.println("The bank Account is already exist");
		return true;
	}
	
	public boolean validateInformation(String bankAccountNumber, String name, int age, String phoneNumber) {
		User user = userData.get(bankAccountNumber);
		if ( user.getName().equals(name) && user.getAge() == age && user.getPhoneNumber().equals(phoneNumber) ) {
			System.out.println("Check information success!");
			return true;
		}
		System.out.println("Check information failed: invalid information");
		return false;
	}
	
	public void resetPassword(String bankAccountNumber, String password) {
		User user = userData.get(bankAccountNumber);
		user.setPassword(password);
		System.out.println("Reset password success!");
	}
	
	public boolean login(Scanner sc, String bankAccountNumber, String password) {
		if ( userData.containsKey(bankAccountNumber) && userData.get(bankAccountNumber).getPassword().equals(password)) {
			System.out.println("Login in success!");
			operation(sc, bankAccountNumber);
			return true;
		}else {
			System.out.println("Login in failed: wrong bank account number or password!");
			return false;
		}
	}
	
	public void operation(Scanner sc, String bankAccountNumber) {
		while ( true ) {				
			System.out.println("For information of 1 :available Balance, 2: withDrawal, 3: deposit, 4: recent Transactions, 5: change Password and exit");
			String input = sc.nextLine();
			if ( input.equals("exit"))
				break;
			if ( input.equals("1") ) {
				System.out.println(getAvailabeAmountMachine());
			}
			else if ( input.equals("2") ) {
				System.out.println("Input amount of money you want to withdraw");
				double withDrawal = Double.valueOf(sc.nextLine());
				double availabeAmount = getAvailabeAmountMachine();
				if ( withDrawal > availabeAmount) {
					System.out.println("No enough money to withdraw");
				}else {					
					setAvailabeAmountMachine(availabeAmount - withDrawal);
					String record = "withDrawal - " + withDrawal;
					transaction.add(record);
					System.out.println("Withdraw success");
				}				
			}
			else if ( input.equals("3") ) {
				System.out.println("Input amount of money you want to deposit");
				double deposit = Double.valueOf(sc.nextLine());
				double availabeAmount = getAvailabeAmountMachine();
				setAvailabeAmountMachine(availabeAmount + deposit);				
				String record = "deposit - " + deposit;
				transaction.add(record);	
				System.out.println("Deposit success");
			}
			else if ( input.equals("4") ) {
				recentTransaction();
			}
			else if ( input.equals("5") ) {
				System.out.println("Please reset your new password");
				String password = sc.nextLine();
				resetPassword(bankAccountNumber, password);
			}
			
		}
	}
	
	public void recentTransaction() {
		int index = transaction.size()-1;
		for ( int i = 0; i < 10; i++) {
			System.out.println(transaction.get(index--));
			if ( index < 0) break;
		}
	}
	public void addTransactionFee() {
		double availabeAmount = getAvailabeAmountMachine();
		setAvailabeAmountMachine(availabeAmount - transactionFee);
	}
	
	
	
}
