package controlAccount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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


@WebServlet("/Registrazione")
public class RegistrazioneServlet extends HttpServlet  {
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
				
				request.removeAttribute("quantita");
				request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		
		
		String password = request.getParameter("password");
		
		String nome = request.getParameter("nome");
		
		String cognome = request.getParameter("cognome");
		
		String telefono = request.getParameter("telefono");
		
		String email = request.getParameter("email");
		
		String indirizzo = request.getParameter("indirizzo");
		
		String CartaCredito = request.getParameter("CartaCredito");
		

		UtenteBean user = new UtenteBean();
		user.setNome(nome);
		user.setCognome(cognome);
		user.setIndirizzo(indirizzo);
		user.setPassword(password);
		user.setEmail(email);
		user.setTelefono(telefono);
		user.setNumero_carta(CartaCredito);
		
		model.doSave(user);
		
		/*Invio Email Registrazione*/
		// The recipient's e-mail ID
	      String to = email;
	 
	      // Sender's e-mail ID
	      String from = "felice_ferrante@outlook.it";
	      String password1 = "Online@10";
	 
	       String host = "smtp.office365.com" ;
	 
	       Properties properties = System.getProperties ();
	       properties.put("mail.smtp.starttls.enable", "true");
	       properties.put("mail.smtp.user" , from);
	       properties.put("mail.smtp.password", password1);
	       properties.put("mail.smtp.port", "587");
	       properties.put("mail.smtp.auth", "true");
	 
	       properties.setProperty ( "mail.smtp.host", host);
	       
	       Session session = Session.getDefaultInstance(properties, 
	    		    new javax.mail.Authenticator(){
	    		        protected PasswordAuthentication getPasswordAuthentication() {
	    		            return new PasswordAuthentication(
	    		                "felice_ferrante@outlook.it", "Online@10");// Specify the Username and the PassWord
	    		        }
	    		});
	 
	      //Session session = Session.getDefaultInstance (properties);
	      
		  response.setContentType ( "text / html; charset = UTF-8");
	    

	      try {
	          MimeMessage message = new MimeMessage (session);
	        
	    	  
	    	  message.setFrom (new InternetAddress (from));
	         // Set To: header field of the header.
	         message.addRecipient (Message.RecipientType.TO,
	                                  new InternetAddress (to));
	         // Set the Subject: header field
	         request.setAttribute("message", message);
	      }
	   catch (MessagingException mex) {
	      mex.printStackTrace ();
	   }
		
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("registrazioneSuccesso.jsp");
		requestDispatcher.forward(request, response);
	}



}
