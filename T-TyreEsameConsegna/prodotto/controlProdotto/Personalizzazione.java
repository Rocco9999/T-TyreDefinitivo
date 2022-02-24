package controlProdotto;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanProdotto.ProductBean;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;


@WebServlet("/Personalizzazione")

/**
 * Servlet implementation class ProductControl
 */
public class Personalizzazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static boolean isDataSource = true;
	
	static ProductDAO model= new ProductDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	
	public Personalizzazione() {
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
		
					String disponibilita="si";
					String name = request.getParameter("nome");
					String description = request.getParameter("descrizione");
					
					
					String price = (request.getParameter("prezzo"));
					String[] price1=price.split("\\.");
					int prezzo= Integer.parseInt(price1[0]);
				
					
					
					String category = request.getParameter("type");
					String photo = request.getParameter("color");
				
				
					
					//int quantity = Integer.parseInt(request.getParameter("quantity"));

					ProductBean bean = new ProductBean();
				
					bean.setName(name);
					bean.setDescription(description);
					bean.setPrice(prezzo);
					bean.setCategory(category);
					bean.setPhoto(photo);
					bean.setDisponibilita(disponibilita);
					
					
					
					try {
						model.doSave(bean);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
					 try {
						ProductBean ciao= new ProductBean();
						ciao= model.doLastProduct();
						int ultimoCodice= ciao.getCode();
						
						
						model.doUpdatePersonalizzazione(ultimoCodice);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					try {
						request.removeAttribute("codice_prodotto");
						request.setAttribute("codice_prodotto", model.doLastProduct());
						
						request.removeAttribute("product");
						request.setAttribute("product",bean);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			
					
					
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProdottoPersonalizzato.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}