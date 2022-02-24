package daoOrdine;

import java.sql.Connection;
import database. DriverManagerConnectionPool;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beanOrdine.ComposizioneBean;

public class ComposizioneDAOImpl implements ComposizioneDAO {

	
	public boolean doSaveComposizione(ComposizioneBean bean1) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO composizione"
				+ " ( cod_prodotto, cod_ordine, quantita,prezzo_unitario, prezzo_totale ) VALUES ( ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, bean1.getCod_prodotto());
			preparedStatement.setInt(2, bean1.getCod_ordine());
			preparedStatement.setInt(3, bean1.getQuantita());
			preparedStatement.setFloat(4, bean1.getPrezzo_unitario());
			preparedStatement.setFloat(5, bean1.getPrezzo_totale());

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

	
	
	
	
	
}
