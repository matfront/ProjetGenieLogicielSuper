package ca.uqtr.gl.entities;

public class Adresse implements java.io.Serializable {
	private int noCivique;
	private String odonyme;
	private String ville;
	private String codePostal;
	
	public Adresse(int noCivique, String odonyme, String ville,
			String codePostal) {
		super();
		this.noCivique = noCivique;
		this.odonyme = odonyme;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	public int getNoCivique() {
		return noCivique;
	}
	public void setNoCivique(int noCivique) {
		this.noCivique = noCivique;
	}
	public String getOdonyme() {
		return odonyme;
	}
	public void setOdonyme(String odonyme) {
		this.odonyme = odonyme;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
}
