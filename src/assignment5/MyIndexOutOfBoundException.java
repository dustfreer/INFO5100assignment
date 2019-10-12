package assignment5;

public class MyIndexOutOfBoundException {
	public int lowerBound;
	public int upperBound;
	public int index;
	
	public int getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	public void indexOufOfBoundException(int index) {
		int lowerBound = getLowerBound();
		int upperBound = getUpperBound();
				
		if ( index < lowerBound || index > upperBound)
			throw new RuntimeException("Error Message: Index: "+ index + ", but lower bound: "+ lowerBound + ", Upper bound: "+ upperBound);
		
	}

	public static void main(String[] args) {
		try {
			MyIndexOutOfBoundException m = new MyIndexOutOfBoundException();
			m.setLowerBound(0);
			m.setUpperBound(9);
			m.indexOufOfBoundException(10);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
