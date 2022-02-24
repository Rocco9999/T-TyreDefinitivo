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


@WebServlet("/DettagliOrdine")
/**
 * Servlet implementation class ProductControl
 */
public class DettagliOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	static OrdineDAO model= new OrdineDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	
	public DettagliOrdine() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		if(request.getParameter("sesso")!=null) {
			
			String esito=request.getParameter("sesso");
		
			
			
			int cod_ordine =Integer.parseInt(request.getParameter("sessi"));
			
			
			try {
				model.updateEsito(esito,cod_ordine);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminAppuntamenti");
			dispatcher.forward(request, response);
		
		}
		else {
			
		
		int codice_utente = (int) request.getSession().getAttribute("code");
		
		try {
			
			request.removeAttribute("quantita");
			request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		String action = request.getParameter("action");
		if (action != null) {
			
			if (action.equalsIgnoreCase("view")) {
				int id = Integer.parseInt(request.getParameter("id"));
				int cod_app = Integer.parseInt(request.getParameter("cod"));
				
				try {
					
	
					
					request.setAttribute("products", model.doRetrieveOrdineDettagliProdotto(id));
					request.setAttribute("products1", model.doRetrieveOrdineDettagliOrdine(id));
					request.setAttribute("esito", model.doRetrieveEsito(id));
					request.setAttribute("appuntamento", model.doRetrieveOrdineDettagliAppuntamento(cod_app));
				
					
				} catch (SQLException e) {
					System.out.println("Error:" + e.getMessage());
				}

			}
		}
		
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DettagliOrdine.jsp");
		dispatcher.forward(request, response);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}