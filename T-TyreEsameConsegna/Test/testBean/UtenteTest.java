package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanAccount.UtenteBean;




public class UtenteTest {
	
    @Test
    public void testUtenteBean() {
    	

    	int ID=1;
    	 String nome="Nome";
    	String cognome="Cognome";
    	 String telefono="Telefono";
    	 String indirizzo="Indirizzo";
    	 String email="Email";
    	 String password="Password";
    	 String numero_carta="Numero carta";
    	 String tipo="Tipo";
    	 
    	 
    	 
    	 UtenteBean x= new UtenteBean(ID,nome,cognome,telefono,indirizzo,email,password,numero_carta);
    	 
    	 UtenteBean x1= new UtenteBean(ID,nome,cognome,telefono,indirizzo,email,password,numero_carta);
    	

         assertNotNull(x);
         
         String stringTest=x.toString();
         
         assertEquals(ID,x.getID());
         assertEquals(nome,x.getNome());
         assertEquals(cognome,x.getCognome());
         assertEquals(indirizzo,x.getIndirizzo());
         
         assertEquals(email,x.getEmail());
         assertEquals(password,x.getPassword());
         assertEquals(numero_carta,x.getNumero_carta());
         
         x1.setID(ID);
         x1.setNome(nome);
         x1.setCognome(cognome);
         x1.setTelefono(telefono);
         x1.setIndirizzo(indirizzo);
         x1.setEmail(email);
         x1.setPasswordhash(password);
         x1.setNumero_carta(numero_carta);
         x1.setTipo(tipo);
         
         assertEquals(ID,x1.getID());
         assertEquals(nome,x1.getNome());
         assertEquals(cognome,x1.getCognome());
         assertEquals(indirizzo,x1.getIndirizzo());
         
         assertEquals(email,x1.getEmail());
         assertEquals(password,x1.getPassword());
         assertEquals(numero_carta,x1.getNumero_carta());
         
         
        
         assertEquals(stringTest,x.toString());
    	 
    	 
    	 
    	 
    	 
    	

    	
    }
}
