package beanAccount;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtenteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String nome;
	private String cognome;
	private String telefono;
	private String indirizzo;
	private String email;
	private String password;
	private String numero_carta;
	private String tipo;


	
	
	/* 
	 * 
	 * */
	public UtenteBean(String nome, String cognome, String telefono, String email, String password,int ID) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.ID=ID;
	}
	public UtenteBean(int iD, String nome, String cognome, String telefono, String indirizzo, String email,
			String password, String numero_carta) {
		super();
		ID = iD;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.email = email;
		this.password = password;
		this.numero_carta = numero_carta;
	}
	public UtenteBean(String nome, String cognome, String email, String password) {
		super();
		
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	
	}
	public UtenteBean() {
		super();
	}
	public UtenteBean(String nome, String cognome, String telefono, String indirizzo, String email,
			String password, String numero_carta) {
		super();
	
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.email = email;
		this.password = password;
		this.numero_carta = numero_carta;
	
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public String getPasswordhash() {
		return password;
	}

	public void setPasswordhash(String passwordhash) {
		this.password = passwordhash;
	}
	
	public void setPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(password.getBytes(StandardCharsets.UTF_8));
			this.password = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	public String getNumero_carta() {
		return numero_carta;
	}
	public void setNumero_carta(String numero_carta) {
		this.numero_carta = numero_carta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

	
	

	
	
	

}