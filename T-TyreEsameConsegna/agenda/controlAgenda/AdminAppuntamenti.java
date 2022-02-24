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



@WebServlet("/AdminAppuntamenti")
/**
 * Servlet implementation class ProductControl
 */
public class AdminAppuntamenti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static AppuntamentoDAO model= new AppuntamentoDAOImpl();
	
	public AdminAppuntamenti() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			int codice_utente = (int) request.getSession().getAttribute("code");

				if(request.getParameter("myDate")!=null) {
					
					int codice_utente1 = (int) request.getSession().getAttribute("code");
					
					String data=request.getParameter("myDate");
					
					
					
					
					
					try {
						request.removeAttribute("appuntamento");
						request.setAttribute("appuntamento", model.doRetrieveAppuntamentoByFiliale1(codice_utente1,data));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminAppuntamenti.jsp");
					dispatcher.forward(request, response);
					
				}
				
				
				
				
				
				
				try {
					request.removeAttribute("appuntamento");
					request.setAttribute("appuntamento", model.doRetrieveAppuntamentoByFiliale(codice_utente));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		
		
		
		
		
		String  type = (String)request.getSession().getAttribute("type");
		
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminAppuntamenti.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
	

