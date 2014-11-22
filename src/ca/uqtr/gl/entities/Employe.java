package ca.uqtr.gl.entities;

import java.util.Date;

public class Employe extends Personne implements java.io.Serializable {
	private int noEmploye;
	private String titre;
	
	public Employe(String nom, String prenom, Date dateNaissance,
			Adresse adresse, int noEmploye, String titre) {
		super(nom, prenom, dateNaissance, adresse);
		this.noEmploye = noEmploye;
		this.titre = titre;
	}

	public int getNoEmploye() {
		return noEmploye;
	}

	public void setNoEmploye(int noEmploye) {
		this.noEmploye = noEmploye;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
