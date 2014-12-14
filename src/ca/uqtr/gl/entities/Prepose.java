package ca.uqtr.gl.entities;

import java.util.Date;

import ca.uqtr.gl.domain.RegistreClient;

public class Prepose extends Employe implements java.io.Serializable {
	
	private static final long serialVersionUID = -2709348413837722845L;
	
	private String nomUtilisateur;
	private String motPasse;
	
	public Prepose(String nom, String prenom, Date dateNaissance,
			Adresse adresse, int noEmploye, String titre, String nomUtilisateur, String motPasse) {
		super(nom, prenom, dateNaissance, adresse, noEmploye, titre);
		
		this.nomUtilisateur = nomUtilisateur;
		this.motPasse = motPasse;
	}
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
}
