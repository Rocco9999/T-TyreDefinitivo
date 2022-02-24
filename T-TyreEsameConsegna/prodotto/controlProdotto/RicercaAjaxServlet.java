
package controlProdotto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import beanProdotto.ProductBean;
import daoProdotto.ProductDAO;
import daoProdotto.ProductDAOImpl;




@WebServlet("/RicercaAjax")
public class RicercaAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ProductDAO model= new ProductDAOImpl ();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		JSONArray prodJson = new JSONArray();
		String query = request.getParameter("ric");
		if (query != null) {
			List<ProductBean> prodotti = model.doRetrieveByNome(query + "*");
			for (ProductBean p : prodotti) {
				prodJson.put(p.getName());
			}
		}
		response.setContentType("application/json");
		response.getWriter().append(prodJson.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
