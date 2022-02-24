package beanOrdine;

public class ComposizioneBean {
	
	
	
	

	public ComposizioneBean(int cod_ordine, int quantita, float prezzo_unitario, float prezzo_totale,
			int cod_prodotto) {
		super();
		this.cod_ordine = cod_ordine;
		this.quantita = quantita;
		this.prezzo_unitario = prezzo_unitario;
		this.prezzo_totale = prezzo_totale;
		this.cod_prodotto = cod_prodotto;
	}
	
	public ComposizioneBean() {
		// TODO Auto-generated constructor stub
	}

	public int getCod_prodotto() {
		return cod_prodotto;
	}
	public void setCod_prodotto(int cod_prodotto) {
		this.cod_prodotto = cod_prodotto;
	}
	public int getCod_ordine() {
		return cod_ordine;
	}
	public void setCod_ordine(int cod_ordine) {
		this.cod_ordine = cod_ordine;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public float getPrezzo_unitario() {
		return prezzo_unitario;
	}
	public void setPrezzo_unitario(float prezzo_unitario) {
		this.prezzo_unitario = prezzo_unitario;
	}
	public float getPrezzo_totale() {
		return prezzo_totale;
	}
	public void setPrezzo_totale(float prezzo_totale) {
		this.prezzo_totale = prezzo_totale;
	}
	
	
	
	private int cod_ordine;
	private int quantita;
	private float prezzo_unitario;
	private float prezzo_totale;
	private int cod_prodotto;
	
	
	
	
	

}
