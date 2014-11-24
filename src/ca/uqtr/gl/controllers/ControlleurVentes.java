package ca.uqtr.gl.controllers;

import java.util.ArrayList;

import ca.uqtr.gl.domain.RegistreVente;
import ca.uqtr.gl.entities.Vente;

public class ControlleurVentes {

	private static RegistreVente registreVentes;
	private static int numeroFactureCompteur = 1000;
	private static ControlleurVentes instance = null;
	
	private  ControlleurVentes()
	{
		registreVentes = new RegistreVente();
	}
	
	public static ControlleurVentes getInstance()
	{
		if(instance == null)
		{
			instance = new ControlleurVentes();
		}
		
		return instance;
	}
	
	public void ajouterVente(Vente vente)
	{
		vente.setNumeroFacture(numeroFactureCompteur++);
		registreVentes.ajouterVente(vente);
	}
	
	public void supprimerVente(Vente vente)
	{
		registreVentes.supprimerVente(vente);
	}
	
	public Vente obtenirVenteParNumeroFacture(int numeroFacture)
	{
		return registreVentes.obtenirVenteParNumeroFacture(numeroFacture);
	}
	
	public ArrayList<Vente> getListeVentes()
	{
		return registreVentes.getListeVentes();
	}
	
}
