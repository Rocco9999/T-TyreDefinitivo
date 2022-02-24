package testDao;

import org.junit.Test;

import beanOrdine.ComposizioneBean;
import daoOrdine.ComposizioneDAO;
import daoOrdine.ComposizioneDAOImpl;

import java.sql.SQLException;


import static org.junit.Assert.*;



public class ComposizioneDAOTest {


	 
	 @Test
	    public void doSave() throws SQLException{
		 	
		 	ComposizioneDAO dao= new ComposizioneDAOImpl();
		 		
	    	ComposizioneBean ordine = new ComposizioneBean(1,2,50,100,10);
	    	
	    	
	        assertTrue(dao.doSaveComposizione(ordine));
	    }
	 
	 
	 
	
}