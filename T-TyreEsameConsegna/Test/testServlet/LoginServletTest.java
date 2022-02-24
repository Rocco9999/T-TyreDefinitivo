package testServlet;



import org.junit.Test;
import org.mockito.Mockito;

import beanAccount.UtenteBean;
import controlAccount.LoginServlet;
import daoAccount.UtenteDAO;
import daoAccount.UtenteDAOImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;


import static org.mockito.Mockito.*;


public class LoginServletTest {
    UtenteDAO accountDAO = Mockito.mock(UtenteDAO.class) ;
    UtenteBean a = new UtenteBean("clientName", "clientSurname","332","hismail@italy.com","hispassword1",0);

    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    UtenteDAOImpl accountService = Mockito.mock(UtenteDAOImpl.class);

    @Test
    public void doPostTrue() throws ServletException, IOException, ExecutionException, InterruptedException, SQLException {

        Mockito.when(request.getParameter("username")).thenReturn("felice_ferrante@outlook.it");
        Mockito.when(request.getParameter("password")).thenReturn("Online@10");

        
        
        UtenteBean utente=new UtenteBean(2,"Felice","Ferrante", "3342396308","Via Nuova Sarno 354", "felice_ferrante@outlook.it",
    			"481401f79a08e2d5e349f5d2c1af7f9c53004776", "4023657895412593");
        
        Mockito.when(accountService.doRetrieveUtenteByUsernamePassword(anyString(),anyString()  ))
        .thenReturn(utente);

        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);

        doNothing().when(session).removeAttribute(anyString());
        doNothing().when(session).setAttribute(anyString(),any());
        doNothing().when(response).sendRedirect(anyString());

        
      

        new LoginServlet().doPost(request, response);

    }



}
