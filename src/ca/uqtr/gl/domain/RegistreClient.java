package ca.uqtr.gl.domain;

import java.util.ArrayList;
import java.util.Date;

import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.util.Utils;

public class RegistreClient {
	private static ArrayList<Client> listeClients;
	
	// identifiant unique pour nouveau client
	public static int compteurIdentifiant = 0;
	public static int compteurCarteMembre = 1000;
		
	public RegistreClient() {
		if (listeClients == null) {
			listeClients = new ArrayList<Client>();
		}
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}
	
	public static Client rechercherClient(int identifiant) {
		return listeClients.get(identifiant);
	}

	public void ajouterClient(String nom, String prenom, 
			Date dateNaissance, Adresse adresse, String noTel, String courriel) {
		listeClients.add(new Client(++compteurIdentifiant, compteurCarteMembre++, nom, prenom, dateNaissance, adresse, noTel, courriel));
	}

	public void supprimerClient(Client client) {
		listeClients.remove(client);
	}

	public void modifierClient(Client c, String nom, String prenom, 
			Date dateNaissance, Adresse adresse, String noTel, String courriel) {
		
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setDateNaissance(dateNaissance);
		c.setAdresse(adresse);
		c.setNoTelephone(noTel);
		c.setCourriel(courriel);
	}
	
	public Client obtenirClient(int identifiant) {
		for(Client c : listeClients) {
			if (c.getIdentifiant() == identifiant) {
				return c;
			}	
		}
			
		return null;
	}
	
	public Client obtenirClientParNoCarteMembre(int noCarteMembre) {
		for(Client c : listeClients) {
			if (c.getNoCarteMembre() == noCarteMembre) {
				return c;
			}	
		}
			
		return null;
	}
}
