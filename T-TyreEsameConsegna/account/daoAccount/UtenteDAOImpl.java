package daoAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beanAccount.UtenteBean;
import database. DriverManagerConnectionPool;



public class UtenteDAOImpl implements UtenteDAO {

	static final String TABLE_NAME = "utente"; //TABELLA
	
	public String doRetrieveEmail(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		String email = null;
		String selectSQL = 	"SELECT utente.email FROM utente WHERE utente.ID=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setInt(1, code);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				email = rs.getString("email");
			}
		
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return email;
	}

	
	public UtenteBean doRetrieveByUsername(String email) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					
					"SELECT utente.email FROM utente WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				UtenteBean p = new UtenteBean();
				
				p.setEmail(rs.getString(1));
				
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
public  boolean doSaveADMFiliale(UtenteBean utente) throws SQLException {
		
		String tipo="ADMFILIALE";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		
		String insertSQL = "INSERT INTO " + UtenteDAOImpl.TABLE_NAME + "(nome,cognome,email,password,tipo)"
				+ " VALUES (?,?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, utente.getNome());
			preparedStatement.setString(2, utente.getCognome());
			preparedStatement.setString(3, utente.getEmail());
			preparedStatement.setString(4, utente.getPassword());
			preparedStatement.setString(5, tipo);
			
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
	
	
	
	public boolean doSave(UtenteBean utente) {
		try (Connection con = DriverManagerConnectionPool.getConnection()) {
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO " + UtenteDAOImpl.TABLE_NAME + "(nome,cognome,telefono,indirizzo,email,password,numero_carta,tipo)"
						+ " VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				
		String tipo="NOAD";
		ps.setString(1, utente.getNome());
		ps.setString(2, utente.getCognome());
		ps.setString(3, utente.getTelefono());
		ps.setString(4, utente.getIndirizzo());
		ps.setString(5, utente.getEmail());
		ps.setString(6, utente.getPassword());
		ps.setString(7, utente.getNumero_carta());
		ps.setString(8, tipo);
	
	
		if (ps.executeUpdate() != 1) {
		throw new RuntimeException("Errore nella query di inserimento");
		}
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		utente.setID(rs.getInt(1));



		return true;
		} catch (SQLException e) {
		e.printStackTrace();
		return false;
		}



		}
	
	
	public  UtenteBean doRetrieveUtenteByUsernamePassword(String usn, String passw) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean bean = new UtenteBean();
		
	
		String selectSQL = "SELECT * FROM " + UtenteDAOImpl.TABLE_NAME + " WHERE email = ? AND password=SHA1(?)";
		
		
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, usn);
			preparedStatement.setString(2, passw);

			ResultSet rs = preparedStatement.executeQuery();

			
			
			while (rs.next()) {
				
				bean.setID(rs.getInt("ID"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setEmail(rs.getString("email"));
				
				bean.setPassword(rs.getString("password"));
				
				bean.setNumero_carta("numero_carta");
				bean.setTipo(rs.getString("tipo"));
			}
		} 
		finally{
			  try{
				 	if (preparedStatement != null)
					preparedStatement.close();
			       } 
			 	finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			      }
			  }
		
		return bean;
	}
	

	public boolean doUpdate(UtenteBean utente) throws SQLException{
		String tipo="NOAD";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE utente SET ID=?, NOME=?, COGNOME=?, TELEFONO=?, INDIRIZZO=?, EMAIL=?, PASSWORD=?, NUMERO_CARTA=?, TIPO=?  WHERE ID=?");
			preparedStatement.setInt(1, utente.getID());
			preparedStatement.setString(2, utente.getNome());
			preparedStatement.setString(3, utente.getCognome());
			preparedStatement.setString(4, utente.getTelefono());
			preparedStatement.setString(5, utente.getIndirizzo());
			preparedStatement.setString(6, utente.getEmail()); 
			preparedStatement.setString(7, utente.getPassword());
			preparedStatement.setString(8, utente.getNumero_carta());
			preparedStatement.setString(9, tipo);
			preparedStatement.setInt(10, utente.getID());
			
			preparedStatement.executeUpdate();

			connection.commit();//rende permanenti tutte le modifiche
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
		
		
	
	
	public UtenteBean doRetrieveUtenteByCode(int code) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean bean = new UtenteBean();
		
		String selectSQL = "SELECT * FROM " + UtenteDAOImpl.TABLE_NAME + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			
			
			while (rs.next()) {
				bean.setID(rs.getInt("ID"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setNumero_carta(rs.getNString("numero_carta"));
				bean.setTipo(rs.getString("tipo"));
			}
		} 
		finally{
			  try{
				 	if (preparedStatement != null)
					preparedStatement.close();
			       } 
			 	finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			      }
			  }
		
		return bean;
	}
		

	public UtenteBean doRetrieveCodeByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		UtenteBean bean = new UtenteBean();
		
		String selectSQL = "SELECT * FROM " + UtenteDAOImpl.TABLE_NAME + " WHERE EMAIL = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			
			
			while (rs.next()) {
				bean.setID(rs.getInt("ID"));
				
			}
		} 
		finally{
			  try{
				 	if (preparedStatement != null)
					preparedStatement.close();
			       } 
			 	finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			      }
			  }
		
		return bean;
	}
		
	


	
	
	


	
	
	
	
	
	
	

}