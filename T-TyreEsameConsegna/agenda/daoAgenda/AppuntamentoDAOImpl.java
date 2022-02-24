package daoAgenda;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Collection;
import java.util.LinkedList;

import database. DriverManagerConnectionPool;
import beanAccount.UtenteBean;
import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanProdotto.ProductBean;

public class AppuntamentoDAOImpl implements AppuntamentoDAO {
	
	
	public   Collection<AppuntamentoBean> doRetrieveAppuntamentoByFiliale(int cod_utente) throws SQLException {
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AppuntamentoBean> products = new LinkedList<AppuntamentoBean>();
		
	

		String selectSQL ="SELECT * \r\n" + 
				"				FROM appuntamento INNER JOIN filiale on appuntamento.cod_filiale=filiale.id \r\n" + 
				"				where filiale.cod_utente=? AND appuntamento.esito='attesa'\r\n" + 
				"				ORDER BY appuntamento.data DESC";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, cod_utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				AppuntamentoBean app= new AppuntamentoBean();
				app.setId(rs.getInt("id"));
				app.setIndirizzo(rs.getString("indirizzo"));
				app.setOra(rs.getString("ora"));
				app.setData(rs.getString("data"));
				
				products.add(app);
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
	
	
	public   Collection<AppuntamentoBean> doRetrieveAppuntamentoByFiliale1(int cod_utente,String data) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AppuntamentoBean> products = new LinkedList<AppuntamentoBean>();
		
	

		String selectSQL ="SELECT * \r\n" + 
				"				FROM appuntamento INNER JOIN filiale on appuntamento.cod_filiale=filiale.id \r\n" + 
				"				where filiale.cod_utente=? AND appuntamento.esito='attesa'"
				+ "				AND appuntamento.data=?							\r\n";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setLong(1, cod_utente);
			preparedStatement.setString(2, data);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				AppuntamentoBean app= new AppuntamentoBean();
				app.setId(rs.getInt("id"));
				app.setIndirizzo(rs.getString("indirizzo"));
				app.setOra(rs.getString("ora"));
				app.setData(rs.getString("data"));
				
				products.add(app);
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
	
	public int codice_Ordine(int cod_app) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int quantita=0;

		String selectSQL ="SELECT ordine.cod_ordine\r\n" + 
				"				FROM "
				+ "				appuntamento"
				+ "				INNER JOIN ordine on ordine.cod_app=appuntamento.id\r\n"
				+ "				INNER JOIN utente on ordine.cod_utente=utente.ID" + 
				"				where  appuntamento.esito='attesa' and appuntamento.id=?	\r\n";


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, cod_app);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				quantita=rs.getInt("cod_ordine");
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return quantita;
	}
	
	
	public   Collection<UtenteBean> doRetrieveDettagliAppuntamentoByFiliale(int cod_app) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<UtenteBean> products = new LinkedList<UtenteBean>();
		
	

		String selectSQL ="SELECT utente.nome,utente.cognome\r\n" + 
				"				FROM "
				+ "				appuntamento"
				+ "				INNER JOIN ordine on ordine.cod_app=appuntamento.id\r\n"
				+ "				INNER JOIN utente on ordine.cod_utente=utente.ID" + 
				"				where  appuntamento.esito='attesa' and appuntamento.id=?	\r\n";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, cod_app);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				UtenteBean app= new UtenteBean();
				app.setNome(rs.getString("nome"));
				app.setCognome(rs.getString("cognome"));
			
				
				products.add(app);
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
	
public   Collection<ComposizioneBean> doRetrieveDettagliAppuntamentoByFiliale1(int cod_app) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ComposizioneBean> products = new LinkedList<ComposizioneBean>();
		
	

		String selectSQL ="SELECT composizione.quantita, composizione.prezzo_unitario, composizione.prezzo_totale\r\n" + 
				"	FROM appuntamento \r\n" + 
				"	INNER JOIN ordine on ordine.cod_app= appuntamento.id \r\n" + 
				"	INNER JOIN composizione on composizione.cod_ordine = ordine.cod_ordine	\r\n" + 
				"	where  appuntamento.esito='attesa' and appuntamento.id=?\r\n";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, cod_app);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				ComposizioneBean app= new ComposizioneBean();
				app.setQuantita(rs.getInt("quantita"));
				app.setPrezzo_unitario(rs.getFloat("prezzo_unitario"));
				app.setPrezzo_totale(rs.getFloat("prezzo_totale"));
				
				products.add(app);
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
	

public   Collection<ProductBean> doRetrieveDettagliAppuntamentoByFiliale2(int cod_app) throws SQLException {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	Collection<ProductBean> products = new LinkedList<ProductBean>();
	


	String selectSQL ="SELECT product.PHOTO, product.NAME, product.CATEGORY, product.DESCRIPTION\r\n" + 
			"				FROM appuntamento INNER JOIN filiale on appuntamento.cod_filiale=filiale.id"
			+ "				INNER JOIN utente on utente.ID= filiale.cod_utente "
			+ "				INNER JOIN ordine on ordine.cod_app=appuntamento.id"
			+ "				INNER JOIN composizione on composizione.cod_ordine = ordine.cod_ordine"
			+ "				INNER JOIN product on product.CODE= composizione.cod_prodotto			\r\n" + 
			"				where  appuntamento.esito='attesa' and appuntamento.id=?\r\n" + 
			"				ORDER BY appuntamento.data DESC";

	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, cod_app);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			
			ProductBean app= new ProductBean();
			
			app.setPhoto(rs.getString("PHOTO"));
			app.setName(rs.getString("NAME"));
			app.setCategory(rs.getString("CATEGORY"));
			app.setDescription(rs.getString("DESCRIPTION"));
			
			products.add(app);
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


	
	
	public int doRetrieveFiliale(String filiale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int codice_filiale=0;
		String selectSQL = "Select filiale.id From filiale where filiale.indirizzo=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, filiale);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				codice_filiale = rs.getInt("id");
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return codice_filiale;
	}
	
	
	public int doRetrieveQuantita(String data, String indirizzo, String ora) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int quantita = 0;

		String selectSQL = "select Count(appuntamento.ora) as orario\r\n" + "From appuntamento \r\n"
				+ "where appuntamento.indirizzo=? AND appuntamento.ora=? AND appuntamento.data=? ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, indirizzo);
			preparedStatement.setString(2, ora);
			preparedStatement.setString(3, data);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				quantita = rs.getInt("orario");
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return quantita;
	}

	public int doRetrieveQuantitaFinal(String data, String indirizzo, String ora, int valore) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int quantita = 0;

		String selectSQL = "select Count(appuntamento.ora) as orario\r\n"
				+ "From appuntamento inner join filiale on filiale.id=appuntamento.cod_filiale\r\n"
				+ "where appuntamento.indirizzo=? AND appuntamento.ora=? AND filiale.n_maxinterventiora = ? AND appuntamento.data=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, indirizzo);
			preparedStatement.setString(2, ora);
			preparedStatement.setInt(3, valore);
			preparedStatement.setString(4, data);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				quantita = rs.getInt("orario");
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return quantita;
	}


public boolean doSave(AppuntamentoBean appuntamento) throws SQLException {
		
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		
		String insertSQL = "INSERT INTO appuntamento(indirizzo, ora, data, cod_filiale)"
				+ " VALUES (?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, appuntamento.getIndirizzo());
			preparedStatement.setString(2, appuntamento.getOra());
			preparedStatement.setString(3, appuntamento.getData());
			preparedStatement.setInt(4, appuntamento.getCod_filiale());
		
			
			
			preparedStatement.executeUpdate();
			connection.commit(); //rende permanenti tutte le modifiche
			return true;
			
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		}


	public AppuntamentoBean doLastAppuntamento() throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	AppuntamentoBean bean = new AppuntamentoBean();

	String selectSQL = "SELECT * FROM appuntamento ";

	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);

	
		
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			bean.setId(rs.getInt("id"));
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

}
