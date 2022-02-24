package controlAccount;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;

@WebServlet("/UtenteForm")
/**
 * Servlet implementation class ProductControl
 */
public class DatiFormUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static boolean isDataSource = true;
	
	static UtenteDAO model= new UtenteDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	
	public DatiFormUtente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		if(request.getSession().getAttribute("code")!=null) {
			
			
			int codice_utente = (int) request.getSession().getAttribute("code");
			
			try {
				
				request.removeAttribute("quantita");
				request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
				
				request.removeAttribute("Utente");
				request.setAttribute("Utente", model.doRetrieveUtenteByCode(codice_utente));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}

			
	
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DatiUtenteForm.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}