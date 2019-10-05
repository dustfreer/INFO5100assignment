package assignment4;

public class assignment4 {

	/*
	 * Q4, return AB;
	 * Designed by Kai Tian;
	 */	
	public static int[][] calculateAB(int[][] a, int[][] b){
		if ( a[0].length != b.length)
			return null;
		if ( a == null || b == null) {
			return null;
		}
		
		int num = 0;
		int[][] result = new int[a.length][b[0].length];
		for ( int i = 0; i < a.length; i++)
			for ( int j = 0; j < b[0].length; j++) {
				for ( int k = 0; k < b.length; k++) {								
					num += a[i][j] * b[j][k];
				}
				result[i][j] = num;
				num = 0;
			}
		return result;
	}
	
	/*
	 * Q5, return permutation;
	 * Designed by Kai Tian;
	 */	
	public static int[] permutation(String s) {
		if ( s.length() == 0 )
			return null;
		
		int[] A = new int[s.length()+1];
		int i = 0;
		int min = 0;
		int max = s.length();
		for ( i = 0; i < s.length(); i++) {
			if ( s.charAt(i) == 'I')
				A[i] = min++;
			else
				A[i] = max--;
		}
		A[i] = min;
		return A;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,0,0},{-1,0,3}};
		int[][] b = {{7,0,0},{0,0,0},{0,0,1}};
		
		int result[] = permutation("IDID");
		for ( int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
	
}
