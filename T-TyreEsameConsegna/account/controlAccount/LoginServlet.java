package controlAccount;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanAccount.UtenteBean;
import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LLogin")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static UtenteDAO model = new UtenteDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
		
			
			
			String redirectedPage;
			
			try {
				
				
				
				UtenteBean user= model.doRetrieveUtenteByUsernamePassword(username,password);
				
				
				if(user.getEmail().equals(username )) {
					//Se l'autenticazione va a buon fine 
					//Recupero la sessione
					
					
					HttpSession oldSession = request.getSession();
					if(oldSession!=null) { //Se esiste una sessione la invalida
						oldSession.invalidate(); 
					}
					
					
					HttpSession currentSession = request.getSession();//crea una nuova sessione
					
					currentSession.setAttribute("user",user.getNome());
					currentSession.setAttribute("type",user.getTipo());
					currentSession.setAttribute("code",user.getID());
					currentSession.setAttribute("password",password);
					
					
					
					//currentSession.setMaxInactiveInterval(60*100);
					
					if(user.getTipo().equals("ADMFILIALE")) {
						redirectedPage = "/adminFiliale-page.jsp";}
						else redirectedPage = "/Home";
					
					if(user.getTipo().equals("adm")) {
						redirectedPage = "/admin-page.jsp";}
						
					
					response.sendRedirect(request.getContextPath() + redirectedPage);
					
				
					
				}else {
					//AUTENTICAZIONE FALLITA
					redirectedPage = "/ErrorLogin.jsp";
					response.sendRedirect(request.getContextPath() + redirectedPage);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				redirectedPage = "/ErrorLogin.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			
		}
	}
	
	
	
}