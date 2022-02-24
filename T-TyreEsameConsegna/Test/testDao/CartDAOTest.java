package testDao;
import org.junit.Test;

import beanProdotto.CartBean;
import beanProdotto.ProductBean;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;



public class CartDAOTest {
	
	

	@Test
	 public void doRetrieveAllBycart() throws SQLException{
		 
		 CartDAO dao= new CartDAOImpl();
		 
		 List<CartBean> voidList = new ArrayList<CartBean>();
		 
		 List<CartBean> listToReturn= dao.doRetrieveAllBycart(2);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
	}	 
	 
	
	@Test
	public void doRetrieveAllByproduct() throws SQLException{
	
		CartDAO dao= new CartDAOImpl();
		 
		Collection<ProductBean> voidList = new LinkedList<ProductBean>();
		 
		 Collection<ProductBean> listToReturn= dao.doRetrieveAllByproduct(1);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
	}
	
	
	@Test
	public void doUpdateProduct() throws SQLException{
		
		 CartDAO dao= new CartDAOImpl();
		 
		 assertTrue(dao.doUpdateProduct(5, 200, 15));
		
	}
	 
	 @Test
	    public void doSaveCarrello() throws SQLException{
		 	
		 	CartDAO dao= new CartDAOImpl();
		 		
	    	CartBean cart = new CartBean(5,100,20,10,2);
	    	
	    	
	        assertTrue(dao.doSaveCarrello(cart));
	    }
	 
	 @Test
	 public void doRetrieveAll()throws SQLException{
		 
		 	CartDAO dao= new CartDAOImpl();
		 
			Collection<CartBean> voidList = new LinkedList<CartBean>();
			 
			Collection<CartBean> listToReturn= dao.doRetrieveAll(2);
			 
			 assertNotEquals(voidList.size(),listToReturn.size());	
		 
	 }
	 
	
	 @Test
	 public void doRetrieveQuantita() throws SQLException {
		 
		 CartDAO dao= new CartDAOImpl();

		 assertEquals(9, dao.doRetrieveQuantita(2));
		 		 
	}
	 
	 @Test
	 public void doDeleteProduct() throws SQLException{
		 
		 CartDAO dao= new CartDAOImpl();

		 assertTrue(dao.doDeleteProduct(2));
		 
	 }
	 
	 
	 @Test
	 public void doDeleteAllByUser()throws SQLException{
		 
		 CartDAO dao= new CartDAOImpl();
		 
		 assertTrue(dao.doDeleteAllByUser(2));
		 
	 }
	 
	 
	 
}