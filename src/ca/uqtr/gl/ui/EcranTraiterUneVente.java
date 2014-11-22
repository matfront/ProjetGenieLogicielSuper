package ca.uqtr.gl.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.entities.Vente;
import ca.uqtr.gl.ui.components.VenteTableDataModel;
import ca.uqtr.gl.util.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class EcranTraiterUneVente {

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField tNoCarteClient;
	private JButton btnAjouter;
	private JLabel lblGrandTotal;
	private JLabel lblSousTotalVal;
	private JLabel lblTPSVal;
	private JLabel lblTVQVal;
	private JLabel lblGrandTotalVal;
	private JLabel lblClientTrouve;
	private JLabel lblClientNonTrouve;
	private JButton btnSupprimer;
	private JButton btnTerminerLaVente;
	private final EcranAfficherListeVentes ecranAfficherListeVentes;
	private VenteTableDataModel dataModel;
	private Vente vente;
	private boolean lectureSeule = false;
	private Client client = null;
	
	
	public EcranTraiterUneVente(EcranAfficherListeVentes ecranAfficherListeVentes, Vente venteSel) {
		
		frame = new JFrame();
		this.ecranAfficherListeVentes = ecranAfficherListeVentes;
		
		if(venteSel != null)
		{
			lectureSeule = true;
			vente = venteSel;
		}
		else
		{
			vente = new Vente();
		}
		
		
		frame.setTitle("Traiter une vente");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 789, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Titres de colonnes
		String[] columnNames = {"Code",
								"Description",
								"Prix un.",
				                "Qt�",
				                "Sous total ($)"
				                };
		
		dataModel = new VenteTableDataModel(vente, columnNames);
		
		table = new JTable(dataModel);
		table.setBounds(25, 106, 650, 184);
		//contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 106, 650, 184);		//Important sinon le table n'est pas affich�
		contentPane.add(scrollPane);
		
		JLabel lblNoCarteClient = new JLabel("No. Carte Client");
		lblNoCarteClient.setBounds(25, 31, 127, 14);
		contentPane.add(lblNoCarteClient);
		
		tNoCarteClient = new JTextField();
		
		tNoCarteClient.setBounds(25, 49, 127, 20);
		contentPane.add(tNoCarteClient);
		tNoCarteClient.setColumns(10);
		
		JLabel lblArticles = new JLabel("Articles");
		lblArticles.setBounds(25, 91, 127, 14);
		contentPane.add(lblArticles);
		
		btnAjouter = new JButton("Ajouter");
		
		btnAjouter.setBounds(25, 301, 89, 23);
		contentPane.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		
		btnSupprimer.setBounds(128, 301, 107, 23);
		contentPane.add(btnSupprimer);
		
		btnTerminerLaVente = new JButton("Terminer la vente");
		
		btnTerminerLaVente.setBounds(509, 422, 150, 23);
		contentPane.add(btnTerminerLaVente);
		
		JLabel lblSoustotal = new JLabel("Sous-total :");
		lblSoustotal.setBounds(509, 301, 74, 14);
		contentPane.add(lblSoustotal);
		
		JLabel lblTps = new JLabel("TPS :");
		lblTps.setBounds(509, 326, 46, 14);
		contentPane.add(lblTps);
		
		JLabel lblTvq = new JLabel("TVQ :");
		lblTvq.setBounds(509, 351, 46, 14);
		contentPane.add(lblTvq);
		
		lblGrandTotal = new JLabel("Grand total :");
		lblGrandTotal.setBounds(509, 376, 74, 14);
		contentPane.add(lblGrandTotal);
		
		lblSousTotalVal = new JLabel("0");
		lblSousTotalVal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSousTotalVal.setBounds(586, 301, 89, 14);
		contentPane.add(lblSousTotalVal);
		
		lblTPSVal = new JLabel("0");
		lblTPSVal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTPSVal.setBounds(587, 326, 88, 14);
		contentPane.add(lblTPSVal);
		
		lblTVQVal = new JLabel("0");
		lblTVQVal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTVQVal.setBounds(587, 351, 88, 14);
		contentPane.add(lblTVQVal);
		
		lblGrandTotalVal = new JLabel("0");
		lblGrandTotalVal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrandTotalVal.setBounds(587, 376, 88, 14);
		contentPane.add(lblGrandTotalVal);
		
		lblClientTrouve = new JLabel("");
		lblClientTrouve.setIcon(new ImageIcon(EcranTraiterUneVente.class.getResource("/ca/uqtr/gl/ressources/green_check.png")));
		lblClientTrouve.setBounds(162, 49, 46, 23);
		contentPane.add(lblClientTrouve);
		
		lblClientNonTrouve = new JLabel("");
		lblClientNonTrouve.setIcon(new ImageIcon(EcranTraiterUneVente.class.getResource("/ca/uqtr/gl/ressources/red_cross.png")));
		lblClientNonTrouve.setBounds(162, 49, 46, 20);
		contentPane.add(lblClientNonTrouve);
		lblClientTrouve.setVisible(false);
		lblClientNonTrouve.setVisible(false);
		
		
		
		
		if(lectureSeule)
		{
			btnAjouter.setVisible(false);
			btnTerminerLaVente.setVisible(false);
			btnSupprimer.setVisible(false);
			
			tNoCarteClient.setText(String.valueOf(vente.getClient().getNoCarteMembre()));
			tNoCarteClient.setEnabled(false);
			rafraichirDonnees();
			
		}
		
		initListeners();
		
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	
	public void rafraichirDonnees()
	{
		dataModel.fireTableDataChanged();
		lblSousTotalVal.setText(String.valueOf(vente.getSousTotal()));
		lblTPSVal.setText(String.valueOf(vente.getMontantTPS()));
		lblTVQVal.setText(String.valueOf(vente.getMontantTVQ()));
		lblGrandTotalVal.setText(String.valueOf(vente.getGrandTotal()));
	}
	
	//initialise les events listeners
	private void initListeners()
	{
		final EcranTraiterUneVente ecran = this;
		
		//Clique boutton Ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			EcranAjouterUnArticle window = new EcranAjouterUnArticle(ecran);
			window.getFrame().setVisible(true);
		}
		});
		
		//�criture d'un caract�re de # de client
		tNoCarteClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				String code = tNoCarteClient.getText() + ke.getKeyChar();
				assignerClientParCode(code);
			}
		});
		
		//Clique boutton Supprimer
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				supprimerArticlesSelectionnes(table.getSelectedRows());
			}
		});
		
		//Clique boutton Terminer la vente
		btnTerminerLaVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(client == null)
				{
					JOptionPane.showMessageDialog(frame, "Vous devez entrer un client valide");
				}
				else if(vente.retournerNombreLigne() == 0)
				{
					JOptionPane.showMessageDialog(frame, "Vous devez entrer au moins un article");
				}
				else
				{	
					//Appeler la fenetre EcranTraiterPaiement
					EcranTraiterPaiement ecranTraiterPaiement = new EcranTraiterPaiement(vente, client);
					ecranTraiterPaiement.getFrame().setVisible(true);
					
					frame.setVisible(false);

					/*
					if(!ecranTraiterPaiement.isPaiementReussi()) {
						JOptionPane.showMessageDialog(frame, "Le paiement n'a pas ete complete.");
					}
					else {
						//Assigne le client � la vente
						vente.setClient(client);

						//Ajoute la vente au registre
						EcranPrincipal.ctlVentes.ajouterVente(vente);
						ecranAfficherListeVentes.rafraichirListeVentes();
						frame.setVisible(false);
					}
					*/
					
				}
			}
		});
		
	}

	private void supprimerArticlesSelectionnes(int[] indices)
	{
		for(int i=(indices.length - 1); i>=0; i--)
		{
			vente.supprimerLigne(i);
		}
		
		rafraichirDonnees();
	}
	
	private void assignerClientParCode(String code)
	{
		if (Utils.isNumeric(code)) {
			client = EcranPrincipal.ctlClients.obtenirClientParNoCarteMembre(Integer.parseInt(code));

			//Si le client est trouv�
			if(client != null)
			{
				lblClientTrouve.setVisible(true);
				lblClientNonTrouve.setVisible(false);
			}
			else
			{
				client = null;
				lblClientTrouve.setVisible(false);
				lblClientNonTrouve.setVisible(true);
			}
		}
	}

	public Vente getVente() {
		return vente;
	}
}
