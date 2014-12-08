package ca.uqtr.gl.aspects;

import java.lang.Object;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Client;

public aspect LoggingAspect {

private Logger logger = Logger.getLogger("trace");
	
	pointcut ajouterClientMethod(): 
	call(void ajouterClient(..));
	
	after() returning() : ajouterClientMethod() {
		Object[] paramValues = thisJoinPoint.getArgs();
			
		String nom = (String) paramValues[0];
		String prenom = (String) paramValues[1];
		Date dateNaissance = (Date) paramValues[2];
		Adresse adresse = (Adresse) paramValues[3];
		String tel = (String) paramValues[4];
		String courriel = (String) paramValues[5];
		
		Client client = new Client(nom, prenom, dateNaissance, adresse);
		client.setNoTelephone(tel);
		client.setCourriel(courriel);
					 
		logger.logp(Level.INFO, null, null, "\n "
		+ "================ Log Transaction Ajout Client =============== \n"
		+ getLogClient(client)
		);	
	} 
	
	pointcut modifierClientMethod(): 
	call(void modifierClient(..));
	
	before() : modifierClientMethod() {
		Object[] paramValues = thisJoinPoint.getArgs();
		
		Client c = (Client) paramValues[0];
		String nom = (String) paramValues[1];
		String prenom = (String) paramValues[2];
		Date dateNaissance = (Date) paramValues[3];
		Adresse adresse = (Adresse) paramValues[4];
		String tel = (String) paramValues[5];
		String courriel = (String) paramValues[6];
		
		Client clientModifie = new Client(nom, prenom, dateNaissance, adresse);
		clientModifie.setNoTelephone(tel);
		clientModifie.setCourriel(courriel);
					 
		logger.logp(Level.INFO, null, null, "\n "
		+ "================ Log Transaction Modifier Client =============== \n"
		+ "================ Avant modification =============== \n"
		+ getLogClient(c)
		+ "================ Apres modification =============== \n"
		+ getLogClient(clientModifie)
		);	
	} 
	
	pointcut supprimerClientMethod(): 
	call(void supprimerClient(..));
	
	before() : supprimerClientMethod() {
		Object[] paramValues = thisJoinPoint.getArgs();
		
		Client c = (Client) paramValues[0];
					 
		logger.logp(Level.INFO, null, null, "\n "
		+ "================ Log Transaction Supprimer Client =============== \n"
		+ getLogClient(c)
		);	
	} 
	
	private String getLogClient(Client c) {
		String dateNaissanceTexte = (c.getDateNaissance() == null) ? "" : "Date naissance: " + c.getDateNaissance().toString() + "\n";
		String adresseTexte = (c.getAdresse() == null) ? "" : "Adresse: " + c.getAdresse().toString() + "\n";
		
		String log = 	"Nom complet: " + c.getPrenom() + " " + c.getNom() + "\n"
						+ dateNaissanceTexte
						+ adresseTexte
						+ "Telephone: " + c.getNoTelephone() + "\n"
						+ "Courriel: " + c.getCourriel() + "\n";
		
		return log;
	}
}
