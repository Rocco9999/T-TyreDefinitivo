package controlAgenda;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanAgenda.AppuntamentoBean;
import daoAgenda.AppuntamentoDAO;
import daoAgenda.AppuntamentoDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;




@WebServlet("/PrenotazioneServlet")
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static CartDAO model1= new CartDAOImpl();
	static AppuntamentoDAO model2= new AppuntamentoDAOImpl();  
    
    public PrenotazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	if(request.getSession().getAttribute("code")!=null) {
		
    		int codice_utente = (int) request.getSession().getAttribute("code");
    		
    		try {
				
				request.removeAttribute("quantita");
				request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
				
				
				 String indirizzo = request.getParameter("filiale");
				 String orario=request.getParameter("orario");
				 String data= request.getParameter("myDate");
				 
				 
				
				 
				 int cod_filiale= model2.doRetrieveFiliale(indirizzo);
				
				 
				
				AppuntamentoBean app= new AppuntamentoBean();
				app.setIndirizzo(indirizzo);
				app.setOra(orario);
				app.setData(data);
				app.setCod_filiale(cod_filiale);
			
				model2.doSave(app);
							
				
	    		 request.removeAttribute("codice_appuntamento");
	    		 request.setAttribute("codice_appuntamento", model2.doLastAppuntamento());
	    		 
	    		

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    		
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./Ordine");
    		requestDispatcher.forward(request, response);
		 
		
	}
  
	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
