package controlProdotto;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanProdotto.ProductBean;
import daoProdotto.CartDAO;
import daoProdotto.CartDAOImpl;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;




/**
 * Servlet implementation class ProductControl
 */
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ProductDAO model= new ProductDAOImpl();
	static CartDAO model1= new CartDAOImpl();
	
	public ProductControl() {
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
				
				 if (action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
				
					
				} else if (action.equalsIgnoreCase("insert")) {
					String name = request.getParameter("name");
					String description = request.getParameter("description");
					int price = Integer.parseInt(request.getParameter("price"));
					String category = request.getParameter("category");
					String photo = request.getParameter("photo");
					//int quantity = Integer.parseInt(request.getParameter("quantity"));

					ProductBean bean = new ProductBean();
				
					bean.setName(name);
					bean.setDescription(description);
					bean.setPrice(price);
					bean.setCategory(category);
					bean.setPhoto(photo);
					
					//OPERAZIONI DEL PRODUCT BEAN
					model.doSave(bean);
				}
				else if (action.equalsIgnoreCase("update")) {
					int code = Integer.parseInt(request.getParameter("code"));
					String name = request.getParameter("name");
					String description = request.getParameter("description");
					int price = Integer.parseInt(request.getParameter("price"));
					//int quantity = Integer.parseInt(request.getParameter("quantity"));

					ProductBean bean = new ProductBean();
					bean.setCode(code);
					bean.setName(name);
					bean.setDescription(description);
					bean.setPrice(price);
					//OPERAZIONI DEL PRODUCT BEAN
					model.doUpdate(bean);
				}
				
				
			}			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}


		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll());
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-prodotti.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}