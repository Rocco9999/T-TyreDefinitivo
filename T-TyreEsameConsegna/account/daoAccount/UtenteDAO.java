package daoAccount;

import java.sql.SQLException;

import beanAccount.UtenteBean;


public interface UtenteDAO {
	
	public String doRetrieveEmail(int code) throws SQLException;
	
	public UtenteBean doRetrieveByUsername(String email);
	
	public boolean doSaveADMFiliale(UtenteBean utente) throws SQLException;
	
	public boolean doSave(UtenteBean utente);
	
	public  UtenteBean doRetrieveUtenteByUsernamePassword(String usn, String passw) throws SQLException ;
	
	public boolean doUpdate(UtenteBean utente) throws SQLException;
	
	public  UtenteBean doRetrieveUtenteByCode(int code) throws SQLException;
	
	
	public UtenteBean doRetrieveCodeByEmail(String email) throws SQLException;

}
