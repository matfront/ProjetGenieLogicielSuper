package ca.uqtr.gl.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Vente implements java.io.Serializable {
	public final static double TPS = 0.05;
	public final static double TVQ = 0.09975;
	
	private List<LigneVente> listeLignesVente = new ArrayList<LigneVente>();
	private Date dateVente;
	private int numeroFacture;
	private Client client;
	
	public Vente()
	{
		dateVente = new Date();
	}
	
	public void ajouterLigne(int quantite, Article article)
	{
		listeLignesVente.add(new LigneVente(quantite, article));
	}
	
	public void supprimerLigne(int numLigne)
	{
		listeLignesVente.remove(numLigne);
	}
	
	public Integer retournerNombreLigne()
	{
		return listeLignesVente.size();
	}
	
	public LigneVente retournerLigneVente(Integer numItem)
	{
		if(numItem < listeLignesVente.size())
		{
			return listeLignesVente.get(numItem);
		}
		
		return null;
	}
	
	public double getSousTotal()
	{
		double sousTotal = 0;
		for (LigneVente ligneVente : listeLignesVente)
		{
			sousTotal += ligneVente.getTotal();
		}
		
		return sousTotal;
	}
	
	public double getMontantTPS()
	{
		return arrondir(getSousTotal() * TPS);
	}
	
	//NB la TVQ ne se calcule plus sur le montant incluant la TPS
	//source : http://www.revenuquebec.ca/fr/entreprise/taxes/tvq_tps/
	public double getMontantTVQ()
	{
		return arrondir(getSousTotal() * TVQ);
	}
	
	public double getGrandTotal()
	{
		return arrondir(getSousTotal() + getMontantTPS() + getMontantTVQ());
	}
	
	public Date getDateVente()
	{
		return dateVente;
	}
	
	public String getDateVenteChaine()
	{
		return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(dateVente);
	}
	
	
	
	public int getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	public List<LigneVente> getListeLignesVente() {
		return listeLignesVente;
	}

	public void setListeLignesVente(List<LigneVente> listeLignesVente) {
		this.listeLignesVente = listeLignesVente;
	}

	//Arrondi un double avec 2 d�cimales
	private static double arrondir(double valeur)
	{
		BigDecimal bd = new BigDecimal(valeur);
	    bd = bd.setScale(2, RoundingMode.HALF_EVEN);
	    return bd.doubleValue();
	}
	
	public String toString()
	{
		return String.valueOf(this.numeroFacture);
	}
}
