package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanProdotto.ProductBean;



public class ProductTest {
	
    @Test
    public void testProductBean() {
    
    
    	 String name="prod1";
    	 String description="desc1";
    	 double price=123;
    	 String category="auto";
    	 String photo="foto.jpg";
    	String disponibilita="si";

    	 ProductBean prod= new ProductBean(name,description,price,category,photo,disponibilita);
    	 ProductBean prod1= new ProductBean(name,description,price,category,photo,disponibilita);
    	
        

        assertNotNull(prod);
        
        String stringTest=prod.toString();
        
        assertEquals(name,prod.getName());
        assertEquals(description,prod.getDescription()); 
        price=prod.getPrice();
        assertEquals(category,prod.getCategory());
        assertEquals(photo,prod.getPhoto());
        assertEquals(disponibilita,prod.getDisponibilita());
       
        
        prod1.setName(name);
        prod1.setDescription(description);
        prod1.setPrice(price);
        prod1.setCategory(category);
        prod1.setPhoto(photo);
        prod1.setDisponibilita(disponibilita);
        
        
       
        assertEquals(name, prod1.getName());
        assertEquals(description, prod1.getDescription());
        price= prod1.getPrice();
        assertEquals(category, prod1.getCategory());
        assertEquals(photo, prod1.getPhoto());
        assertEquals(disponibilita, prod1.getDisponibilita());
        
        
       
        assertEquals(stringTest,prod.toString());
    }
}
