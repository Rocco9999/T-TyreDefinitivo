package testDao;
import org.junit.Test;

import beanAccount.UtenteBean;
import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanProdotto.ProductBean;
import daoAgenda.AppuntamentoDAO;
import daoAgenda.AppuntamentoDAOImpl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import static org.junit.Assert.*;



public class AppuntamentoDAOTest {
	
	

	@Test
	 public void doRetrieveAppuntamentoByFiliale() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();
		 
		 Collection<AppuntamentoBean> voidList = new LinkedList<AppuntamentoBean>();
		 
		 Collection<AppuntamentoBean> listToReturn= dao.doRetrieveAppuntamentoByFiliale(2);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
	}	 
	
	@Test
	 public void doRetrieveAppuntamentoByFiliale1() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();
		 
		 Collection<AppuntamentoBean> voidList = new LinkedList<AppuntamentoBean>();
		 
		 Collection<AppuntamentoBean> listToReturn= dao.doRetrieveAppuntamentoByFiliale1(2,"2022-02-23");
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
	}	
	 
	 @Test
	 public void codice_Ordine() throws SQLException {
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();

		 assertEquals(1, dao.codice_Ordine(1));
		 		 
	}	 
	 
	 
	 @Test
	 public void doRetrieveDettagliAppuntamentoByFiliale() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();
		 
		 Collection<UtenteBean> voidList = new LinkedList<UtenteBean>();
		 
		 Collection<UtenteBean> listToReturn= dao.doRetrieveDettagliAppuntamentoByFiliale(1);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	  
	}	
	 
	 @Test
	 public void doRetrieveDettagliAppuntamentoByFiliale1() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();
		 
		 Collection<ComposizioneBean> voidList = new LinkedList<ComposizioneBean>();
		 
		 Collection<ComposizioneBean> listToReturn= dao.doRetrieveDettagliAppuntamentoByFiliale1(1);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
	}	
	
	 
	 @Test
	 public void doRetrieveDettagliAppuntamentoByFiliale2() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();
		 
		 Collection<ProductBean> voidList = new LinkedList<ProductBean>();
		 
		 Collection<ProductBean> listToReturn= dao.doRetrieveDettagliAppuntamentoByFiliale2(1);
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
	}	
	 
	 @Test
	 public void doRetrieveFiliale() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();

		 assertEquals(1, dao.doRetrieveFiliale("Calabria"));
	 }
	 
	 @Test
	 public void doRetrieveQuantita() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();

		 assertEquals(1, dao.doRetrieveQuantita("2022-02-23","Calabria","15:00"));
	 }
	 
	 @Test
	 public void  doRetrieveQuantitaFinal() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();

		 assertEquals(1, dao.doRetrieveQuantitaFinal("2022-02-23","Calabria","15:00",1));
	 }
	 
	 @Test
	 public void doSave() throws SQLException{
			
		 	AppuntamentoDAO dao= new AppuntamentoDAOImpl();
	 		
	    	AppuntamentoBean appuntamento = new AppuntamentoBean("Calabria","13","2022-02-23",1);
	    	
	    	
	        assertTrue(dao.doSave(appuntamento));
		 
	 }
	
	 @Test
	 public void doLastAppuntamento() throws SQLException{
		 
		 AppuntamentoDAO dao= new AppuntamentoDAOImpl();
		 
		 AppuntamentoBean appuntamento=dao.doLastAppuntamento();
		 
		 assertEquals(2, appuntamento.getId());
		 
		 
	 }
	 
	 
}