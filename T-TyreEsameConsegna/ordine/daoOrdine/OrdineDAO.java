package daoOrdine;

import java.sql.SQLException;
import java.util.Collection;

import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanOrdine.OrdineBean;
import beanProdotto.ProductBean;



public interface OrdineDAO {
	
	public boolean updateEsito(String esito, int cod_ordine) throws SQLException;
	
	public OrdineBean doLastOrdine(int codice_utente) throws SQLException;
	
	public boolean doSave(OrdineBean ordine) throws SQLException;
	
	public Collection<OrdineBean> doRetrieveOrdineUtente(int codice_utente) throws SQLException;
	
	public Collection<AppuntamentoBean> doRetrieveOrdineDettagliAppuntamento(int cod_app) throws SQLException;
	
	public Collection<ProductBean> doRetrieveOrdineDettagliProdotto(int id) throws SQLException;
	
	public Collection<ComposizioneBean> doRetrieveOrdineDettagliOrdine(int id) throws SQLException;
	
	public String doRetrieveEsito(int id) throws SQLException;
	
	
}
