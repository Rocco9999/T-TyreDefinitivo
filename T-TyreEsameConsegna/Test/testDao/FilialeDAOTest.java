package testDao;
import org.junit.Test;

import beanAgenda.FilialeBean;
import daoAgenda.FilialeDAO;
import daoAgenda.FilialeDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;



public class FilialeDAOTest {
	
	 
	 @Test
	    public void doSave() throws SQLException{
		 	
		 	FilialeDAO dao= new FilialeDAOImpl();
		 		
	    	FilialeBean ordine = new FilialeBean("indirizzo","telefono",3,"9","18",2);
	    	
	    	
	        assertTrue(dao.doSave(ordine));
	    }
	 
	 
	 
	 @Test
	 public void doRetrieveAllIndirizzi() throws SQLException{
		 
		 FilialeDAO dao= new FilialeDAOImpl();
		 
		 Collection<FilialeBean> voidList = new LinkedList<FilialeBean>();
		 
		 Collection<FilialeBean> listToReturn= dao.doRetrieveAllIndirizzi();
		 
		 assertNotEquals(voidList.size(),listToReturn.size());
		 
		 
		 
	 }
	 
	 @Test
	 public void doRetrieveAllOrari() throws SQLException{
		 
		 FilialeDAO dao= new FilialeDAOImpl(); 
		 
		 List<String> voidList = new ArrayList<String>();
		 
		 List<String> listToReturn= dao.doRetrieveAllOrari("Calabria");
		 
		 assertNotEquals(voidList.size(),listToReturn.size());	 
		 
		 
		 
	 }
	 
	 
	
	 
	 

}