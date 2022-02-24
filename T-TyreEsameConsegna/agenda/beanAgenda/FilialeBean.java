package beanAgenda;

public class FilialeBean {

	
	private String indirizzo;
	private String telefono;
	private int n_interventiora;
	private String orarioapertura;
	private String orariochiusura;
	private int cod_utente;
	
	
	public FilialeBean() {
		super();
	}
	public FilialeBean(String indirizzo, String telefono, int n_interventiora, String orarioapertura,
			String orariochiusura, int cod_utente) {
		super();
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.n_interventiora = n_interventiora;
		this.orarioapertura = orarioapertura;
		this.orariochiusura = orariochiusura;
		this.cod_utente = cod_utente;
	}
	public int getCod_utente() {
		return cod_utente;
	}
	public void setCod_utente(int cod_utente) {
		this.cod_utente = cod_utente;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getN_interventiora() {
		return n_interventiora;
	}
	public void setN_interventiora(int n_interventiora) {
		this.n_interventiora = n_interventiora;
	}
	public String getOrarioapertura() {
		return orarioapertura;
	}
	public void setOrarioapertura(String orarioapertura) {
		this.orarioapertura = orarioapertura;
	}
	public String getOrariochiusura() {
		return orariochiusura;
	}
	public void setOrariochiusura(String orariochiusura) {
		this.orariochiusura = orariochiusura;
	}
	
	
	
}
