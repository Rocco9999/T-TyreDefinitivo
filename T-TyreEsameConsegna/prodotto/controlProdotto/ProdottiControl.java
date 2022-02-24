package controlProdotto;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;



@WebServlet("/ProdottiControl")
/**
 * Servlet implementation class ProductControl
 */
public class ProdottiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static boolean isDataSource = true;
	
	static ProductDAO model= new ProductDAOImpl();
	
	static CartDAO model1= new CartDAOImpl();
	
	public ProdottiControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		

		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll());
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
	
		if(request.getSession().getAttribute("code")!=null) {

		int codice_utente = (int) request.getSession().getAttribute("code");
		
		try {
			
			request.removeAttribute("quantita");
			request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
		
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodotti.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
	

