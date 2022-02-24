package daoAgenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import beanAgenda.FilialeBean;
import database. DriverManagerConnectionPool;



public class FilialeDAOImpl implements FilialeDAO{

	
	public boolean doSave(FilialeBean bean1) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO filiale"
				+ " (indirizzo, recapito_telefonico, n_maxinterventiora,orario_apertura,orario_chiusura,cod_utente) VALUES ( ?, ?, ?, ?, ?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, bean1.getIndirizzo());
			preparedStatement.setString(2, bean1.getTelefono());
			preparedStatement.setInt(3, bean1.getN_interventiora());
			preparedStatement.setString(4, bean1.getOrarioapertura());
			preparedStatement.setString(5, bean1.getOrariochiusura());
			preparedStatement.setInt(6, bean1.getCod_utente());

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

	public Collection<FilialeBean> doRetrieveAllIndirizzi() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<FilialeBean> prenotazioni = new LinkedList<FilialeBean>();

		String selectSQL = "SELECT filiale.indirizzo " + "FROM filiale ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FilialeBean bean = new FilialeBean();

				bean.setIndirizzo(rs.getString("indirizzo"));
				prenotazioni.add(bean);

			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prenotazioni;
	}
	
	
	public List<String> doRetrieveAllOrari(String citta) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<String> prenotazioni = new ArrayList<>();

		String selectSQL = "SELECT filiale.orario_apertura, filiale.orario_chiusura " + "FROM filiale "
				+ "WHERE indirizzo=? ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, citta);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				/*
				 * PrenotazioneBean bean = new PrenotazioneBean();
				 * 
				 * bean.setOrario_apertura(rs.getString("orario_apertura"));
				 * bean.setOrario_chiusura(rs.getString("orario_chiusura"));
				 */
				prenotazioni.add(rs.getString("orario_apertura"));
				prenotazioni.add(rs.getString("orario_chiusura"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prenotazioni;
	}

	
	
	
}
