package ca.uqtr.gl.aspects;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.Client;

public aspect LoggingAspect {

	private Logger logger = Logger.getLogger("trace");
	
	pointcut ajouterClientMethod(): 
	call(void ajouterClient(..));
	
	pointcut modifierClientMethod(): 
	call(void modifierClient(..));
	
	pointcut supprimerClientMethod(): 
	call(void supprimerClient(..));
	
	pointcut ajouterArticleMethod(): 
	call(void ajouterArticle(..));
	
	pointcut modifierArticleMethod(): 
	call(void modifierArticle(..));
	
	pointcut supprimerArticleMethod(): 
	call(void supprimerArticle(..));
	
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
	
	after() returning() : ajouterArticleMethod() {
		Object[] paramValues = thisJoinPoint.getArgs();
		
		Article a = new Article();
		
		a.setCode((String) paramValues[0]);
		a.setDescription((String) paramValues[1]);
		a.setLongeur((Double) paramValues[2]);
		a.setLargeur((Double) paramValues[3]);
		a.setHauteur((Double) paramValues[4]);
		a.setPrix((Double) paramValues[5]);
		a.setQteInventaire((Double) paramValues[6]);
		a.setFraisDouane((Double) paramValues[7]);
		
		logger.logp(Level.INFO, null, null, "\n "
				+ "================ Log Transaction Ajouter Article =============== \n"
				+ getLogArticle(a)
				);	
	}
	
	before() : modifierArticleMethod() {
		Object[] paramValues = thisJoinPoint.getArgs();
		
		Article article = (Article) paramValues[0];
		
		Article a = new Article();
		a.setCode((String) paramValues[1]);
		a.setDescription((String) paramValues[2]);
		a.setLongeur((Double) paramValues[3]);
		a.setLargeur((Double) paramValues[4]);
		a.setHauteur((Double) paramValues[5]);
		a.setPrix((Double) paramValues[6]);
		a.setQteInventaire((Double) paramValues[7]);
		a.setFraisDouane((Double) paramValues[8]);
		
		logger.logp(Level.INFO, null, null, "\n "
				+ "================ Log Transaction Modifier Article =============== \n"
				+ "================ Avant modification =============== \n"
				+ getLogArticle(article)
				+ "================ Apres modification =============== \n"
				+ getLogArticle(a)
				);	
	}
	
	before() : supprimerArticleMethod() {
		Object[] paramValues = thisJoinPoint.getArgs();
		
		Article a = (Article) paramValues[0];
		
		logger.logp(Level.INFO, null, null, "\n "
				+ "================ Log Transaction Supprimer Article =============== \n"
				+ getLogArticle(a)
				);	
	}
	
	private String getLogArticle(Article a) {
		String log = 	"Code: " + a.getCode() + "\n"
						+ "Description: " + a.getDescription() + "\n"
						+ "Longeur: " + String.valueOf(a.getLongeur()) + "\n"
						+ "Largeur: " + String.valueOf(a.getLargeur()) + "\n"
						+ "Hauteur: " + String.valueOf(a.getHauteur()) + "\n"
						+ "Prix: " + String.valueOf(a.getPrix()) + "\n"
						+ "Quantit� inventaire: " + a.getQteInventaire() + "\n"
						+ "Frais douane: " + String.valueOf(a.getFraisDouane()) + "\n";
		
		return log;
	}
}
