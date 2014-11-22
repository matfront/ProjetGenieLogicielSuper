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
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.entities.Vente;
import ca.uqtr.gl.ui.components.VenteTableDataModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;


public class EcranTraiterPaiement {

	private JFrame frmTraiterUnPaiement;
	private JPanel contentPane;
	
	private EcranTraiterUneVente ecranTraiterUneVente;
	private JTextField textFieldTotal;
	private JTextField textFieldMontantRecu;
	private JTextField textFieldMonnaie;
	
	private boolean isPaiementReussi = false;
	
	private Vente vente;
	private Client client;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	public EcranTraiterPaiement(Vente vente, Client client) {
		
		this.vente = vente;
		this.client = client;
		
		frmTraiterUnPaiement = new JFrame();
		frmTraiterUnPaiement.setAlwaysOnTop(true);
		frmTraiterUnPaiement.setTitle("Traiter un paiement");
		frmTraiterUnPaiement.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTraiterUnPaiement.setBounds(100, 100, 285, 323);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmTraiterUnPaiement.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModeDePaiement = new JLabel("Mode de paiement");
		lblModeDePaiement.setBounds(6, 6, 178, 16);
		contentPane.add(lblModeDePaiement);
		
		JRadioButton rdbtnEspces = new JRadioButton("Especes");
		rdbtnEspces.setSelected(true);
		buttonGroup.add(rdbtnEspces);
		rdbtnEspces.setBounds(6, 34, 91, 23);
		contentPane.add(rdbtnEspces);
		
		JRadioButton rdbtnCarte = new JRadioButton("Carte");
		buttonGroup.add(rdbtnCarte);
		rdbtnCarte.setBounds(101, 34, 83, 23);
		contentPane.add(rdbtnCarte);
		
		JRadioButton rdbtnChque = new JRadioButton("Chèque");
		buttonGroup.add(rdbtnChque);
		rdbtnChque.setBounds(191, 34, 88, 23);
		contentPane.add(rdbtnChque);
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setBounds(6, 79, 61, 16);
		contentPane.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBackground(Color.LIGHT_GRAY);
		textFieldTotal.setEditable(false);
		textFieldTotal.setBounds(130, 73, 134, 28);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JLabel lblMontantReu = new JLabel("Montant reçu :");
		lblMontantReu.setBounds(6, 116, 134, 16);
		contentPane.add(lblMontantReu);
		
		textFieldMontantRecu = new JTextField();
		textFieldMontantRecu.setBounds(130, 110, 134, 28);
		contentPane.add(textFieldMontantRecu);
		textFieldMontantRecu.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monnaie :");
		lblNewLabel.setBounds(6, 194, 69, 16);
		contentPane.add(lblNewLabel);
		
		textFieldMonnaie = new JTextField();
		textFieldMonnaie.setBackground(Color.LIGHT_GRAY);
		textFieldMonnaie.setEditable(false);
		textFieldMonnaie.setBounds(130, 188, 134, 28);
		contentPane.add(textFieldMonnaie);
		textFieldMonnaie.setColumns(10);
		
		updateTotal();
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lorsque le bouton "OK" est clique
				// Calculer et afficher la monnaie a remettre
				updateMonnaie();
			}
		});
		btnOk.setBounds(145, 147, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enregistrer();
				// Lorsque le bouton "Enregistrer" est clique
				// Enregistrer le paiement
				enregistrer();
			}
		});
		btnEnregistrer.setBounds(18, 249, 117, 29);
		contentPane.add(btnEnregistrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lorsque le bouton "Annuler" est clique
				// Annuler le paiement
				frmTraiterUnPaiement.setVisible(false);
			}
		});
		btnAnnuler.setBounds(144, 249, 117, 29);
		contentPane.add(btnAnnuler);
		
		initListeners();
	}
	
	public JFrame getFrame()
	{
		return frmTraiterUnPaiement;
	}
	private void initListeners()
	{
	}

	public boolean isPaiementReussi() {
		return isPaiementReussi;
	}
	
	public void setVente(Vente vente) {
		this.vente = vente;
	}

	private void updateTotal() {
		textFieldTotal.setText(Double.toString(vente.getGrandTotal()));
	}

	private void updateMonnaie() {
		double monnaie = 0;
		double montantRecu = 0;
		
		try {
			montantRecu = Double.parseDouble(textFieldMontantRecu.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		monnaie = montantRecu - vente.getGrandTotal();
		
		if(monnaie < 0) {
			JOptionPane.showMessageDialog(frmTraiterUnPaiement, "Le montant recu est inferieur au total.");
		}
		else {
			isPaiementReussi = true;
			DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.setMaximumFractionDigits(2);
			
			textFieldMonnaie.setText(decimalFormat.format(monnaie));
		}
	}

	private void enregistrer() {
		if(!isPaiementReussi) {
			JOptionPane.showMessageDialog(frmTraiterUnPaiement, "Le paiement n'a pas ete complete.");
		}
		else {
			//Assigne le client � la vente
			vente.setClient(client);

			//Ajoute la vente au registre
			EcranPrincipal.ctlVentes.ajouterVente(vente);
			//ecranAfficherListeVentes.rafraichirListeVentes(); // TODO ? Rafraichir la liste des ventes...?
			frmTraiterUnPaiement.setVisible(false);
		}
	}
}
