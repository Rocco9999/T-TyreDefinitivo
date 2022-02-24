package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanOrdine.OrdineBean;




public class OrdineTest {
	
    @Test
    public void testOrdineBean() {
    	
    	 float importo=25;
    	 String data_ordine="data";
    	 int cod_utente=3;
    	 int cod_app=2;
    	 String scelta_pagamento="Pay";
    	
    	
    	 
    	 
    	 
    	 OrdineBean x= new OrdineBean(importo,data_ordine,cod_utente,cod_app,scelta_pagamento);
    	 OrdineBean x1= new OrdineBean(importo,data_ordine,cod_utente,cod_app,scelta_pagamento);
    	

         assertNotNull(x);
         
         String stringTest=x.toString();
         
       
         assertEquals((int)importo,(int)x.getImporto());
         
         
         
         assertEquals(data_ordine,x.getData_ordine());
         
         assertEquals(cod_utente,x.getCod_utente());
         assertEquals(cod_app,x.getCod_app());
         assertEquals(scelta_pagamento,x.getScelta_pagamento());
         
        x1.setImporto(importo);
        x1.setData_ordine(data_ordine);
        x1.setCod_utente(cod_utente);
        x1.setCod_app(cod_app);
        x1.setScelta_pagamento(scelta_pagamento);
        
         
        assertEquals((int)importo,(int)x1.getImporto());
        
        
        
        assertEquals(data_ordine,x1.getData_ordine());
        
        assertEquals(cod_utente,x1.getCod_utente());
        assertEquals(cod_app,x1.getCod_app());
        assertEquals(scelta_pagamento,x1.getScelta_pagamento());
         
         
        
         assertEquals(stringTest,x.toString());
    

    	
    }
}
