package assignment4;

public class Sundae extends IceCream{
	private int topCost;
	
	public Sundae(String name, int cost, String topName, int topCost) {
		super(topName + " with\n" + name, cost);
		this.topCost = topCost;
	}
	
	public int getCost() {
		return super.cost + topCost;
	}
}
