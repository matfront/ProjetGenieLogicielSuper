package ca.uqtr.gl.entities;

public class ArticleCan extends Article implements java.io.Serializable {

	public ArticleCan(String code, String description, double longeur,
			double largeur, double hauteur, double prix, double qte,
			TypeProvenance provenance) {
		super(code, description, longeur, largeur, hauteur, prix, qte, provenance);

	}


}