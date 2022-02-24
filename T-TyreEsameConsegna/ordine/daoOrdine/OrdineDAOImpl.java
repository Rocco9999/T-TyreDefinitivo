package daoOrdine;
import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanOrdine.OrdineBean;
import beanProdotto.ProductBean;

import java.sql.Connection;

import database.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.*;

public class OrdineDAOImpl implements OrdineDAO {

	static final String TABLE_NAME = "ordine";
	
	
	public boolean updateEsito(String esito, int cod_ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(
				"UPDATE ordine SET esito=? WHERE cod_ordine=?");
			
				
		
			preparedStatement.setString(1, esito);
			preparedStatement.setInt(2, cod_ordine);

			preparedStatement.executeUpdate();

			connection.commit();// rende permanenti tutte le modifiche
			return true;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

	}

	public OrdineBean doLastOrdine(int codice_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		OrdineBean bean = new OrdineBean();

		String selectSQL = "SELECT * FROM ordine where cod_utente=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codice_utente);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCode(rs.getInt("cod_ordine"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	public boolean doSave(OrdineBean ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO ordine" + " ( importo, data_ordine, cod_utente,cod_app,scelta_pagamento ) VALUES ( ?, ?, ?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setFloat(1, ordine.getImporto());
			preparedStatement.setString(2, ordine.getData_ordine());
			preparedStatement.setInt(3, ordine.getCod_utente());
			preparedStatement.setInt(4, ordine.getCod_app());
			preparedStatement.setString(5, ordine.getScelta_pagamento());
			
		
		
			preparedStatement.executeUpdate();

			connection.commit();// rende permanenti tutte le modifiche
			return true;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}



	public Collection<OrdineBean> doRetrieveOrdineUtente(int codice_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> products = new LinkedList<OrdineBean>();

		String selectSQL = "SELECT * FROM utente INNER JOIN  ordine ON utente.ID = ordine.cod_utente WHERE cod_utente =? ";


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codice_utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setCode(rs.getInt("cod_ordine"));
				bean.setImporto(rs.getFloat("importo"));
				bean.setData_ordine(rs.getString("data_ordine"));
				bean.setCod_app(rs.getInt("cod_app"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}

	public Collection<AppuntamentoBean> doRetrieveOrdineDettagliAppuntamento(int cod_app) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AppuntamentoBean> app = new LinkedList<AppuntamentoBean>();

		String selectSQL = "SELECT appuntamento.indirizzo, appuntamento.data, appuntamento.ora\r\n"
				+ "FROM ordine INNER JOIN appuntamento on ordine.cod_app = appuntamento.id\r\n"
				+ "where ordine.cod_app=?";
				

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, cod_app);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				AppuntamentoBean beanapp = new AppuntamentoBean();
				beanapp.setIndirizzo(rs.getString("indirizzo"));
				beanapp.setData(rs.getString("data"));
				beanapp.setOra(rs.getString("ora"));
				
				

				app.add(beanapp);

			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return app;
	}
	
	
	public Collection<ProductBean> doRetrieveOrdineDettagliProdotto(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProductBean> products = new LinkedList<ProductBean>();

		String selectSQL = "SELECT product.PHOTO, product.NAME\r\n"
				+ "FROM composizione INNER JOIN product on product.CODE= composizione.cod_prodotto\r\n"
				+ "INNER JOIN ordine on ordine.cod_ordine= composizione.cod_ordine\r\n" + "where ordine.cod_ordine= ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				ProductBean beanProdotto = new ProductBean();
				beanProdotto.setPhoto(rs.getString("PHOTO"));
				beanProdotto.setName(rs.getString("NAME"));

				products.add(beanProdotto);

			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}

	public Collection<ComposizioneBean> doRetrieveOrdineDettagliOrdine(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ComposizioneBean> products = new LinkedList<ComposizioneBean>();

		String selectSQL = "SELECT composizione.prezzo_unitario, composizione.prezzo_totale, composizione.quantita \r\n"
				+ "				 FROM composizione INNER JOIN product on product.CODE= composizione.cod_prodotto\r\n"
				+ "				INNER JOIN ordine on ordine.cod_ordine= composizione.cod_ordine"
				+ "                where ordine.cod_ordine= ? ";
			
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				ComposizioneBean beanComposizione = new ComposizioneBean();
				beanComposizione.setPrezzo_unitario(rs.getFloat("prezzo_unitario"));
				beanComposizione.setPrezzo_totale(rs.getFloat("prezzo_totale"));
				beanComposizione.setQuantita(rs.getInt("quantita"));

				products.add(beanComposizione);

			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public String doRetrieveEsito(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String esito=null;

		String selectSQL = "SELECT ordine.esito \r\n"
				+ "				 FROM ordine "
				+ "                where ordine.cod_ordine= ? ";
			
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				esito=rs.getNString("esito");

			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return esito;
	}

	

	
	



}
