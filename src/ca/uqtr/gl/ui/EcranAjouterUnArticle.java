package ca.uqtr.gl.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.Vente;
import ca.uqtr.gl.ui.components.VenteTableDataModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class EcranAjouterUnArticle {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField tNumArticle;
	private JTextField tNomArticle;
	private JTextField tPrixUnitaire;
	private JButton btnAjouter;
	JSpinner sQuantity;
	
	private Article articleSelectionne = null;
	private EcranTraiterUneVente ecranTraiterUneVente;
	

	public EcranAjouterUnArticle(EcranTraiterUneVente ecranPrecedent) {
		this.ecranTraiterUneVente = ecranPrecedent;
		
		frame = new JFrame();
		frame.setTitle("Ajouter un article sur une vente");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tNumArticle = new JTextField();
		
		tNumArticle.setBounds(116, 37, 86, 20);
		contentPane.add(tNumArticle);
		tNumArticle.setColumns(10);
		
		JLabel lblCodeArticle = new JLabel("Code article :");
		lblCodeArticle.setBounds(34, 40, 85, 14);
		contentPane.add(lblCodeArticle);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		lblQuantit.setBounds(34, 70, 72, 17);
		contentPane.add(lblQuantit);
		
		sQuantity = new JSpinner();
		sQuantity.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		sQuantity.setBounds(116, 68, 46, 20);
		contentPane.add(sQuantity);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 117, 364, 2);
		contentPane.add(separator);
		
		tNomArticle = new JTextField();

		tNomArticle.setEditable(false);
		tNomArticle.setBounds(116, 130, 193, 20);
		contentPane.add(tNomArticle);
		tNomArticle.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(34, 133, 72, 14);
		contentPane.add(lblDescription);
		
		tPrixUnitaire = new JTextField();
		tPrixUnitaire.setEditable(false);

		tPrixUnitaire.setBounds(116, 161, 86, 20);
		contentPane.add(tPrixUnitaire);
		tPrixUnitaire.setColumns(10);
		
		JLabel lblPrixUnitaire = new JLabel("Prix unitaire :");
		lblPrixUnitaire.setBounds(34, 164, 85, 14);
		contentPane.add(lblPrixUnitaire);
		
		btnAjouter = new JButton("Ajouter");
		
		btnAjouter.setBounds(34, 211, 89, 23);
		contentPane.add(btnAjouter);
		
		initListeners();
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	private void initListeners()
	{
		//Bouton Ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(articleSelectionne != null)
				{
					Integer quantite = (Integer) sQuantity.getValue();
					ecranTraiterUneVente.getVente().ajouterLigne(quantite, articleSelectionne);
					ecranTraiterUneVente.rafraichirDonnees();
					frame.setVisible(false);
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Numéro d'article invalide");
				}
			}
		});
		
		//Keypressed numéro article
		tNumArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				String code = tNumArticle.getText() + ke.getKeyChar();
				afficherArticle(code);
			}
		});
	}
	
	
	//Afficle le détails de l'article
	private void afficherArticle(String code)
	{
		
		articleSelectionne = EcranPrincipal.ctlArticles.getRegistreArticle().obtenirArticle(code);


		//Si l'article est trouvé
		if(articleSelectionne != null)
		{
			
			tNomArticle.setText(articleSelectionne.getDescription());
			tPrixUnitaire.setText(String.valueOf(articleSelectionne.getPrix()));
			
			
		}
		else
		{
			articleSelectionne = null;
			tNomArticle.setText("");
			tPrixUnitaire.setText("");
		}
	}
}
