package assignment5;

public class Pet {
	String petName;
	String ownerName;
	String color;
	public int sex;
	
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	public static final int SPAYED = 2;
	public static final int NEUTERED = 3;
	
	Pet (String name, String ownerName, String color){
		this.petName = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	String getPetName() {
		return petName;
	}
	String getOwnerName() {
		return ownerName;
	}
	String getColor() {
		return color;
	}
	public void setSex(int sexid) {
		switch ( sexid) {
		case MALE:
			sex = MALE;break;	
		case FEMALE:
			sex = FEMALE;break;
		case SPAYED:
			sex = SPAYED;break;
		case NEUTERED:
			sex = NEUTERED;
		}
	}
	
	int getSex() {
		return sex;
	}
	public String toString() {
		String str = getPetName() + " owned by " + getOwnerName()+"\n";
		str += "Color: " + getColor() + "\n";
		String sex = "";
		switch ( getSex()) {
		case MALE:
			sex = "MALE";break;
		case FEMALE:
			sex = "FEMALE";break;
		case SPAYED:
			sex = "SPAYED";break;
		case NEUTERED:
			sex = "NEUTERED";
		}
		str += "sex "+ sex + "\n";
		return str;		
	
	}
}
