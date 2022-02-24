package controlOrdine;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoOrdine.OrdineDAO;
import daoOrdine.OrdineDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;


@WebServlet("/OrdineUtente")
/**
 * Servlet implementation class ProductControl
 */
public class OrdineUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static boolean isDataSource = true;
	
	static OrdineDAO model= new OrdineDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	
	public OrdineUtente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int codice_utente = (int) request.getSession().getAttribute("code");
		
		try {
			
			request.removeAttribute("quantita");
			request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveOrdineUtente(codice_utente));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrdineUtente.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}