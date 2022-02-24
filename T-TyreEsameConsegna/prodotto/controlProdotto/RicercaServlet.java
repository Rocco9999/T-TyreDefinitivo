package controlProdotto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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





@WebServlet("/Ricerca")
public class RicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ProductDAO model = new ProductDAOImpl();
	static CartDAO model1= new CartDAOImpl();

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
		
		List<ProductBean> prodotti = model.doRetrieveByNomeOrDescrizione(request.getParameter("ric"));
		request.setAttribute("prodotti", prodotti);
		
		
		
		String  type = (String)request.getSession().getAttribute("type");
		request.setAttribute("type", type);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ricerca.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
