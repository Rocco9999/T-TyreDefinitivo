package testBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import beanAgenda.AppuntamentoBean;




public class AppuntamentoTest {
	
    @Test
    public void testAppuntamentoBean() {
    	

    	 String indirizzo="Catanzaro";
    	 String ora="12";
    	 String data="2022-02-26";
    	
        AppuntamentoBean app= new AppuntamentoBean(indirizzo,ora,data);
        AppuntamentoBean app1= new AppuntamentoBean(indirizzo,ora,data);

        assertNotNull(app);
        
        String stringTest=app.toString();
        
        assertEquals(indirizzo, app.getIndirizzo());
        assertEquals(ora, app.getOra());
        assertEquals(data, app.getData());
       
        
        app1.setIndirizzo(indirizzo);
        app1.setOra(ora);
        app1.setData(data);
        
        assertEquals(indirizzo, app1.getIndirizzo());
        assertEquals(ora, app1.getOra());
        assertEquals(data, app1.getData());
        
       
        assertEquals(stringTest,app.toString());
    }
}
