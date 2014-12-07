package ca.uqtr.gl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uqtr.gl.domain.RegistreArticle;
import ca.uqtr.gl.domain.RegistreClient;
import ca.uqtr.gl.domain.RegistreVente;
import ca.uqtr.gl.entities.Article.TypeProvenance;
import ca.uqtr.gl.entities.Vente;

public class TestRegistreVente {

	private RegistreVente registreVente;
	private static RegistreClient registreClient;
	private static RegistreArticle registreArticle;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		try
		{

			//Initilisation des clients et des article pour faire des tests de vente. 
			//cette fonctionne sara appeller une seul fois avec les tests de vente
			registreClient = RegistreClient.getInstance();
			registreArticle = RegistreArticle.getInstance();
			
			registreArticle.initListeArticles();
			registreClient.initListeClients();
			
			registreClient.ajouterClient("Tremblay", "Carl", null, null, "(450) 222-3333", "carl@gmail.com");
			registreClient.ajouterClient("Roy", "Bob", null, null, "(450) 444-5555", "roy@gmail.com");
			
			registreArticle.ajouterArticle("1", "TestCan", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);
			registreArticle.ajouterArticle("2", "TestCan2", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);
			registreArticle.ajouterArticle("3", "TestUs1", 1, 1, 1, 1, 1, 1, TypeProvenance.Us);
		
		} catch (Exception e) {
			fail();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		
		try
		{
			//Ajoute dans le registe des Ventes pour les tests. Cette fonction sera appelée à chaque test.  
			registreVente = new RegistreVente();
			
			Vente v1 = new Vente();
			v1.setClient(registreClient.getListeClients().get(1));
			v1.ajouterLigne(2, registreArticle.obtenirArticle("1"));
			registreVente.ajouterVente(v1);
			
			Vente v2 = new Vente();
			v2.setClient(registreClient.getListeClients().get(1));
			v2.ajouterLigne(2, registreArticle.obtenirArticle("1"));
			registreVente.ajouterVente(v2);
		} catch (Exception e) {
			fail();
		}
	}


	@Test
	public final void testAjouterVente() {
		try {
			   //initilaliser le nombre de vente du départ.
			   int nombreVenteAvant =  RegistreVente.getListeVentes().size();
			
				Vente v1 = new Vente();
				v1.setClient(registreClient.getListeClients().get(1));
				v1.ajouterLigne(2, registreArticle.obtenirArticle("1"));
				registreVente.ajouterVente(v1);
				//vérification du nombre de départ et nombre actuelle est augmenté.
			   assertTrue("AjouterVente() n'augmente pas le nombre de vente", RegistreVente.getListeVentes().size() - 1 == nombreVenteAvant);
			   
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public final void testSupprimerVente() {
		try {  
			   //initilaliser le nombre de vente du départ.	   		   
			   int nombreVenteAvant =  RegistreVente.getListeVentes().size();			   		
			   registreVente.supprimerVente(RegistreVente.getListeVentes().get(0));
			   //vérification du nombre de départ et nombre actuelle est diminué.
			   assertTrue("Supression Vente() n'augmente pas le nombre de vente", RegistreVente.getListeVentes().size() + 1 == nombreVenteAvant);
			   
		} catch (Exception e) {
			fail();
		}
	}
	


	@Test
	public final void testObtenirVenteParNumeroFacture() {
		try {		   		   
			   int nofacture =  RegistreVente.getListeVentes().get(0).getNumeroFacture();			   		
			   Vente vente = registreVente.obtenirVenteParNumeroFacture(nofacture);
			   //Vérification de l'obtation d'une vente
			   assertTrue("ObtenirVenteParNumeroFacture() n'obtient pas la bonne facture",  vente.getNumeroFacture() == nofacture);
			   
		} catch (Exception e) {
			fail();
		}
	
	}



}
