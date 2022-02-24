package beanAccount;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Account class.
 */

public class UtenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * user's ID.
	 */
	private int ID;
	/**
	 * user's nome.
	 */
	private String nome;
	/**
	 * user's cognome.
	 */
	private String cognome;
	/**
	 * user's telefono.
	 */
	private String telefono;
	/**
	 * user's indirizzo.
	 */
	private String indirizzo;
	/**
	 * user's email.
	 */
	private String email;
	/**
	 * user's password.
	 */
	private String password;
	/**
	 * user's numero_carta.
	 */
	private String numero_carta;
	/**
	 * user's tipo.
	 */
	private String tipo;

	/**
	 * param costructor.
	 * 
	 * @param nome     new nome
	 * @param cognome  new cognome
	 * @param telefono new telefono
	 * @param email    new email
	 * @param password new passowrd
	 * @param ID       new ID
	 */

	public UtenteBean(String nome, String cognome, String telefono, String email, String password, int ID) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.ID = ID;
	}

	/**
	 * param costructor.
	 * 
	 * @param ID           new ID
	 * @param nome         new nome
	 * @param cognome      new cognome
	 * @param telefono     new telefono
	 * @param telefono     new indirizzo
	 * @param email        new email
	 * @param password     new passowrd
	 * @param numero_carta new numero_carta
	 */
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

	/**
	 * param costructor.
	 * 
	 * @param nome     new nome
	 * @param cognome  new cognome
	 * @param email    new email
	 * @param password new passowrd
	 */
	public UtenteBean(String nome, String cognome, String email, String password) {
		super();

		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;

	}

	/**
	 * param costructor.
	 * 
	 * @param ID           new ID
	 * @param nome         new nome
	 * @param cognome      new cognome
	 * @param telefono     new telefono
	 * @param telefono     new indirizzo
	 * @param email        new email
	 * @param password     new passowrd
	 * @param numero_carta new numero_carta
	 */

	/**
	 * constructor of the class.
	 */
	public UtenteBean() {
		super();
	}

	/**
	 * param costructor.
	 * 
	 * @param nome         new nome
	 * @param cognome      new cognome
	 * @param telefono     new telefono
	 * @param telefono     new indirizzo
	 * @param email        new email
	 * @param password     new passowrd
	 * @param numero_carta new numero_carta
	 */
	public UtenteBean(String nome, String cognome, String telefono, String indirizzo, String email, String password,
			String numero_carta) {
		super();

		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.email = email;
		this.password = password;
		this.numero_carta = numero_carta;
	}

	/**
	 * method for get the ID.
	 * 
	 * @return ID of the user
	 */
	public int getID() {
		return ID;
	}

	/**
	 * method for set the iD.
	 * 
	 * @param newID Id
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * method for get the nome.
	 * 
	 * @return nome of the user
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * method for set the nome.
	 * 
	 * @param nome new name
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * method for get the surname.
	 * 
	 * @return surname of the user
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * method for set the surname.
	 * 
	 * @param newsurname surname
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * method for get the phone.
	 * 
	 * @return phone of the user
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * method for set the phone.
	 * 
	 * @param newphone name
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * method for get the indirizzo.
	 * 
	 * @return indirizzo of the user
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * method for set the indirizzo.
	 * 
	 * @param newindirizzo indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * method for get the email.
	 * 
	 * @return Email of the user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * method for set the email.
	 * 
	 * @param newemail email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * method for get the password.
	 * 
	 * @return password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * method for get the password.
	 * 
	 * @return password of the user
	 */
	public String getPasswordhash() {
		return password;
	}

	/**
	 * method for set the password.
	 * 
	 * @param newpassword name
	 */
	public void setPasswordhash(String passwordhash) {
		this.password = passwordhash;
	}

	/**
	 * method for set the password.
	 * 
	 * @param newpassword password
	 */
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

	/**
	 * method for get the numero carta.
	 * 
	 * @return number of cart of the user
	 */
	public String getNumero_carta() {
		return numero_carta;
	}

	/**
	 * method for set the numbero carta.
	 * 
	 * @param newnumbercart n
	 */
	public void setNumero_carta(String numero_carta) {
		this.numero_carta = numero_carta;
	}

	/**
	 * method for get the type.
	 * 
	 * @return type of the user
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * method for set the tipo.
	 * 
	 * @param newtype type
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}