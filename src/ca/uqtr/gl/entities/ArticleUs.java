package ca.uqtr.gl.entities;

public class ArticleUs extends Article implements java.io.Serializable {
	private String code;
	private String description;
	private double longeur;
	private double largeur;
	private double hauteur;
	private double prix;
	private double qteInventaire;
	private double fraisDouane;
	private String provenance;
	

	public ArticleUs(String code, String description, double longeur, double largeur, double hauteur, double prix, double qte, double fraisDouane, TypeProvenance provenance) {
	
		super(code, description, longeur, largeur, hauteur, prix, qte, provenance);
		this.fraisDouane  = fraisDouane;
	}
	

	public double getFraisDouane() {
		return fraisDouane;
	}

	public void setFraisDouane(double fraisDouane) {
		this.fraisDouane = fraisDouane;
	}
	


}