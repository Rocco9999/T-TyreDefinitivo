package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanProdotto.Item;
import beanProdotto.ProductBean;




public class ItemTest {
	
    @Test
    public void testItemBean() {
    
    
    	 String name="prod1";
    	 String description="desc1";
    	 double price=123;
    	 String category="auto";
    	 String photo="foto.jpg";
    	String disponibilita="si";
    	
    	int quantity=0;

    	
    	
    	 
    	 ProductBean prod= new ProductBean(name,description,price,category,photo,disponibilita);
    	 ProductBean prod1= new ProductBean(name,description,price,category,photo,disponibilita);
    	
    	 Item x= new Item(prod);
    	 Item  y= new Item(prod1);
    	
    	 
        Item item = new Item(prod,quantity);
        Item item1 = new Item(prod,quantity);
    	 

        assertNotNull(item);
        
        String stringTest=item.toString();
        
        assertEquals(prod,item.getProduct());
        assertEquals(quantity,item.getQuantity());
        
     
       
        item1.setProduct(prod);
        item1.setQuantity(quantity);
        
       
        assertEquals(prod, item1.getProduct());
        assertEquals(quantity, item1.getQuantity());
       
       
        assertEquals(stringTest,item.toString());
        
        assertEquals(item.getCode(),item1.getCode());
        
        
        assertEquals((int)item.getUnitCost(),(int)item.getUnitCost());
        
        assertEquals(item.getNumProduct(),item1.getNumProduct());
        
        assertEquals((int)item.getTotalCost(),(int)(item1.getNumProduct()));
        
        assertEquals(x,y);

       
        
        
    }

	
}
