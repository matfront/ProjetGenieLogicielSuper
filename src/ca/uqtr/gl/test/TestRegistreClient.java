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
		  RegistreClient instance1 = RegistreClient.getInstance();
		  RegistreClient instance2 = RegistreClient.getInstance();
    
		  assertEquals("instance1 = instance2", true, instance1 == instance2);
	}


	@Test
	public void testAjouterClient() {
		try {
			registreClient.ajouterClient("Encore", "Roger5", Utils.stringToDate("01-01-1934"), new Adresse(10,"Denis", "Quebec","H54f56"), "1334456", "Roger5@gmail.com");
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public void testSupprimerClient() {
		try {
			Client c = registreClient.obtenirClient(2);
			registreClient.supprimerClient(c);
	
			} catch (Exception e) {
				fail();
			}
	
	}

	@Test
	public void testModifierClient() {
		Client c = registreClient.obtenirClient(2);
		registreClient.modifierClient(c, "testModifPrenom", "testModifNom", Utils.stringToDate("01-01-1978"), new Adresse(10,"Plante", "Quebec","G54f58"), "8132345456", "test@gmail.com");
	}

	@Test
	public void testObtenirClient() {
		try {
			
			Client c = registreClient.obtenirClient(registreClient.getListeClients().get(0).getIdentifiant());
			assertEquals("Nom est =", "Laplante1", c.getNom());
						
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testObtenirClientParNoCarteMembre() {
		try {
			int Carte = registreClient.obtenirClient(registreClient.getListeClients().get(0).getIdentifiant()).getNoCarteMembre();
			Client c = registreClient.obtenirClientParNoCarteMembre(Carte);
			assertNotNull("Non Null", c);
						
		} catch (Exception e) {
			fail();
		}
	}

}
