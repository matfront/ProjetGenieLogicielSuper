package ca.uqtr.gl.entities;

import java.util.Date;

import ca.uqtr.gl.domain.RegistreClient;

public class Client extends Personne implements java.io.Serializable {
	private int identifiant;
	private int noCarteMembre;
	private String noTelephone;
	private String courriel;
	
	public Client(String nom, String prenom, Date dateNaissance, Adresse adresse) {
		this(RegistreClient.compteurIdentifiant, RegistreClient.compteurCarteMembre, nom, prenom, dateNaissance, adresse, "", "");
	}
	
	public Client(int identifiant, int noCarteMembre, String nom, String prenom, Date dateNaissance, Adresse adresse, String noTel, String courriel) {
		super(nom, prenom, dateNaissance, adresse);
		
		this.identifiant = identifiant;
		this.noCarteMembre = noCarteMembre;
		this.noTelephone = noTel;
		this.courriel = courriel;
	}
	
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public int getNoCarteMembre() {
		return noCarteMembre;
	}

	public void setNoCarteMembre(int noCarteMembre) {
		this.noCarteMembre = noCarteMembre;
	}

	public String getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(String noTelephone) {
		this.noTelephone = noTelephone;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String obtenirNomComplet() {
		return this.getPrenom() + " " + this.getNom();
	}
}