package daoProdotto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import beanProdotto.CartBean;
import beanProdotto.ProductBean;



public interface CartDAO {
	
	public ArrayList<CartBean> doRetrieveAllBycart(int codice_utente) throws SQLException;
	
	public Collection<ProductBean> doRetrieveAllByproduct(int codice_prodotto) throws SQLException;
	
	public boolean doUpdateProduct(int quantita,float prezzo_totale,int codice_prodotto) throws SQLException;
	
	public  boolean doSaveCarrello(CartBean bean1) throws SQLException;
	
	public Collection<CartBean> doRetrieveAll(int codice_utente) throws SQLException;
	
	public int doRetrieveQuantita(int codice_utente) throws SQLException;
	
	public boolean doDeleteProduct(int code) throws SQLException;
	
	
	public boolean doDeleteAllByUser(int code) throws SQLException;

}
