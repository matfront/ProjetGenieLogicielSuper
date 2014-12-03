package ca.uqtr.gl.domain;

import java.util.ArrayList;

import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.Article.TypeProvenance;
import ca.uqtr.gl.entities.ArticleFactory;

public class RegistreArticle {
	private static ArrayList<Article> listeArticles;
	private static RegistreArticle instance;
	
		
	private RegistreArticle() {
		if (listeArticles == null) {
			listeArticles = new ArrayList<Article>();
		}
	}
	
	public static synchronized RegistreArticle getInstance() {
		if (instance == null) {
			instance = new RegistreArticle();
		}
		
		return instance;
	}
	

	public ArrayList<Article> getListeArticles() {
		return listeArticles;
	}
	
	public void initListeArticles() {
		listeArticles.clear();
	}
	
	public static Article rechercherArticle(int identifiant) {
		return listeArticles.get(identifiant);
	}

	public void ajouterArticle(String code, String description, 
			double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, TypeProvenance provenance) throws Exception {

		if(obtenirArticle(code) != null)
		{
			throw new Exception("code déjà existant");		
		}
		listeArticles.add(ArticleFactory.buildArticle(code, description, longeur, largeur, hauteur, prix, qte, fraisDouane, provenance));
	}

	public void supprimerArticle(Article article) throws Exception {
		if(article == null)
			throw new Exception("code inexistant");	
		
		listeArticles.remove(article);
	}

	public void modifierArticle(Article a, String code, String description, 
			double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, TypeProvenance provenance) {
		
		a.setCode(code);
		a.setDescription(description);
		a.setLongeur(longeur);
		a.setLargeur(largeur);
		a.setHauteur(hauteur);
		a.setPrix(prix);
		a.setFraisDouane(fraisDouane);
		a.setProvenance(provenance);
	}
	
	public Article obtenirArticle(String code) {
		for(Article a : listeArticles) {
			if (a.getCode().equals(code)) {
				return a;
			}	
		}
			
		return null;
	}
	
}
