package ca.uqtr.gl.controllers;


import ca.uqtr.gl.domain.RegistreArticle;
import ca.uqtr.gl.domain.RegistreClient;
import ca.uqtr.gl.entities.Article;

public class ControlleurArticles {
	
	private static RegistreArticle registreArticle;
	private static ControlleurArticles instance;


	public ControlleurArticles() {
		registreArticle =  RegistreArticle.getInstance();
		
	}
	
	public static synchronized ControlleurArticles getInstance() {
		if (instance == null) {
			instance = new ControlleurArticles();
		}
		
		return instance;
	}
	
	public Article obtenirArticle(String code) {
		return registreArticle.obtenirArticle(code);
	}
	

	
	public Article obtenirDernierArticle() {
		return registreArticle.getListeArticles().get(registreArticle.getListeArticles().size()-1);
	}
	
	public void ajouter(String code, String description, 
			double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, String provenance) throws Exception {
		registreArticle.ajouterArticle(code, description, longeur, largeur, hauteur, prix, qte, fraisDouane, provenance);
	}

	public void supprimer(Article a) {
		registreArticle.supprimerArticle(a);
	}

	public void modifier(Article a, String code, String description, 
			double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, String provenance) {
		registreArticle.modifierArticle(a, code, description, longeur, largeur, hauteur, prix, qte, fraisDouane, provenance);
	}
	
	public RegistreArticle getRegistreArticle() {
		return registreArticle;
	}
}
