package assignment4;

import java.util.ArrayList;
import java.util.List;

public class DessertShop {
	public static final double taxRate = 0.065;
	static int maxImumSizeOfName = 35;
	
	static String cents2dollarsAndCentsmethod(int dollar){
		String dol = "" + dollar / 100;
		String cent = "." + dollar % 100;
		return dol + cent;		
	}
	
	static String setSpace(String line, String cost){
		int spaceNum = maxImumSizeOfName - line.length() - cost.length();
		for ( int i = 0 ; i < spaceNum; i++)
			line = line + " ";
		line = line + cost +"\n";
		return line;
	}
	

	public static abstract class DessertItem{
		protected String name;
		
		public DessertItem() {
			
		}
		
		public DessertItem(String name) {
			
		}
		
		public String getName() {
			return name;
		}
		
		public abstract int getCost();
	}
	
	public static class Checkout{
		protected List<DessertItem> dessertItems = new ArrayList<DessertItem>();
		
		public Checkout(){;
		}
		
		public int numberOfItems() {
			return dessertItems.size();
		}
		
		public void enterItem(DessertItem item) {
			dessertItems.add(item);									
		}
		
		public void clear() {
			dessertItems.removeAll(dessertItems);
		}
		
		public int totalCost() {
			int totalcost = 0;
			for ( DessertItem d : dessertItems) {
				//System.out.println(d.getCost());
				totalcost += d.getCost();
			}
			return totalcost;
		}
		
		public int totalTax() {
			int totaltax = Math.round((float)(this.totalCost() * taxRate));
			return totaltax;
		}
		
		public String toString() {
			String receipt = "";
			
			receipt += "    M & M Dessert Shoppen\n";
			receipt += "    ---------------------\n\n";
			String line = "" ;
			for( DessertItem d : dessertItems) {
				line = d.getName();
				if ( d.getClass().getSimpleName().equals("Sundae")) {
					String[] n= d.getName().split("\n", 0);
					receipt += n[0]+ "\n";
					line = n[1];
				}else if ( d.getClass().getSimpleName().equals("Candy")) {
					receipt += "2.25 lbs. @ 3.99 /lb.\n";
				}else if ( d.getClass().getSimpleName().equals("Cookie")) {
					receipt += "4 @ 3.99 /dz.\n";
				}
				String cost = cents2dollarsAndCentsmethod(d.getCost());
				line = setSpace(line, cost);
				receipt += line;
			}
			String taxLine = setSpace("Tax", cents2dollarsAndCentsmethod(this.totalTax()));
			receipt += taxLine;
			String totalCostLine = setSpace("Total Cost", cents2dollarsAndCentsmethod(this.totalCost()+this.totalTax()));
			receipt += totalCostLine;
			return receipt;
			
		}
	}	
	
	
}
