package controlAccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanAccount.UtenteBean;
import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;

@WebServlet("/DatiUtente")
public class DatiUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static UtenteDAO model= new UtenteDAOImpl();
	static CartDAO model1= new CartDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	if(request.getSession().getAttribute("code")!=null) {
			
			
			int codice_utente = (int) request.getSession().getAttribute("code");
			
			try {
				
				
				String password = request.getParameter("password");

				String nome = request.getParameter("nome");
				
				String cognome = request.getParameter("cognome");
				
				String telefono = request.getParameter("telefono");
				
				String email = request.getParameter("email");
				
				String indirizzo = request.getParameter("indirizzo");
				
				String CartaCredito = request.getParameter("CartaCredito");

				
				
				UtenteBean user = new UtenteBean();
				user.setID(codice_utente);
				user.setNome(nome);
				user.setCognome(cognome);
				user.setIndirizzo(indirizzo);
				user.setPassword(password);
				user.setEmail(email);
				user.setTelefono(telefono);
				user.setNumero_carta(CartaCredito);
				
			
				model.doUpdate(user);
				
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
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("DatiUtenteSuccesso.jsp");
		requestDispatcher.forward(request, response);
	}



}
