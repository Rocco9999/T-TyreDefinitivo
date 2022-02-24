package daoProdotto;

import java.sql.SQLException;
import java.util.Collection;

import beanProdotto.ProductBean;

import java.util.*;

public interface ProductDAO {
	
	public boolean doSave(ProductBean product) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public ProductBean doRetrieveByKey(int code) throws SQLException;
	
	public Collection<ProductBean> doRetrieveAll() throws SQLException;
	
	public boolean doUpdate(ProductBean product) throws SQLException;
	
	public List<ProductBean> doRetrieveByNome(String name);
	
	public List<ProductBean> doRetrieveByNomeOrDescrizione(String string) ;
	
	public Collection<ProductBean> doRetrieveByCategoria(String categoria) throws SQLException;
	
	public  ProductBean doLastProduct() throws SQLException;

	public boolean doUpdatePersonalizzazione(int code) throws SQLException;
	
	
	
}
