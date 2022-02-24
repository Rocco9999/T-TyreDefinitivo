package daoAgenda;

import java.sql.SQLException;
import java.util.Collection;

import beanAccount.UtenteBean;
import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanProdotto.ProductBean;



public interface AppuntamentoDAO {
	
	public Collection<AppuntamentoBean> doRetrieveAppuntamentoByFiliale(int cod_utente) throws SQLException;

	public Collection<AppuntamentoBean> doRetrieveAppuntamentoByFiliale1(int cod_utente,String data) throws SQLException;
	
	public int codice_Ordine(int cod_app) throws SQLException;
	
	public Collection<UtenteBean> doRetrieveDettagliAppuntamentoByFiliale(int cod_app) throws SQLException;
	
	public Collection<ComposizioneBean> doRetrieveDettagliAppuntamentoByFiliale1(int cod_app) throws SQLException;
	
	public Collection<ProductBean> doRetrieveDettagliAppuntamentoByFiliale2(int cod_app) throws SQLException;
	
	public int doRetrieveFiliale(String filiale) throws SQLException;
	
	public int doRetrieveQuantita(String data, String indirizzo, String ora) throws SQLException;
	
	public int doRetrieveQuantitaFinal(String data, String indirizzo, String ora, int valore) throws SQLException;
	
	public boolean doSave(AppuntamentoBean appuntamento) throws SQLException;
	
	public  AppuntamentoBean doLastAppuntamento() throws SQLException;
	
	
	
	
	
	
	
	
}
