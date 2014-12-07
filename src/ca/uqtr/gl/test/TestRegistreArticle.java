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
			
			//Ajoute dans le registe des articles pour les tests. Cette fonction sera appelée à chaque test.  
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
	      
		  //test du sangleton. vérifie si l'instance est pareil.
		  RegistreArticle instance1 = RegistreArticle.getInstance();
		  RegistreArticle instance2 = RegistreArticle.getInstance();
      
		  assertEquals("instance1 = instance2", true, instance1 == instance2);
	}


	@Test
	public final void testAjouterArticle() {
		try {
			   //initilaliser le nombre d'article du départ.
			   int nombreArticleAvant =  registreArticle.getListeArticles().size();
			
			   registreArticle.ajouterArticle("4", "TestCan4", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);	
			   
			   //vérification du nombre de départ et nombre actuelle est augmenté.
			   assertTrue("AjouterArticle() n'augmente pas le nombre d'article", registreArticle.getListeArticles().size() - 1 == nombreArticleAvant);
			   
		} catch (Exception e) {
			fail();
		}
		
		try {
			//vérification l'ajout d'un article existant
			registreArticle.ajouterArticle("4", "TestCan4", 1, 1, 1, 1, 1, 0, TypeProvenance.Can);	
		    fail( "Erreur ajouterArticle permet d'ajouter un code existant" );
		} catch (Exception e) {
			
		}
		
	}

	@Test
	public final void testSupprimerArticle() {
		try {
			   //initilaliser le nombre d'article du départ.
			   int nombreArticleAvant =  registreArticle.getListeArticles().size();
				   			   
			   Article a = registreArticle.obtenirArticle("2");
			   //vérification du nombre de départ et nombre actuelle est diminué.
			   registreArticle.supprimerArticle(a);
			   assertTrue("SupprimerArticle() ne diminue pas le nombre d'article", registreArticle.getListeArticles().size() + 1 == nombreArticleAvant);
				
		
		} catch (Exception e) {
			fail();
		}
		
		try {
			//vérification l'ajout d'un null.
		   	registreArticle.supprimerArticle(null);
		    fail( "Erreur supprimerArticle permet de supprimer un null" );
		} catch (Exception e) {
			
		}
	}

	@Test
	public final void testModifierArticle() {
		
		Article a = registreArticle.obtenirArticle("2");
	   	registreArticle.modifierArticle(a, "34", "testModif", 2, 2, 2, 2, 2, 0, TypeProvenance.Can);
	   	
	   	//Vérification de la modification des propriétés description et code fonctionne
	   	assertEquals("Erreur avec ModifierArticle() Modifcation de la description", "testModif", a.getDescription());
	   	assertEquals("Erreur avec ModifierArticle() Modifcation du code", "34", a.getCode());
	}

	@Test
	public final void testObtenirArticle() {
		
		try {
				Article a = registreArticle.obtenirArticle("2");
				//Vérification de l'obtation de l'article
				assertEquals("Description est =", "TestCan", a.getDescription());
				assertEquals("Vérifcation la création des classes selon la provenance", "ca.uqtr.gl.entities.ArticleCan", a.getClass().getName());
				
				//Vérification Si le factory a instancié la bonne classe
				a = registreArticle.obtenirArticle("3");			
				assertEquals("Vérifcation d'obetenir un Article", "ca.uqtr.gl.entities.ArticleUs", a.getClass().getName());
				
				
		} catch (Exception e) {
			fail();
		}
	}

}
