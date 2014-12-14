package ca.uqtr.gl.domain;

import java.util.ArrayList;
import java.util.Date;

import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.entities.Prepose;

public class RegistrePrepose {
	private static RegistrePrepose instance;
	private static ArrayList<Prepose> listePreposes;
		
	private RegistrePrepose() {
		if (listePreposes == null) {
			listePreposes = new ArrayList<Prepose>();
		}
	}
	
	public static synchronized RegistrePrepose getInstance() {
		if (instance == null) {
			instance = new RegistrePrepose();
		}
		
		return instance;
	}

	public ArrayList<Prepose> getListePreposes() {
		return listePreposes;
	}

	public void ajouterPrepose(String nom, String prenom, 
			Date dateNaissance, Adresse adresse, int noEmploye, String titre, String nomUtilisateur, String motPasse) {
		listePreposes.add(new Prepose(nom, prenom, dateNaissance, adresse, noEmploye, titre, nomUtilisateur, motPasse));
	}

	public void supprimerPrepose(Prepose p) {
		listePreposes.remove(p);
	}

	public void initListePreposes() {
		listePreposes.clear();
	}
	
	public Prepose obtenirPrepose(String nomUtilisateur) {
		for(Prepose p : listePreposes) {
			if (p.getNomUtilisateur().equalsIgnoreCase(nomUtilisateur)) {
				return p;
			}	
		}
			
		return null;
	}
}
