package assignment5;

public class Number {

	public static int count(int a, int b) {
		if( b == 0)
			throw new RuntimeException("the divisor number can not be 0");
		if ( a % b != 0)
			throw new RuntimeException("Divisor cannot be divisible by divisor");
		int quotinet = a/b;	
		return quotinet;
		
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(count(8,4));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
				
	}
}
