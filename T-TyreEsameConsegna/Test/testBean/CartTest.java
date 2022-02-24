package testBean;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import beanProdotto.Cart;
import beanProdotto.ProductBean;



public class CartTest {
	
    @Test
    public void testCartBean() {
    	
    	Cart x= new Cart();
    	Cart y = new Cart();
    	
    	
    	 String name="prod1";
    	 String description="desc1";
    	 double price=123;
    	 String category="auto";
    	 String photo="foto.jpg";
    	String disponibilita="si";
    	
    	ProductBean prod= new ProductBean(name,description,price,category,photo,disponibilita);
    	
    	  assertEquals(x.addProduct(prod),y.addProduct(prod));
    	  
    	  assertEquals(x.delProduct(prod),y.delProduct(prod));

    	
    }
}
