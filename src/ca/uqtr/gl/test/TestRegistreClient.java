package ca.uqtr.gl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




import ca.uqtr.gl.domain.RegistreClient;
import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.util.Utils;

public class TestRegistreClient {

	private RegistreClient registreClient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		try {
			//Ajoute dans le registe des Clients pour les tests. Cette fonction sera appelée à chaque test. 
			registreClient = RegistreClient.getInstance();
			registreClient.initListeClients();
		
			registreClient.ajouterClient("Laplante1", "Roger", Utils.stringToDate("01-01-1978"), new Adresse(10,"Iberville", "Quebec","G54f58"), "8132855456", "Roger@gmail.com");
			registreClient.ajouterClient("Laplante2", "Roger2", Utils.stringToDate("01-01-1979"), new Adresse(10,"Notre-Dame", "Quebec","F55658"), "81453855456", "Roger2@gmail.com");
			registreClient.ajouterClient("Laplante3", "Roger3", Utils.stringToDate("01-01-1987"), new Adresse(10,"Denis", "Quebec","H54f56"), "83444456", "Roger3@gmail.com");
		
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testGetInstance() {
		  //test du sangleton. vérifie si l'instance est pareil.
		  RegistreClient instance1 = RegistreClient.getInstance();
		  RegistreClient instance2 = RegistreClient.getInstance();
    
		  assertEquals("instance1 = instance2", true, instance1 == instance2);
	}


	@Test
	public void testAjouterClient() {
		try {
			  //initilaliser le nombre du client du départ.
			  int nombreClientAvant =  registreClient.getListeClients().size();
			  
			  registreClient.ajouterClient("Encore", "Roger5", Utils.stringToDate("01-01-1934"), new Adresse(10,"Denis", "Quebec","H54f56"), "1334456", "Roger5@gmail.com");
			  //vérification du nombre de départ et nombre actuelle est augmenté.
			  assertTrue("AjouterClient() ne diminue pas le nombre de client", registreClient.getListeClients().size() - 1 == nombreClientAvant);
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public void testSupprimerClient() {
		try {
			//initilaliser le nombre de client du départ.
			int nombreClientAvant =  registreClient.getListeClients().size();
			Client c = registreClient.getListeClients().get(1);
			registreClient.supprimerClient(c);
			//vérification du nombre de départ et nombre actuelle est diminué.
			assertTrue("SupprimerClient() ne diminue pas le nombre de client", registreClient.getListeClients().size() + 1 == nombreClientAvant);
	
			} catch (Exception e) {
				fail();
			}
	
	}

	@Test
	public void testModifierClient() {
		try {
				Client c = registreClient.obtenirClient(2);
				registreClient.modifierClient(c, "testModifNom", "testModifPrenom", Utils.stringToDate("01-01-1978"), new Adresse(10,"Plante", "Quebec","G54f58"), "8132345456", "test@gmail.com");
				//Vérification de la modification des propriétés Prenom et nom fonctionne
				assertEquals("Erreur avec ModifierClient() Modifcation de la prenom", "testModifPrenom", c.getPrenom());
			   	assertEquals("Erreur avec ModifierClient() Modifcation du nom", "testModifNom", c.getNom());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testObtenirClient() {
		try {
			//Vérification de l'obtation d'un client
			Client c = registreClient.obtenirClient(registreClient.getListeClients().get(0).getIdentifiant());
			assertEquals("Nom est =", "Laplante1", c.getNom());
						
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testObtenirClientParNoCarteMembre() {
		try {
			//Vérification de l'obtation d'un client
			int Carte = registreClient.obtenirClient(registreClient.getListeClients().get(0).getIdentifiant()).getNoCarteMembre();
			Client c = registreClient.obtenirClientParNoCarteMembre(Carte);
			assertNotNull("Non Null", c);
						
		} catch (Exception e) {
			fail();
		}
	}

}
