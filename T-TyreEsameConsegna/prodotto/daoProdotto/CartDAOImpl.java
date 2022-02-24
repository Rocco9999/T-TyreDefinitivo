package daoProdotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import beanProdotto.CartBean;
import beanProdotto.ProductBean;
import database. DriverManagerConnectionPool;

public class CartDAOImpl implements CartDAO {
	
	
	public ArrayList<CartBean> doRetrieveAllBycart(int codice_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<CartBean> cartproducts = new ArrayList<CartBean>();
		
		
		
		String selectSQL = "SELECT carrello.cod_prodotto, carrello.quantita, carrello.prezzo_totale, carrello.prezzo_unitario "
				+ "FROM carrello  "
				+ "WHERE  cod_utente=?";
		


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setInt(1, codice_utente);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CartBean cartbean= new CartBean();
				cartbean.setCod_prodotto(rs.getInt("cod_prodotto"));
				cartbean.setQuantita(rs.getInt("quantita"));
				cartbean.setPrezzo_totale(rs.getFloat("prezzo_totale"));
				cartbean.setPrezzo_unitario(rs.getFloat("prezzo_unitario"));
				
				
				cartproducts.add(cartbean);
			}
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return cartproducts;
	}
	
	public Collection<ProductBean> doRetrieveAllByproduct(int codice_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		
		
		String selectSQL = "SELECT product.code,product.photo, product.name "
				+ "FROM product  "
				+ "WHERE CODE =? ";
		


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setInt(1, codice_prodotto);
		
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean product= new ProductBean();
				product.setCode(rs.getInt("CODE"));
				product.setPhoto(rs.getString("PHOTO"));
				product.setName(rs.getString("NAME"));
				
				
				
				
				products.add(product);
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
	
	
	
	public boolean doUpdateProduct(int quantita,float prezzo_totale,int codice_prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE carrello SET quantita=?, prezzo_totale=?  WHERE cod_prodotto=?");
					
					
			preparedStatement.setInt(1, quantita);
			preparedStatement.setFloat(2, prezzo_totale);
			preparedStatement.setInt(3, codice_prodotto);

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
	
	

	public boolean doSaveCarrello(CartBean bean1) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO carrello"
				+ " ( quantita,prezzo_totale,prezzo_unitario,cod_prodotto,cod_utente ) VALUES ( ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, bean1.getQuantita());
			preparedStatement.setFloat(2, bean1.getPrezzo_totale());
			preparedStatement.setFloat(3, bean1.getPrezzo_unitario());
			preparedStatement.setInt(4, bean1.getCod_prodotto());
			preparedStatement.setFloat(5, bean1.getCod_utente());
		

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
	
	public Collection<CartBean> doRetrieveAll(int codice_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<CartBean> cartproducts = new LinkedList<CartBean>();

		String selectSQL = "SELECT * "
				+ "FROM carrello "
				+ "WHERE cod_utente =? ";
		


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codice_utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CartBean bean = new CartBean();

				bean.setCod_prodotto(rs.getInt("cod_prodotto"));
				bean.setCod_utente(rs.getInt("cod_utente"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzo_totale(rs.getFloat("prezzo_totale"));
				
				cartproducts.add(bean);
				
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return cartproducts;
	}
	
	public int doRetrieveQuantita(int codice_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int quantita=0;

		String selectSQL = "SELECT SUM(quantita) as quantita "
				+ "FROM carrello "
				+ "WHERE cod_utente =?";
		


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codice_utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				quantita=rs.getInt("quantita");
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
	
	public boolean doDeleteProduct(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE "
						+ "FROM CARRELLO   "
						+ "WHERE COD_PRODOTTO = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();
			connection.commit();// rende permanenti tutte le modifiche
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	
	public boolean doDeleteAllByUser(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE "
						+ "FROM CARRELLO   "
						+ "WHERE cod_utente=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();
			connection.commit();// rende permanenti tutte le modifiche
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	
}