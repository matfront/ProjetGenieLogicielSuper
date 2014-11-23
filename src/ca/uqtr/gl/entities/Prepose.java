package ca.uqtr.gl.entities;

import java.util.Date;

import ca.uqtr.gl.domain.RegistreClient;

public class Prepose extends Employe implements java.io.Serializable {
	
	private static final long serialVersionUID = -2709348413837722845L;
	
	private RegistreClient registre;

	public Prepose(RegistreClient registre, String nom, String prenom, Date dateNaissance,
			Adresse adresse, int noEmploye, String titre) {
		super(nom, prenom, dateNaissance, adresse, noEmploye, titre);
		
		this.registre = registre;
	}
}
