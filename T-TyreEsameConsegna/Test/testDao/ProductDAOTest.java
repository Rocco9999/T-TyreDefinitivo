package testDao;

import org.junit.Before;
import org.junit.Test;

import beanProdotto.ProductBean;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;



public class ProductDAOTest {
	
	@Test
	 public void doLastProduct() throws SQLException{

		 ProductDAO dao= new ProductDAOImpl();
		 
		 Collection<ProductBean> listToReturn= dao.doRetrieveAll();
	    	
   	 ProductBean product= dao.doLastProduct();
   	 
		 
   	 assertEquals(listToReturn.size()+2, product.getCode());  
	 }
	
	 @Test
	    public void doSave() throws SQLException{
	    	
	    	 ProductBean product = new ProductBean("Product1","Descrizione1",100.00,"auto","pneumatico.jpg","si");

	    	 ProductDAO dao= new ProductDAOImpl();
	    
	        assertTrue(dao.doSave(product));
	    }
	 
	 @Test
	    public void doDelete() throws SQLException{

	    	 ProductDAO dao= new ProductDAOImpl();
	    	
	    	 
	        assertTrue(dao.doDelete(1));
	    }
	 
	
	 
	 @Test
	    public void doRetrieveByKey() throws SQLException{

	    	 ProductDAO dao= new ProductDAOImpl();
	    	
	    	 ProductBean product= dao.doRetrieveByKey(2);
	        
	         assertEquals(2, product.getCode()); 
	        
	    }
	 
	
	 
	 @Before
	 public void doRetrieveAll() throws SQLException{
		 ProductDAO dao= new ProductDAOImpl(); 
		 
		 Collection<ProductBean> voidList = new LinkedList<ProductBean>();
		 
		 Collection<ProductBean> listToReturn= dao.doRetrieveAll();
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
		 
		 
	 }
	 
	 @Test
	 public void doUpdate() throws SQLException{
		 
		 ProductDAO dao= new ProductDAOImpl(); 
		 
		 ProductBean product = new ProductBean("Product2","Descrizione2",102.00,"auto2","pneumatico2.jpg","si");
		 
		 assertTrue(dao.doUpdate(product));

	 }
	

	 @Test
	 public void doRetrieveByNome() {
		 ProductDAO dao= new ProductDAOImpl(); 
		 
		 List<ProductBean> voidList = new ArrayList<ProductBean>();
		 
		 List<ProductBean> listToReturn= dao.doRetrieveByNome("Bridgestone 205/55/16 Ecopia 93W");
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
		  
	 }
	 
	 
	 @Test
	 public void doRetrieveByNomeOrDescrizione() {
		 
		 ProductDAO dao= new ProductDAOImpl(); 
		 
		 List<ProductBean> voidList = new ArrayList<ProductBean>();
		 
		 List<ProductBean> listToReturn= dao.doRetrieveByNomeOrDescrizione("Bridgestone 205/55/16 Ecopia 93W");
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
	 }
	 
	 @Test
	 public void doRetrieveByCategoria() throws SQLException{
		 ProductDAO dao= new ProductDAOImpl(); 
		 
		 Collection<ProductBean> voidList = new LinkedList<ProductBean>();
		 
		 Collection<ProductBean> listToReturn= dao.doRetrieveByCategoria("auto");
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
	 }
	 
	 @Test
	 public void doUpdatePersonalizzazione() throws SQLException{

		 ProductDAO dao= new ProductDAOImpl();
		 
		 
	    	
    	 assertTrue(dao.doUpdatePersonalizzazione(5));  
	 }
	 
	 
	 
	 
	 
	 

}