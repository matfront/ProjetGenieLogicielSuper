package ca.uqtr.gl.controllers;

import java.util.Date;

import ca.uqtr.gl.domain.RegistreClient;
import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Client;

public class ControlleurClients {
	
	private static RegistreClient registreClient;

	public ControlleurClients() {
		registreClient = new RegistreClient();
	}
	
	public Client obtenirClient(int identifiant) {
		return registreClient.obtenirClient(identifiant);
	}
	
	public Client obtenirClientParNoCarteMembre(int noCarteMembre) {
		return registreClient.obtenirClientParNoCarteMembre(noCarteMembre);
	}
	
	public Client obtenirDernierClient() {
		return registreClient.getListeClients().get(registreClient.getListeClients().size()-1);
	}
	
	public void ajouter(String nom, String prenom, Date dateNaissance, Adresse adresse, String noTel, String courriel) {
		registreClient.ajouterClient(nom, prenom, dateNaissance, adresse, noTel, courriel);
	}

	public void supprimer(Client c) {
		registreClient.supprimerClient(c);
	}

	public void modifier(Client c, String nom, String prenom, Date dateNaissance, Adresse adresse, String noTel, String courriel) {
		registreClient.modifierClient(c, nom, prenom, dateNaissance, adresse, noTel, courriel);
	}
	
	public RegistreClient getRegistreClient() {
		return registreClient;
	}
}
