package ca.uqtr.gl.entities;

public class LigneVente implements java.io.Serializable {
	
	private int quantite;
	private Article article;
	
	
	public LigneVente(int quantite, Article article) {
		this.quantite = quantite;
		this.article = article;
	}

	public double getTotal()
	{
		return quantite * article.getPrix();
	}
	
	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	
}
