package beanOrdine;

import java.io.Serializable;


public class OrdineBean implements Serializable {
	
private static final long serialVersionUID = 1L;
   
	private int code;
	private float importo;
	private String data_ordine;
	private int cod_utente;
	private int cod_app;
	private String scelta_pagamento;
	private String esito;
	
	
	
	public OrdineBean() {
		super();
	}
	public OrdineBean(float importo, String data_ordine, int cod_utente, int cod_app, String scelta_pagamento) {
		super();
		this.importo = importo;
		this.data_ordine = data_ordine;
		this.cod_utente = cod_utente;
		this.cod_app = cod_app;
		this.scelta_pagamento = scelta_pagamento;
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	public String getScelta_pagamento() {
		return scelta_pagamento;
	}
	public void setScelta_pagamento(String scelta_pagamento) {
		this.scelta_pagamento = scelta_pagamento;
	}
	public int getCod_app() {
		return cod_app;
	}
	public void setCod_app(int cod_app) {
		this.cod_app = cod_app;
	}
	public int getCod_utente() {
		return cod_utente;
	}
	public void setCod_utente(int cod_utente) {
		this.cod_utente = cod_utente;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public float getImporto() {
		return importo;
	}
	public void setImporto(float importo) {
		this.importo = importo;
	}
	public String getData_ordine() {
		return data_ordine;
	}
	public void setData_ordine(String data_ordine) {
		this.data_ordine = data_ordine;
	}
}