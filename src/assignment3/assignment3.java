package assignment3;

public class assignment3 {
	/*
	 * Q5, count-and-say sequence;
	 * Designed by Kai Tian;
	 */	
	public static String countAndSay(int n) {
		if ( n < 1 || n > 30)
			throw new IllegalArgumentException("invalid n, n should be an integer where 1 <= n <= 30");
		
		String str = "1";	
		String result = "";
		for (int i = 1; i < n; i++) {
			int count = 1;
			for( int j = 0; j < str.length()-1; j++) {
				if (str.charAt(j+1) == str.charAt(j))
					count++;
				else {
					result = result + count + str.charAt(j);
					count = 1;
				}
					
			}
			result = result + count + str.charAt(str.length()-1);
			str = result;
			result = "";
		}
		return str;
	}
	
	/*
	 * Q6, reverse the string word by word;
	 * Designed by Kai Tian;
	 */	
	public static String reverse(String str) {
		if ( str.length() <= 0)
			throw new IllegalArgumentException("invalid string");
		
		String[] temp = str.split(" ", 0);
		String result = "";
		for (int i =temp.length-1; i >= 0; i--)
			result = result + temp[i] + " "; 
		
		return result.substring(0, result.length()-1);
	}
	
	/*
	 * Q7, all elements of the matrix in spiral order;
	 * Designed by Kai Tian;
	 */		
	public static int[] spiralOrder(int[][] matrix) {
		if (matrix.length <= 0)
			throw new IllegalArgumentException("invalid matrix");
			
		int[] result = new int[matrix.length * matrix[0].length];
		int col = matrix[0].length;
		int row = matrix.length;
		
		int i = 0;
		int j = 0;
		boolean spiral = true;
		result[0] = matrix[0][0];
		int count = 1;
		while ( count < result.length) {		
			while ( spiral && count < result.length) {				
				if ( j < col-1)
					j++;
				else if ( i < row-1)
					i++;
				else {
					spiral = false;
					break;
				}
				result[count++] = matrix[i][j];					
			}
			row--;
			
			while ( !spiral && count < result.length) {			
				if ( j > matrix[0].length - col)
					j--;
				else if ( i > (matrix.length-row) )
					i--;
				else {
					spiral = true;	
					break;
				}
				result[count++] = matrix[i][j];
			}
			col--;
		}
		return result;
		
	}
	/*
	 * Q8, Write the code that will take a string and make this conversion given a number of rows;
	 * Designed by Kai Tian;
	 */	
	public static String convert(String s, int numRows) {
		if ( s.length()<= 0 || numRows <= 0)
			throw new IllegalArgumentException("invalid String or numRows");
		
		if ( numRows == 1)
			return s;
		String[] str = new String[numRows];
		for ( int i = 0; i < numRows; i++)
			str[i] = "";
		String result = "";
		
		for ( int i =0; i < numRows; i++) {
				if ( i == 0 || i == numRows -1) {
					for ( int j = i; j < s.length(); j = j+ (2 * numRows -2))
						str[i] += s.charAt(j);
				}
				else {
					int j = i;
					boolean upOrdown = true; // true means up, false means down;
					while (j < s.length()) {
						str[i] += s.charAt(j);
						if (upOrdown)
							j = j + 2 * (numRows - 1 - i);
						else
							j = j + 2 * i;
						upOrdown = !upOrdown;
					}
				}
				}
		for ( int i =0; i < numRows; i++) {
			result += str[i];
		}
		return result;
		}
			
	
	
	/*
	 * Q9,Explain Encapsulation with an example. (Write at least 30-40 words);
	 * 
	 * class Student{
	 * 		private String name;
	 * 
	 * 		public String getName(){
	 * 			return this.name;
	 * 		}
	 * }
	 * 		public static void main(String[] args){
	 * 			Student st = new Student();
	 * 			String name = Student.name; 
	 * 			//this code will be wrong, because name in class is set as private,
	 * 			users can access it inside of Student class such like getName Function, but can not be accessed outside of Student class;
	 * 			that calls Encapsulation;
	 *	
	 * 		}
	 * 
	 */	
	
	/*
	 * Q10,Explain  What is the difference between Encapsulation and Abstraction
	 * 
	 * Encapulation in java means that users can use the object inside of class rather than outside of class. The data can not be changed outside.
	 * Abstraction is hiding essential details in class or method, and only show general information. Users can
	 * access abstraction by overriding methods and completing the detail information.
	 * 
	 */	
	
	public static void main(String[] args) {
//		String str = reverse("the sky is blue");
//		System.out.print(str);
		
		int[][] a = {{1,2,3,4}, {5,6,7,8}, {9, 10,11, 12}, {13,14,15,16}};
		int[] st = spiralOrder(a);
//		for ( int aa: st)
//			System.out.print(aa + " ");
		String s = "PAYPALISHIRING";
		System.out.println(convert(s,3));
		
	}
}

