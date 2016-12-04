

import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<Integer> cart = new ArrayList<Integer>();
	ArrayList<Integer> quant = new ArrayList<Integer>();
	public ShoppingCart(){
		
	}
	
	public boolean addItem(int quantity, int id){
		if(this.cart.contains(id)){
			int index = cart.indexOf(id);
			quant.set(index, quant.get(index)+quantity);
		}
		else{
			quant.add(quantity);
			cart.add(id);
		}
		return true;
	}
	
	public boolean removeItem(int quantity, int id){
		if(this.cart.contains(id)){
			int index = cart.indexOf(id);
			quant.set(index, quant.get(index)-quantity);
			if(quant.get(index)<=0){
				quant.remove(index);
				cart.remove(index);
				return true;
			}
		}
		else{
			return false;
		}
		return true;
	}
}
