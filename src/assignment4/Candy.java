package assignment4;

import assignment4.DessertShop.DessertItem;

public class Candy extends DessertItem{
	private double weight;
	private int price;

	public Candy(String name, double weight, int price) {
		super.name = name;
		this.weight = weight;
		this.price = price;
	}

	
	public int getCost() {	
		return Math.round( (float)(weight * price) );
	}

}
