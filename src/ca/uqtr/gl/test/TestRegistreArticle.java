package ca.uqtr.gl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uqtr.gl.domain.RegistreArticle;
import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.Article.TypeProvenance;

public class TestRegistreArticle {
	
	private RegistreArticle registreArticle;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before
	public void setUp()  {
		
		try {
			registreArticle = RegistreArticle.getInstance();
			registreArticle.initListeArticles();
		
			registreArticle.ajouterArticle("1", "TestCan", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);
			registreArticle.ajouterArticle("2", "TestCan", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);
			registreArticle.ajouterArticle("3", "TestUs", 1, 1, 1, 1, 1, 1, TypeProvenance.Us);
		
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public final void testGetInstance() {
	      
		  RegistreArticle instance1 = RegistreArticle.getInstance();
		  RegistreArticle instance2 = RegistreArticle.getInstance();
      
		  assertEquals("instance1 = instance2", true, instance1 == instance2);
	}


	@Test
	public final void testAjouterArticle() {
		try {
			   registreArticle.ajouterArticle("4", "TestCan4", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);		
		} catch (Exception e) {
			fail();
		}
		
		try {
			registreArticle.ajouterArticle("4", "TestCan4", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);	
		    fail( "Erreur ajouterArticle permet d'ajouter un code existant" );
		} catch (Exception e) {
			
		}
		
	}

	@Test
	public final void testSupprimerArticle() {
		try {
				Article a = registreArticle.obtenirArticle("2");
			   	registreArticle.supprimerArticle(a);
		
		} catch (Exception e) {
			fail();
		}
		
		try {
		   	registreArticle.supprimerArticle(null);
		    fail( "Erreur supprimerArticle permet de supprimer un null" );
		} catch (Exception e) {
			
		}
	}

	@Test
	public final void testModifierArticle() {
		
		Article a = registreArticle.obtenirArticle("2");
	   	registreArticle.modifierArticle(a, "34", "testModif", 2, 2, 2, 2, 2, 0, TypeProvenance.Can);
	   	assertEquals("Modifcation", "testModif", a.getDescription());
	}

	@Test
	public final void testObtenirArticle() {
		
		try {
				Article a = registreArticle.obtenirArticle("2");
				assertEquals("Description est =", "TestCan", a.getDescription());
				assertEquals("Vérifcation la création des classes selon la provenance", "ca.uqtr.gl.entities.ArticleCan", a.getClass().getName());
				
				a = registreArticle.obtenirArticle("3");
				assertEquals("Vérifcation la création des classes selon la provenance", "ca.uqtr.gl.entities.ArticleUs", a.getClass().getName());
				
				
		} catch (Exception e) {
			fail();
		}
	}

}
