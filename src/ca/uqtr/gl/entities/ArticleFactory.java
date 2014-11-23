package ca.uqtr.gl.entities;

import ca.uqtr.gl.entities.Article.TypeProvenance;

public class ArticleFactory {
	
	

    public static Article buildArticle(String code, String description, double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, TypeProvenance provenance) throws Exception {
        Article a = null;
        switch (provenance) {
        case Can:
            a = new ArticleCan(code, description, longeur, largeur, hauteur, prix, qte, provenance);
            break;
        case Us:
            a = new ArticleUs(code, description, longeur, largeur, hauteur, prix, qte, fraisDouane, provenance);
            break;
        default:
            // throw some exception
        	throw new Exception("Provenance incorrect.");
        }
        return a;
    }

}