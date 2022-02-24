package beanProdotto;
import java.util.ArrayList;

public class Cart {

	private ArrayList<Item> products;
	
	
	public Cart() {
		products = new ArrayList<Item>();
	
	}

	public void setProducts(ArrayList<Item> products) {
		this.products = products;
	}


	public boolean addProduct(ProductBean product) {
		Item order;
		 for(int i=0; i<products.size(); i++) {
		      order = products.get(i);
		      if (order.getCode()==(product.getCode())) {
		    	order.incrementNumItems();
		        return false;
		      }
		    }
		    return products.add(new Item(product));
	}
	
	
	public boolean delProduct(ProductBean product) {
		Item order;
		 for(int i=0; i<products.size(); i++) {
		      order = products.get(i);
		      if (order.getCode()==(product.getCode())) {
		    	  if(order.getQuantity()>1)
		    	order.decNumItems();
		    	  else 
		    		  if(order.getQuantity()==1) {
		    		  products.remove(products.get(i));
		    	  }
		        return false;
		      }
		    }
		    return products.add(new Item(product));
	}
	
	

	
	public ArrayList<Item> getProducts() {
		return  (ArrayList<Item>) products;
	}
	
	public float getTotale() {
		float total=0;
		for(int i=0;i<products.size();i++) {
			
			total+=products.get(i).getTotalCost();
			
		}
		
		return total;
	}
	
	public int totalNumCart() {
		int totale=0;
		for(int i=0;i<products.size();i++) {
			totale+=products.get(i).getQuantity();
		}
		
		return totale;
	}
	
}
