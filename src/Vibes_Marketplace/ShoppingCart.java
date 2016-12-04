package Vibes_Marketplace;

import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<Integer> cart = new ArrayList<Integer>();
	ArrayList<Integer> quant = new ArrayList<Integer>();
	ArrayList<Items> finalCart = new ArrayList<Items>();
	public ShoppingCart(){
		
	}
	
	public boolean addItem(Items item){
		finalCart.add(item);
		return true;
	}
	
	public boolean removeItem(Items item){
		finalCart.remove(item);
		return true;
	}
}
