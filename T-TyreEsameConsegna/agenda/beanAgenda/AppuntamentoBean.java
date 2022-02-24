package beanAgenda;

/**
 * Appuntamento class.
 */

public class AppuntamentoBean {

	/**
	 * appuntamento's ID.
	 */

	private int id;

	/**
	 * appuntamento's indirizzo.
	 */

	private String indirizzo;

	/**
	 * appuntamento's ora.
	 */

	private String ora;

	/**
	 * appuntamento's data.
	 */
	private String data;

	/**
	 * appuntamento's cod_filiale.
	 */
	private int cod_filiale;

	/**
	 * param costructor.
	 * 
	 * @param indirizzo new indirizzo
	 * @param ora       new ora
	 * @param data      new data
	 * 
	 */
	public AppuntamentoBean(String indirizzo, String ora, String data) {
		super();
		this.indirizzo = indirizzo;
		this.ora = ora;
		this.data = data;
	}

	/**
	 * param costructor.
	 * 
	 * @param id          new id
	 * @param indirizzo   new indirizzo
	 * @param ora         new ora
	 * @param data        new data
	 * @param cod_filiale new cod_filiale
	 * 
	 */

	public AppuntamentoBean(int id, String indirizzo, String ora, String data, int cod_filiale) {
		super();
		this.id = id;
		this.indirizzo = indirizzo;
		this.ora = ora;
		this.data = data;
		this.cod_filiale = cod_filiale;
	}

	/**
	 * param costructor.
	 * 
	 * @param indirizzo   new indirizzo
	 * @param ora         new ora
	 * @param data        new data
	 * @param cod_filiale new cod_filiale
	 * 
	 */
	public AppuntamentoBean(String indirizzo, String ora, String data, int cod_filiale) {
		super();
		this.indirizzo = indirizzo;
		this.ora = ora;
		this.data = data;
		this.cod_filiale = cod_filiale;
	}

	/**
	 * constructor of the class.
	 */
	public AppuntamentoBean() {

	}

	
	
	public int getCod_filiale() {
		return cod_filiale;
	}

	public void setCod_filiale(int cod_filiale) {
		this.cod_filiale = cod_filiale;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	
	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
