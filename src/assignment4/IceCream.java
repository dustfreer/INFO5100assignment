package assignment4;

import assignment4.DessertShop.DessertItem;

public class IceCream extends DessertItem{
	protected int cost;
	
	public IceCream(String name, int cost) {
		super.name = name;
		this.cost = cost;
	}
	
	public IceCream(String name, int cost, String topName, String topCost) {
	}
	
	public int getCost() {
		return cost;
	}

}
