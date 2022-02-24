package controlAgenda;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoAgenda.FilialeDAO;
import daoAgenda.FilialeDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;




@WebServlet("/Prenotazione")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static CartDAO model1= new CartDAOImpl();
	static FilialeDAO model2= new FilialeDAOImpl();
       
    
    
    public Prenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice_utente = (int) request.getSession().getAttribute("code");
		
		try {
			
			request.removeAttribute("quantita");
			request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		
		try {
			request.removeAttribute("indirizzi");
			request.setAttribute("indirizzi", model2.doRetrieveAllIndirizzi());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		String type = (String) request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Prenotazione.jsp");
		dispatcher.forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
