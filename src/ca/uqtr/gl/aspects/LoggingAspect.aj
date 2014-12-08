package ca.uqtr.gl.aspects;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import ca.uqtr.gl.entities.Adresse;

public aspect LoggingAspect {

private Logger logger = Logger.getLogger("trace");
	
	pointcut ajouterClientMethods(): 
	call(void ajouterClient(..)); //|| call(void modifierClient(..)));
	
	after() returning() : ajouterClientMethods() {
			Object[] paramValues = thisJoinPoint.getArgs();
			
			String nom = (String) paramValues[0];
			String prenom = (String) paramValues[1];
			Date dateNaissance = (Date) paramValues[2];
			Adresse adresse = (Adresse) paramValues[3];
			String tel = (String) paramValues[4];
			String courriel = (String) paramValues[5];
	
			String dateNaissanceTexte = (dateNaissance == null) ? "" : "Date naissance: " + dateNaissance.toString() + "\n";
			String adresseTexte = (adresse == null) ? "" : "Adresse: " + adresse.toString() + "\n";
						
			logger.logp(Level.INFO, null, null, "\n "
			+ "================ Log Transaction Ajout Client =============== \n"
			+ "Nom complet: " + prenom + " " + nom + "\n"
			+ dateNaissanceTexte
			+ adresseTexte
			+ "Telephone: " + tel + "\n"
			+ "Courriel: " + courriel + "\n\n"
			);
			
		}
}
