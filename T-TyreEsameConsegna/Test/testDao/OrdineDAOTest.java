package testDao;

import org.junit.Test;

import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanOrdine.OrdineBean;
import beanProdotto.ProductBean;
import daoOrdine.OrdineDAO;
import daoOrdine.OrdineDAOImpl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import static org.junit.Assert.*;



public class OrdineDAOTest {
	
	
	
	@Test
	 public void updateEsito() throws SQLException{

		OrdineDAO dao= new OrdineDAOImpl(); 
		  
		 assertTrue(dao.updateEsito("in attesa", 1));
		   
	 }
	
	 @Test
	    public void doLastOrdine() throws SQLException{
	    	
		 OrdineDAO dao= new OrdineDAOImpl();
		
		 OrdineBean ordine= dao.doLastOrdine(2);

		 assertEquals(1,ordine.getCode() );  
		 
	
	   }
	
	 
	 @Test
	    public void doSave() throws SQLException{
		 	
		 	OrdineDAO dao= new OrdineDAOImpl();
		 		
	    	OrdineBean ordine = new OrdineBean(300,"2022-02-25",2,1,"Online");
	    	
	    	
	        assertTrue(dao.doSave(ordine));
	    }
	 
	 
	 
	 @Test
	 public void doRetrieveOrdineUtente() throws SQLException {
		 OrdineDAO dao= new OrdineDAOImpl(); 
		 
		 Collection<OrdineBean> voidList = new LinkedList<OrdineBean>();
		 
		 Collection<OrdineBean> listToReturn= dao.doRetrieveOrdineUtente(2);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
		  
	 }
	 

	 
	 @Test
	 public void doRetrieveOrdineDettagliAppuntamento() throws SQLException {
		 OrdineDAO dao= new OrdineDAOImpl(); 
		 
		 Collection<AppuntamentoBean> voidList = new LinkedList<AppuntamentoBean>();
		 
		 Collection<AppuntamentoBean> listToReturn= dao.doRetrieveOrdineDettagliAppuntamento(1);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
		  
	 }
	 

	 @Test
	 public void doRetrieveOrdineDettagliProdotto() throws SQLException {
		 OrdineDAO dao= new OrdineDAOImpl(); 
		 
		 Collection<ProductBean> voidList = new LinkedList<ProductBean>();
		 
		 Collection<ProductBean> listToReturn= dao.doRetrieveOrdineDettagliProdotto(1);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
		  
	 }
	 
	 
	 @Test
			 public void doRetrieveOrdineDettagliOrdine() throws SQLException {
				 OrdineDAO dao= new OrdineDAOImpl(); 
				 
				 Collection<ComposizioneBean> voidList = new LinkedList<ComposizioneBean>();
				 
				 Collection<ComposizioneBean> listToReturn= dao.doRetrieveOrdineDettagliOrdine(1);
				 
				 assertNotEquals(voidList.size(),listToReturn.size());
				  
			 }
	 
	 
	 @Test
	 public void doRetrieveEsito() throws SQLException{
	    	OrdineDAO dao= new OrdineDAOImpl();
	    	
	    	String esito=dao.doRetrieveEsito(1);
	           
	        assertEquals("in attesa", esito);
	    }

	 
	 
	 

}