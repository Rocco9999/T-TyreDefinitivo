package controlProdotto;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanProdotto.Cart;
import beanProdotto.CartBean;
import beanProdotto.Item;
import beanProdotto.ProductBean;
import daoProdotto.CartDAOImpl;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;



/**
 * Servlet implementation class CartSProva
 */
@WebServlet("/CartS")

public class CartS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ProductDAO model = new ProductDAOImpl();
	static CartDAOImpl model1 = new CartDAOImpl();

	Cart cart = new Cart();
	CartBean cartbean = new CartBean();
	

	public CartS() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		if(request.getSession().getAttribute("code")!=null) {
		int codice_utente = (int) request.getSession().getAttribute("code");
		

		String action = request.getParameter("action");

		ArrayList<CartBean> cartproducts = new ArrayList<>();
		try {
			cartproducts.addAll(model1.doRetrieveAllBycart(codice_utente));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (action != null) {

				if (action.equalsIgnoreCase("addC") ) {
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					int quantita = Integer.parseInt(request.getParameter("quantity"));
					
					model1.doDeleteAllByUser(codice_utente);
					cart.addProduct(model.doRetrieveByKey(id));
					

					ArrayList<Item> prodcart = cart.getProducts();
					
					boolean var= true;
						//scrorriamo i prodotti nel database, se il prodotto è presente modifica quantita e prezzo totale
						for (CartBean prodotto : cartproducts) {
						
							if (prodotto.getCod_prodotto() == id) {
								
								
								float prezzoUnitario = prodotto.getPrezzo_unitario();
								float prezzoTotale= prezzoUnitario*quantita;
							

								model1.doDeleteProduct(id);
								
								var=false;
								
								cartbean.setQuantita(quantita);
								
								cartbean.setPrezzo_unitario(prezzoUnitario);
								cartbean.setPrezzo_totale(prezzoTotale);
								
								
								cartbean.setCod_utente(codice_utente);
								cartbean.setCod_prodotto(id);
								
								
								
								// update
								model1.doSaveCarrello(cartbean);
								
								
								
								
								}					
						}
						
						 
						//aggiungi prodotti al carrello se non presenti
						for (Item prodotti : prodcart) {
							
							if (prodotti.getCode() == id && var) {

								
								cartbean.setQuantita(quantita);

								cartbean.setPrezzo_unitario(prodotti.getUnitCost());
								
								cartbean.setPrezzo_totale(prodotti.getUnitCost()*quantita);

								cartbean.setCod_utente(codice_utente);

								cartbean.setCod_prodotto(id);

								model1.doSaveCarrello(cartbean);
								}
						}
					}

				 else 
					if (action.equalsIgnoreCase("deleteC")) {
					int id = Integer.parseInt(request.getParameter("id"));
					cart.delProduct(model.doRetrieveByKey(id));

						//scrorriamo i prodotti nel database, se il prodotto è presente modifica quantita e prezzo totale
						for (CartBean prodotto : cartproducts) {
						
							if (prodotto.getCod_prodotto() == id) {
								
								model1.doDeleteProduct(id);
								
								}					
						}
				 	}
					else 
						if (action.equalsIgnoreCase("deleteAll")) {
							model1.doDeleteAllByUser(codice_utente);
										
							}	
						 
										
				
				
				}
			
			//visualizzazione del carrello (quantita, prezzo_totale,prezzo_unitario)
			ArrayList<CartBean> cartproducts1 = new ArrayList<>();
			try {
				cartproducts1.addAll(model1.doRetrieveAllBycart(codice_utente));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//visualizzazione del carrello con i dati dei prodotti(Foto,Nome,Descrizione)
			ArrayList<ProductBean> products = new ArrayList<>();
			for (CartBean prodotto : cartproducts1) {
				products.addAll(model1.doRetrieveAllByproduct(prodotto.getCod_prodotto()));
			}
			
			
			request.removeAttribute("products");
			request.setAttribute("products",products);
			
			
			
			request.removeAttribute("cartproducts");
			request.setAttribute("cartproducts", model1.doRetrieveAllBycart(codice_utente));
			
			//Quantita di tutti i prodotti nel carrello
			try {
				request.removeAttribute("quantita");
				request.setAttribute("quantita", model1.doRetrieveQuantita(codice_utente));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		
		String type = (String) request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cart.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
