package testDao;

import org.junit.Test;

import beanAccount.UtenteBean;
import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;

import java.sql.SQLException;
import static org.junit.Assert.*;



public class UtenteDAOTest {
	
	 @Test
	    public void doSave() throws SQLException{
	    	
	    	 UtenteBean utente = new UtenteBean("Prova","Prova","08182466668","Via Modanno","ggg@hotmail.it","dnhdfdh","4125412365412354");

	    	 UtenteDAO dao= new UtenteDAOImpl();
	    
	        assertTrue(dao.doSave(utente));
	    }
	    
   
    @Test
    public void doRetrieveByUsername() {
       
        UtenteDAO dao= new UtenteDAOImpl();
        
        UtenteBean utente = dao.doRetrieveByUsername("felice_ferrante@outlook.it");
        
        
        assertEquals("felice_ferrante@outlook.it", utente.getEmail());
    }
    
    
   
    @Test
    public void doRetrieveEmail() throws SQLException{
    	UtenteDAO dao= new UtenteDAOImpl();
    	
    	String email=dao.doRetrieveEmail(2);
    	
    
        
        assertEquals("felice_ferrante@outlook.it", email);
    }
 
    
    @Test
    public void doSaveADMFiliale() throws SQLException{
    	
    	UtenteDAO dao= new UtenteDAOImpl();
    	
    	 UtenteBean utente = new UtenteBean("Prova","Prova","ggg@hotmail.it","dnhdfdh");

    	 
        assertTrue( dao.doSaveADMFiliale(utente));
    }
    
    
    @Test
    public void doRetrieveByUsernamePassword() throws SQLException {

    	UtenteDAO dao= new UtenteDAOImpl();
        UtenteBean utente = dao.doRetrieveUtenteByUsernamePassword("felice_ferrante@outlook.it", "Online@10");
        
        
        assertEquals("Felice", utente.getNome());

    }
    
    @Test
    public void doUpdate() throws SQLException {
    	
    	UtenteDAO dao= new UtenteDAOImpl();
    	
    	UtenteBean utente= new UtenteBean(3,"Prova","Prova","08182466668","Via Modanno","ggg@hotmail.it","dnhdfdh","4125412365412354");
        
    	
        assertTrue(dao.doUpdate(utente));

    }
    
   
    @Test
    public void  doRetrieveUtenteByCode() throws SQLException {
    	
    	UtenteDAO dao= new UtenteDAOImpl();
    	
    	UtenteBean utente= dao.doRetrieveUtenteByCode(2);
        
    	
        assertEquals(2, utente.getID());

    }
    

    @Test
    public void  doRetrieveCodeByEmail() throws SQLException {
	
	UtenteDAO dao= new UtenteDAOImpl();
	
	UtenteBean utente= dao.doRetrieveCodeByEmail("felice_ferrante@outlook.it");
    
	
    assertEquals(2, utente.getID());

}
    
    
    
    
    
    

}