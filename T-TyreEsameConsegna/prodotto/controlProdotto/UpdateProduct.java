package controlProdotto;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;


@WebServlet("/UpdateProduct")
/**
 * Servlet implementation class ProductControl
 */
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static boolean isDataSource = true;
	
	static ProductDAO model= new ProductDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	
	public UpdateProduct() {
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
		
		String action = request.getParameter("action");

		try {
			if (action != null) {
				
				 if (action.equalsIgnoreCase("update")) {
					int code = Integer.parseInt(request.getParameter("id"));
					
			
					
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(code));
					
				}
				
				
			}			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}


		

		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateProduct.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}