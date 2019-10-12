package assignment5_1;

import assignment5.Cat;
import assignment5.Dog;
import assignment5.Pet;

public class Test{
	public static void main(String[] args) {
		Cat c = new Cat("Tom", "Bob", "black", "short");
		c.setSex(Pet.SPAYED);
		System.out.println(c);
		Dog d = new Dog("Spot", "Susan", "white", "medium");
		d.setSex(Pet.SPAYED);
		System.out.println(d);
		
		c.setBoardStart(1, 20, 2019);
		c.setBoardEnd(9, 20, 2019);
		System.out.println(c.boarding(5, 20, 12019));
	}
}