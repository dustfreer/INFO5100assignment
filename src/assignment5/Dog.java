package assignment5;

public class Dog extends Pet implements Boardable{
	private String size;
	private int startMonth;
	private int startDay;
	private int startYear;
	
	private int endMonth;
	private int endDay;
	private int endYear;
	
	void isValidInput(int month, int day, int year) {
		if ( month < 1 || month > 12)
			throw new RuntimeException("invalid month, please input month between 1-12");
		if ( day < 1 || day > 31)
			throw new RuntimeException("invalid month, please input year between 1-31");
		if ( year < 1000 || year > 9999)
			throw new RuntimeException("invalid month, please input 4 digit number of year");
	}
	
	public Dog (String name, String ownerName, String color, String size){
		super(name, ownerName, color);
		this.size = size;
	}
	
	String getSize() {	
		return size;
	}
	
	public String toString() {
		String str = super.toString();
		str = "DOG:\n" + str;
		str += "Size: " + getSize();
		return str;
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		isValidInput(month, day, year);
		this.startMonth = month;
		this.startDay = day;
		this.startYear = year;
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		isValidInput(month, day, year);
		this.endMonth = month;
		this.endDay = day;
		this.endYear = year;
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		isValidInput(month, day, year);
		if ( month < this.startMonth || month > this.endMonth) return false;	
		if ( day < this.startDay || day > this.endDay) return false;
		if ( year < this.startYear || year > this.endYear) return false;
		
		return true;
	}
}
