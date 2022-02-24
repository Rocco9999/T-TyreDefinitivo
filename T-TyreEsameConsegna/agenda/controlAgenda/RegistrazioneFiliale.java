package controlAgenda;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanAccount.UtenteBean;
import beanAgenda.FilialeBean;
import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;
import daoAgenda.FilialeDAO;
import daoAgenda.FilialeDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;



@WebServlet("/RegistrazioneFiliale")
public class RegistrazioneFiliale extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	static UtenteDAO model= new UtenteDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	static FilialeDAO model2= new FilialeDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
		
		
		//Inserimento Amministratore Filiale
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				
				UtenteBean user = new UtenteBean();
				user.setPassword(password);
				user.setNome(nome);
				user.setCognome(cognome);
				user.setEmail(email);
				
				
				try {
					model.doSaveADMFiliale(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				 try {
					user=model.doRetrieveCodeByEmail(email);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int codice= user.getID();
				
		
		//Inserimento Filiale
				String telefono = request.getParameter("telefono");
				String indirizzo = request.getParameter("indirizzo");
				int interventiora =Integer.parseInt( request.getParameter("interventiora"));
				String orarioChiusura = request.getParameter("orariochiusura");
				String orarioApertura = request.getParameter("orarioapertura");
		
				
				
				FilialeBean filiale= new FilialeBean();
				filiale.setTelefono(telefono);
				filiale.setIndirizzo(indirizzo);
				filiale.setN_interventiora(interventiora);
				filiale.setOrarioapertura(orarioApertura);
				filiale.setOrariochiusura(orarioChiusura);
				filiale.setCod_utente(codice);
				
				try {
					model2.doSave(filiale);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/InserimentoFilialeRiuscito.jsp");
		requestDispatcher.forward(request, response);
		
		
	}



}
