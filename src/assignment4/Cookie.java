package assignment4;

import assignment4.DessertShop.DessertItem;

public class Cookie extends DessertItem{
	private int cost;
	private int number;
	
	public Cookie(String name, int number, int cost) {
		super.name = name;
		this.number = number;
		this.cost = cost;
	}
	
	public int getCost() {
		return Math.round( (float)(cost * number / 12)) ;
	}

}
