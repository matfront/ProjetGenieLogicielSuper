package ca.uqtr.gl.ui;


import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.uqtr.gl.controllers.ControlleurArticles;
import ca.uqtr.gl.controllers.ControlleurClients;
import ca.uqtr.gl.controllers.ControlleurVentes;
import ca.uqtr.gl.entities.Article.TypeProvenance;
import ca.uqtr.gl.entities.Vente;



public class EcranPrincipal {

	
	//Ces variables globales ont disparues dans cette version grâce au singletons
	//public static ControlleurClients ctlClients;
	//public static ControlleurArticles ctlArticles = new ControlleurArticles();
	
	private JPanel contentPane;
	private JFrame frame;
	

	/**
	 * Create the frame.
	 */
	public EcranPrincipal() {
		ControlleurClients.getInstance().ajouter("Tremblay", "Carl", null, null, "(450) 222-3333", "carl@gmail.com");
		ControlleurClients.getInstance().ajouter("Roy", "Bob", null, null, "(450) 444-5555", "roy@gmail.com");
		
		try
		{
			ControlleurArticles.getInstance().ajouter("SKI1213", "Ski alpin", 12, 12, 12, 340, 5, 10, TypeProvenance.Can);
			ControlleurArticles.getInstance().ajouter("RAQ3434", "Raquette de tennis", 12, 12, 12, 100, 4, 10, TypeProvenance.Can);
			ControlleurArticles.getInstance().ajouter("BAL1000", "Balle de baseball", 12, 12, 12, 4.99, 15, 10, TypeProvenance.Can);
			
			Vente v1 = new Vente();
			v1.setClient(ControlleurClients.getInstance().obtenirClientParNoCarteMembre(1000));
			v1.ajouterLigne(2, ControlleurArticles.getInstance().obtenirArticle("SKI1213"));
			ControlleurVentes.getInstance().ajouterVente(v1);
			
			Vente v2 = new Vente();
			v2.setClient(ControlleurClients.getInstance().obtenirClientParNoCarteMembre(1001));
			v2.ajouterLigne(3, ControlleurArticles.getInstance().obtenirArticle("SKI1213"));
			ControlleurVentes.getInstance().ajouterVente(v2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		frame = new JFrame();
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		
		frame.setTitle("Menu principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGererClients = new JButton("G\u00E9rer clients");
		
		btnGererClients.setBounds(10, 35, 167, 37);
		contentPane.add(btnGererClients);
		
		JButton btnGererArticles = new JButton("G\u00E9rer articles");
		btnGererArticles.setBounds(10, 83, 167, 37);
		contentPane.add(btnGererArticles);
		
		JButton btnTraiterUneVente = new JButton("Traiter une vente");
		
		btnTraiterUneVente.setBounds(10, 131, 167, 37);
		contentPane.add(btnTraiterUneVente);
		
		//Gestion des clients
		btnGererClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EcranListeClient window = new EcranListeClient(ControlleurClients.getInstance());
				window.frame.setVisible(true);
			}
		});
		
		//Traiter une vente
		btnTraiterUneVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//EcranTraiterUneVente window = new EcranTraiterUneVente();
				EcranAfficherListeVentes window = new EcranAfficherListeVentes();
				window.getFrame().setVisible(true);
			}
		});
		
		
		//Gestion des Articles
		btnGererArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EcranListeArticle window = new EcranListeArticle(ControlleurArticles.getInstance());
				window.frame.setVisible(true);
			}
		});
		
		
		
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}
