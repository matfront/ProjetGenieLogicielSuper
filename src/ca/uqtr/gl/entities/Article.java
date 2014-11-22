package ca.uqtr.gl.entities;

public class Article implements java.io.Serializable {
	private String code;
	private String description;
	private double longeur;
	private double largeur;
	private double hauteur;
	private double prix;
	private double qteInventaire;
	private double fraisDouane;
	private String provenance;
	
	
	/*
	public Article(String nom, String prenom, Date dateNaissance, Adresse adresse) {
		this(RegistreClient.compteurIdentifiant, "", nom, prenom, dateNaissance, adresse, "", "");
	}
	*/
	public Article(String code, String description, double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, String provenance) {
	
		this.code = code;
		this.description = description;
		this.longeur = longeur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.prix = prix;
		this.qteInventaire = qte;
		this.fraisDouane  = fraisDouane;
		this.provenance = provenance;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongeur() {
		return longeur;
	}

	public void setLongeur(double longeur) {
		this.longeur = longeur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double Largeur) {
		this.largeur = Largeur;
	}
	
	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public double getQteInventaire() {
		return qteInventaire;
	}

	public void setQteInventaire(double qte) {
		this.qteInventaire = qte;
	}
	
	public double getFraisDouane() {
		return fraisDouane;
	}

	public void setFraisDouane(double fraisDouane) {
		this.fraisDouane = fraisDouane;
	}
	
	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String Provenance) {
		this.provenance = Provenance;
	}

}