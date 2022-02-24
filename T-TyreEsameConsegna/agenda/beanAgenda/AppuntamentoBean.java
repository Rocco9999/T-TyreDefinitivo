package beanAgenda;

public class AppuntamentoBean {
	
	 private int id;
	 private String indirizzo;
	 private String ora;
	 private String data;
	 private int cod_filiale;
	 
	
	 
	 
	 
	
	public AppuntamentoBean(String indirizzo, String ora, String data) {
		super();
		this.indirizzo = indirizzo;
		this.ora = ora;
		this.data = data;
	}


	public AppuntamentoBean(int id, String indirizzo, String ora, String data, int cod_filiale) {
		super();
		this.id = id;
		this.indirizzo = indirizzo;
		this.ora = ora;
		this.data = data;
		this.cod_filiale = cod_filiale;
	}


	public AppuntamentoBean(String indirizzo, String ora, String data, int cod_filiale) {
		super();
		this.indirizzo = indirizzo;
		this.ora = ora;
		this.data = data;
		this.cod_filiale = cod_filiale;
	}


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
