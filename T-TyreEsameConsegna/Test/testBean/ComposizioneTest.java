package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanOrdine.ComposizioneBean;





public class ComposizioneTest {
	
    @Test
    public void testComposizioneBean() {
    	
    	 int cod_ordine=3;
    	 int quantita=2;
    	 float prezzo_unitario=50;
    	float prezzo_totale=100;
    	 int cod_prodotto=3;
    	 
    	 ComposizioneBean x= new ComposizioneBean(cod_ordine,quantita,prezzo_unitario,prezzo_totale,cod_prodotto);
    	 ComposizioneBean x1= new ComposizioneBean(cod_ordine,quantita,prezzo_unitario,prezzo_totale,cod_prodotto);
    	

         assertNotNull(x);
         
         String stringTest=x.toString();
         
         assertEquals(cod_ordine,x.getCod_ordine());
         assertEquals(quantita,x.getQuantita());
         
         
         
         assertEquals((int)prezzo_unitario,(int) x.getPrezzo_unitario());
         
         assertEquals((int)prezzo_totale,(int)x.getPrezzo_totale());
         assertEquals(cod_prodotto,x.getCod_prodotto());
        
         
         x1.setCod_ordine(cod_ordine);
         x1.setQuantita(quantita);
         x1.setPrezzo_unitario(prezzo_unitario);
         x1.setPrezzo_totale(prezzo_totale);
         x1.setCod_prodotto(cod_prodotto);
         
        
         
         
        
         assertEquals(cod_ordine, x1.getCod_ordine());
         assertEquals(quantita,x1.getQuantita());
        
         assertEquals((int)prezzo_unitario,(int)x1.getPrezzo_unitario());
         assertEquals((int)prezzo_totale, (int)x1.getPrezzo_totale());
         assertEquals(cod_prodotto, x1.getCod_prodotto());
         
         
        
         assertEquals(stringTest,x.toString());
    	 
    	 
    	 
    	 
    	 
    	

    	
    }
}
