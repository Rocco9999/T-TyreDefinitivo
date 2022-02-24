package beanProdotto;

public class Item{

	
	private ProductBean product = new ProductBean();
	private int quantity;
	
	
	
public Item(ProductBean product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

public Item(ProductBean p) {
		
	setProduct(p);
    setQuantity(1);
	}
	
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean p) {
		this.product = p;
	}


	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getCode() {
	    return(getProduct().getCode());
	  }
	
	 
	 
	 
	 public double getUnitCost() {
		    return(getProduct().getPrice());
		 }
	 
	
	
	
	 public void incrementNumItems() {
		    //setNumItems(getNumItems() + 1);
			  quantity++;
		  }
	 
	 public void decNumItems() {
		    //setNumItems(getNumItems() + 1);
			  quantity--;
		  }
	
	 
	 public int getNumProduct() {
		 return quantity;
	 }
	 
	 
	 public double getTotalCost() {
		    return(getNumProduct() * getUnitCost());
		  }
	
	
	

}
