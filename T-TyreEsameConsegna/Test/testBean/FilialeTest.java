package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanAgenda.FilialeBean;




public class FilialeTest {
	
    @Test
    public void testFilialeBean() {
    	
    	String indirizzo="prova";
    	String telefono="0818245587";
         int n_interventiora=3;
    	 String orarioapertura="9";
    	 String orariochiusura="16";
    	 int cod_utente=2;
    	
    	 
    	 
    	 
    	 FilialeBean x= new FilialeBean(indirizzo,telefono,n_interventiora,orarioapertura,orariochiusura,cod_utente);
    	 FilialeBean x1= new FilialeBean(indirizzo,telefono,n_interventiora,orarioapertura,orariochiusura,cod_utente);
    	

         assertNotNull(x);
         
         String stringTest=x.toString();
         
         assertEquals(indirizzo,x.getIndirizzo());
         assertEquals(telefono,x.getTelefono());
         
         
         
         assertEquals(n_interventiora,x.getN_interventiora());
         
         assertEquals(orarioapertura,x.getOrarioapertura());
         assertEquals(orariochiusura,x.getOrariochiusura());
         assertEquals(cod_utente,x.getCod_utente());
         
         x1.setIndirizzo(indirizzo);
         x1.setTelefono(telefono);
         x1.setN_interventiora(n_interventiora);
         x1.setOrarioapertura(orarioapertura);
         x1.setOrariochiusura(orariochiusura);
         x1.setCod_utente(cod_utente);
         
         
         assertEquals(indirizzo,x1.getIndirizzo());
         assertEquals(telefono,x1.getTelefono());
         
         
         
         assertEquals(n_interventiora,x1.getN_interventiora());
         
         assertEquals(orarioapertura,x1.getOrarioapertura());
         assertEquals(orariochiusura,x1.getOrariochiusura());
         assertEquals(cod_utente,x1.getCod_utente());
         
         
        
         assertEquals(stringTest,x.toString());
    	 
    	 
    	 
    	 
    	 
    	

    	
    }
}
