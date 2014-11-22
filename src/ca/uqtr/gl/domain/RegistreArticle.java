package ca.uqtr.gl.domain;

import java.util.ArrayList;

import ca.uqtr.gl.entities.Article;

public class RegistreArticle {
	private static ArrayList<Article> listeArticles;
	
		
	public RegistreArticle() {
		if (listeArticles == null) {
			listeArticles = new ArrayList<Article>();
		}
	}

	public ArrayList<Article> getListeArticles() {
		return listeArticles;
	}
	
	public static Article rechercherArticle(int identifiant) {
		return listeArticles.get(identifiant);
	}

	public void ajouterArticle(String code, String description, 
			double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, String provenance) throws Exception {

		if(obtenirArticle(code) != null)
		{
			throw new Exception("code déjà existant");		
		}
		listeArticles.add(new Article(code, description, longeur, largeur, hauteur, prix, qte, fraisDouane, provenance));
	}

	public void supprimerArticle(Article article) {
		listeArticles.remove(article);
	}

	public void modifierArticle(Article a, String code, String description, 
			double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, String provenance) {
		
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
