package beanProdotto;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private  String name;
	private String description;
	private double price;
	private String category;
	private String photo;
	private String disponibilita;
	private String personalizzazione;
	
	
	
	
	
	public ProductBean(String name, String description, double price, String category, String photo,
			String disponibilita) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.photo = photo;
		this.disponibilita = disponibilita;
	}

	
	

	public ProductBean(int code, String name, String description, double price, String category, String photo) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.photo = photo;
	}




	public String getPersonalizzazione() {
		return personalizzazione;
	}
	

	public void setPersonalizzazione(String personalizzazione) {
		this.personalizzazione = personalizzazione;
	}

	public String getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(String disponibilita) {
		this.disponibilita = disponibilita;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ProductBean() {
		code = -1;
		name = "";
		description = "";
		category = "";
		photo = "";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String categotry) {
		this.category = categotry;
	}

}
