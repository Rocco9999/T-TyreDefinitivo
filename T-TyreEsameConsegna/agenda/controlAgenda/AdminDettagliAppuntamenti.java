package controlAgenda;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoAgenda.AppuntamentoDAO;
import daoAgenda.AppuntamentoDAOImpl;


@WebServlet("/AdminDettagliAppuntamenti")
/**
 * Servlet implementation class ProductControl
 */
public class AdminDettagliAppuntamenti extends HttpServlet {
	private static final long serialVersionUID = 1L;


	static AppuntamentoDAO model= new AppuntamentoDAOImpl();
	public AdminDettagliAppuntamenti() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
				
				String action = request.getParameter("action");
				
				if (action != null) {
					if (action.equalsIgnoreCase("get")) {
					int cod_app = Integer.parseInt(request.getParameter("id"));
						
				
						
				
				try {
					request.removeAttribute("dettagliappuntamentoUtente");
					request.setAttribute("dettagliappuntamentoUtente", model.doRetrieveDettagliAppuntamentoByFiliale(cod_app));
					
					request.removeAttribute("dettagliappuntamentoComposizione");
					request.setAttribute("dettagliappuntamentoComposizione", model.doRetrieveDettagliAppuntamentoByFiliale1(cod_app));
					
					
					request.removeAttribute("dettagliappuntamentoProduct");
					request.setAttribute("dettagliappuntamentoProduct", model.doRetrieveDettagliAppuntamentoByFiliale2(cod_app));
					
					request.removeAttribute("cod_ordine");
					request.setAttribute("cod_ordine", model.codice_Ordine(cod_app));

					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
								
				
				
					}		
			} 
	
		String  type = (String)request.getSession().getAttribute("type");
		
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminDettagliAppuntamenti.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
	

