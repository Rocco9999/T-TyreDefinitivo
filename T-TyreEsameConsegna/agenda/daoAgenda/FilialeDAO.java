package daoAgenda;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import beanAgenda.FilialeBean;




public interface FilialeDAO {
	
	public boolean doSave(FilialeBean bean1) throws SQLException;
	
	public Collection<FilialeBean> doRetrieveAllIndirizzi() throws SQLException;
	
	public List<String> doRetrieveAllOrari(String citta) throws SQLException;
	
	

}
