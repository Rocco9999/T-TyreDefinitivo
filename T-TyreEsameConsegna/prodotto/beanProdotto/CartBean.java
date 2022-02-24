package beanProdotto;

public class CartBean {

	private int quantita;
	private float prezzo_totale;
	private float prezzo_unitario;
	private int cod_prodotto;
	private int cod_utente;
	
	
	

	


	public CartBean(int quantita, float prezzo_totale, float prezzo_unitario, int cod_prodotto, int cod_utente) {
		super();
		this.quantita = quantita;
		this.prezzo_totale = prezzo_totale;
		this.prezzo_unitario = prezzo_unitario;
		this.cod_prodotto = cod_prodotto;
		this.cod_utente = cod_utente;
	}


	public CartBean () {
		
	}
	
	
	public float getPrezzo_unitario() {
		return prezzo_unitario;
	}

	public void setPrezzo_unitario(double d) {
		this.prezzo_unitario = (float) d;
	}
	
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public float getPrezzo_totale() {
		return prezzo_totale;
	}
	public void setPrezzo_totale(double d) {
		this.prezzo_totale = (float) d;
	}
	public int getCod_prodotto() {
		return cod_prodotto;
	}
	public void setCod_prodotto(int cod_prodotto) {
		this.cod_prodotto = cod_prodotto;
	}
	public int getCod_utente() {
		return cod_utente;
	}
	public void setCod_utente(int cod_utente) {
		this.cod_utente = cod_utente;
	}
	
	 
	
	
}
