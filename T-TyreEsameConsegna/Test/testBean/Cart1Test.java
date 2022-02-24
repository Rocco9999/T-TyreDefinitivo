package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanProdotto.CartBean;




public class Cart1Test {
	
    @Test
    public void testCarttBean() {
    
    
    	 int quantita=2;
    	 float prezzo_totale=500;
    	 float prezzo_unitario=250;
    	 int cod_prodotto=10;
    	 int cod_utente=2;

    	CartBean x= new CartBean(2,prezzo_totale,prezzo_unitario,cod_prodotto,cod_utente);
    	CartBean x1= new CartBean(2,prezzo_totale,prezzo_unitario,cod_prodotto,cod_utente);
        

        assertNotNull(x);
        
        String stringTest=x.toString();
        
        assertEquals(quantita,x.getQuantita());
        assertEquals((int)prezzo_totale,(int)x.getPrezzo_totale());
        
        
        assertEquals((int)prezzo_unitario,(int)x.getPrezzo_unitario());
        
        assertEquals(cod_prodotto,x.getCod_prodotto());
        assertEquals(cod_utente,x.getCod_utente());
       
        
        x1.setQuantita(quantita);
        x1.setPrezzo_totale(prezzo_totale);
        x1.setPrezzo_unitario(prezzo_unitario);
        x1.setCod_prodotto(cod_prodotto);
        x1.setCod_utente(cod_utente);
       
        
        
       
        assertEquals(quantita, x1.getQuantita());
        assertEquals((int)prezzo_totale,(int) x1.getPrezzo_totale());
       
        assertEquals((int)prezzo_unitario,(int)x1.getPrezzo_unitario());
        assertEquals(cod_prodotto, x1.getCod_prodotto());
        assertEquals(cod_utente, x1.getCod_utente());
        
        
       
        assertEquals(stringTest,x.toString());
    }
}
