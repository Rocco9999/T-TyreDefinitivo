package controlAccount;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;

@WebServlet("/VerificaEmail")
public class VerificaEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static UtenteDAO model= new UtenteDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		response.setContentType("text/xml");
		
		if (email != null  && model.doRetrieveByUsername(email) == null) {
			response.getWriter().append("<ok/>");
		} else {
			response.getWriter().append("<no/>");
		}

	}



}
