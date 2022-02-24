package daoOrdine;

import java.sql.SQLException;

import beanOrdine.ComposizioneBean;



public interface ComposizioneDAO {
	
	public boolean doSaveComposizione(ComposizioneBean bean1) throws SQLException;

}
