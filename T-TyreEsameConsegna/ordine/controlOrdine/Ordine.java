package controlOrdine;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

import beanAgenda.AppuntamentoBean;
import beanOrdine.ComposizioneBean;
import beanOrdine.OrdineBean;
import beanProdotto.CartBean;
import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;
import daoOrdine.ComposizioneDAO;
import daoOrdine.ComposizioneDAOImpl;
import daoOrdine.OrdineDAO;
import daoOrdine.OrdineDAOImpl;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;



@WebServlet("/Ordine")
/**
 * Servlet implementation class Ordine
 */
public class Ordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	static CartDAO model1= new CartDAOImpl();
	static OrdineDAO model2= new OrdineDAOImpl();
	static ComposizioneDAO model3= new ComposizioneDAOImpl();
	static UtenteDAO model4= new UtenteDAOImpl();
	
	public Ordine() {
		super();
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
		


		try {
								
					ArrayList<CartBean> carrello= model1.doRetrieveAllBycart(codice_utente);
					ComposizioneBean bean1 = new ComposizioneBean();
					float totale=0;
					
					
			
					for(CartBean carrellodb: carrello) {
					
						totale+=carrellodb.getPrezzo_totale();
						
					}
					
					//Ordineee
					OrdineBean bean = new OrdineBean();
					AppuntamentoBean app1= (AppuntamentoBean) request.getAttribute("codice_appuntamento");
					 
					LocalDate todaysDate = LocalDate.now();
					String pagamento= request.getParameter("sesso");

					bean.setImporto(totale);
					bean.setData_ordine(todaysDate.toString());
					bean.setCod_app(app1.getId());
					bean.setScelta_pagamento(pagamento);

					
					bean.setCod_utente(codice_utente);

					// OPERAZIONI DEL PRODUCT BEAN
					model2.doSave(bean);
					
					
					for(CartBean carrellodb: carrello) {
						
						//Composizione Bean
						int quantita = carrellodb.getQuantita();
						int codice_prodotto = carrellodb.getCod_prodotto();
						float prezzo_unitario = carrellodb.getPrezzo_unitario();
						float prezzo_totale = carrellodb.getPrezzo_totale();
						
						
					
						
						
						
						OrdineBean value = new OrdineBean();
						value = model2.doLastOrdine(codice_utente);
						
						System.out.println(value.getCode());

						bean1.setQuantita(quantita);
						bean1.setCod_prodotto(codice_prodotto);
						bean1.setCod_ordine(value.getCode());
						bean1.setPrezzo_unitario(prezzo_unitario);
						bean1.setPrezzo_totale(prezzo_totale);
						model3.doSaveComposizione(bean1);
					
					}
					
					
							
					
					model1.doDeleteAllByUser(codice_utente);
					
					

					
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		request.getSession().setAttribute("cart", null);

		String type = (String) request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		/*Invio Email Registrazione*/
		// The recipient's e-mail ID
	     
		try {
			 String to= model4.doRetrieveEmail(codice_utente);
		
	 
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
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ordine.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
