
package controlAgenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import daoAgenda.AppuntamentoDAO;
import daoAgenda.AppuntamentoDAOImpl;
import daoAgenda.FilialeDAO;
import daoAgenda.FilialeDAOImpl;



@WebServlet("/PrenotazioneAjax")
public class PrenotazioneAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static FilialeDAO model1 = new FilialeDAOImpl();
	static AppuntamentoDAO model2 = new AppuntamentoDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONArray prodJson = new JSONArray();
		String[] parametri = request.getParameter("ric").split(",");
		String citta = parametri[0];
		String data = parametri[1];

		if (citta != null) {

			try {

				List<String> listaOrari = model1.doRetrieveAllOrari(citta);

				int orario_apertura = Integer.parseInt((listaOrari.get(0).substring(0, 2)));
				int orario_chiusura = Integer.parseInt((listaOrari.get(1).substring(0, 2)));

				int indice = (orario_chiusura - orario_apertura);

				int[] myArray = new int[indice];

				int j = 0;
				for (int i = orario_apertura; i < orario_chiusura; i++) {

					myArray[j++] = i;
				}

				for (int p : myArray) {

					int n_orari = model2.doRetrieveQuantita(data, citta, p + ":00");

					int n_orarifinal = model2.doRetrieveQuantitaFinal(data, citta, p + ":00", n_orari);

					if (n_orarifinal == 0)
						prodJson.put(p + ":00");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
