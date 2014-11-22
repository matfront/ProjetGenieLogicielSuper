package ca.uqtr.gl.ui;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ca.uqtr.gl.controllers.ControlleurClients;
import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.util.Utils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EcranGestionClient {

	private ControlleurClients ctlClients;
	private Client client;
	private boolean isDirty = false;
	
	public JFrame frmGestionClient;
	private JTagTextField txtNom;
	private JTagTextField txtPrenom;
	private JTagTextField txtNoCivique;
	private JTagTextField txtVille;
	private JTagTextField txtCodePostal;
	private JLabel lblTlphone;
	private JTagTextField txtTelephone;
	private JLabel lblCourriel;
	private JTagTextField txtCourriel;
	private JTagTextField txtOdonyme;
	private JTagTextField txtDateNaissance;

	public EcranGestionClient(ControlleurClients controlleur) {
		this(controlleur, null);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public EcranGestionClient(ControlleurClients controlleur, Client c) {
		initialize();
		this.ctlClients = controlleur;
		this.client = c;
		this.isDirty = (c == null);
		
		if (c != null) {
			txtNom.setText(c.getNom());
			txtPrenom.setText(c.getPrenom());
			txtNoCivique.setText(String.valueOf(c.getAdresse().getNoCivique()));
			txtVille.setText(c.getAdresse().getVille());
			txtCodePostal.setText(c.getAdresse().getCodePostal());
			txtCourriel.setText(c.getCourriel());
			txtOdonyme.setText(c.getAdresse().getOdonyme());
			String dateNaissance = new SimpleDateFormat("dd-mm-yyyy hh:MM:ss").format(c.getDateNaissance());
			txtDateNaissance.setText(dateNaissance);
			txtTelephone.setText(c.getNoTelephone());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionClient = new JFrame();
		frmGestionClient.setTitle("Gestion clients");
		frmGestionClient.setBounds(100, 100, 607, 395);
		frmGestionClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestionClient.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmGestionClient.getContentPane().add(lblNewLabel);
		
		txtNom = new JTagTextField();
		txtNom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNom.selectAll();
			}
		});
		txtNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtNom);
			}
		});
		txtNom.setToolTipText("");
		txtNom.setBounds(109, 8, 472, 20);
		frmGestionClient.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		lblPrnom.setBounds(10, 42, 69, 14);
		frmGestionClient.getContentPane().add(lblPrnom);
		
		txtPrenom = new JTagTextField();
		txtPrenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtPrenom);
			}
		});
		txtPrenom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPrenom.selectAll();
			}
		});
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(109, 39, 472, 20);
		frmGestionClient.getContentPane().add(txtPrenom);
		
		JLabel lblAdresse = new JLabel("No. civique:");
		lblAdresse.setBounds(10, 117, 69, 14);
		frmGestionClient.getContentPane().add(lblAdresse);
		
		txtNoCivique = new JTagTextField();
		txtNoCivique.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtNoCivique);
			}
		});
		txtNoCivique.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNoCivique.selectAll();
			}
		});
		txtNoCivique.setColumns(10);
		txtNoCivique.setBounds(109, 114, 472, 20);
		frmGestionClient.getContentPane().add(txtNoCivique);
		
		JLabel lblVille = new JLabel("Ville:");
		lblVille.setBounds(10, 173, 46, 14);
		frmGestionClient.getContentPane().add(lblVille);
		
		txtVille = new JTagTextField();
		txtVille.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtVille);
			}
		});
		txtVille.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtVille.selectAll();
			}
		});
		txtVille.setColumns(10);
		txtVille.setBounds(109, 170, 472, 20);
		frmGestionClient.getContentPane().add(txtVille);
		
		JLabel lblCodePostal = new JLabel("Code postal:");
		lblCodePostal.setBounds(10, 201, 80, 14);
		frmGestionClient.getContentPane().add(lblCodePostal);
		
		txtCodePostal = new JTagTextField();
		txtCodePostal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtCodePostal);
			}
		});
		txtCodePostal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodePostal.selectAll();
			}
		});
		txtCodePostal.setColumns(10);
		txtCodePostal.setBounds(109, 198, 472, 20);
		frmGestionClient.getContentPane().add(txtCodePostal);
		
		lblTlphone = new JLabel("T\u00E9l. maison:");
		lblTlphone.setBounds(10, 229, 69, 14);
		frmGestionClient.getContentPane().add(lblTlphone);
		
		txtTelephone = new JTagTextField();
		txtTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtTelephone);
			}
		});
		txtTelephone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTelephone.selectAll();
			}
		});
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(109, 226, 472, 20);
		frmGestionClient.getContentPane().add(txtTelephone);
		
		lblCourriel = new JLabel("Courriel:");
		lblCourriel.setBounds(10, 257, 69, 14);
		frmGestionClient.getContentPane().add(lblCourriel);
		
		txtCourriel = new JTagTextField();
		txtCourriel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCourriel.selectAll();
			}
		});
		txtCourriel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				setChampsNormal(txtCourriel);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtCourriel);
			}
		});
		txtCourriel.setForeground(new Color(0, 0, 0));
		txtCourriel.setColumns(10);
		txtCourriel.setBounds(109, 254, 472, 20);
		frmGestionClient.getContentPane().add(txtCourriel);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (isDirty && validerChampsRequis()) {
					
					String nom = txtNom.getText();
					String prenom = txtPrenom.getText();
					int noCivique = Integer.parseInt(txtNoCivique.getText());
					String ville = txtVille.getText();
					String codePostal = txtCodePostal.getText();
					String telephone = txtTelephone.getText();
					String courriel = txtCourriel.getText();
					String odonyme = txtOdonyme.getText();
					Date dateNaissance = Utils.stringToDate(txtDateNaissance.getText());
					
					Adresse adresse = new Adresse(noCivique, odonyme, ville, codePostal); 
					 
					if (client == null) {
						ctlClients.ajouter(nom, prenom, dateNaissance, adresse, telephone, courriel);
						client = ctlClients.obtenirDernierClient();
						frmGestionClient.dispose();
					} else {
						ctlClients.modifier(client, nom, prenom, dateNaissance, adresse, telephone, courriel);
					}
					
					isDirty = false;
				}
			}
		});
		btnEnregistrer.setBounds(216, 323, 115, 23);
		frmGestionClient.getContentPane().add(btnEnregistrer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (client != null) {
					ctlClients.supprimer(client);
					viderChamps();
					client = null;
				}
			}
		});
		btnSupprimer.setBounds(341, 323, 115, 23);
		frmGestionClient.getContentPane().add(btnSupprimer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmGestionClient.dispose();
			}
		});
		btnAnnuler.setBounds(466, 323, 115, 23);
		frmGestionClient.getContentPane().add(btnAnnuler);
		
		JLabel lblRue = new JLabel("Odonyme:");
		lblRue.setBounds(10, 145, 69, 14);
		frmGestionClient.getContentPane().add(lblRue);
		
		txtOdonyme = new JTagTextField();
		txtOdonyme.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtOdonyme);
			}
		});
		txtOdonyme.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtOdonyme.selectAll();
			}
		});
		txtOdonyme.setColumns(10);
		txtOdonyme.setBounds(109, 142, 472, 20);
		frmGestionClient.getContentPane().add(txtOdonyme);
		
		txtDateNaissance = new JTagTextField();
		txtDateNaissance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setChampsNormal(txtDateNaissance);
			}
		});
		txtDateNaissance.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDateNaissance.selectAll();
			}
		});
		txtDateNaissance.setBounds(109, 70, 472, 20);
		frmGestionClient.getContentPane().add(txtDateNaissance);
		txtDateNaissance.setColumns(10);
		
		JLabel lblDateNais = new JLabel("Date naissance:");
		lblDateNais.setBounds(10, 73, 113, 14);
		frmGestionClient.getContentPane().add(lblDateNais);
		
		JLabel lblAaaammjj = new JLabel("(JJ/MM/AAAA)");
		lblAaaammjj.setBounds(10, 92, 113, 14);
		frmGestionClient.getContentPane().add(lblAaaammjj);
	}
	
	private boolean validerChampsRequis() {
		if (txtNom.getText().isEmpty()) {
			setChampsErreur(txtNom, "Veuillez entrer un nom.");
		}
		
		if (txtPrenom.getText().isEmpty()) {
			setChampsErreur(txtPrenom, "Veuillez entrer un prénom.");
		}
		
		if (!Utils.isNumeric(txtNoCivique.getText())) {
			setChampsErreur(txtNoCivique, "Veuillez entrer un nombre.");
		}
		
		if (txtVille.getText().isEmpty()) {
			setChampsErreur(txtVille, "Veuillez entrer une ville.");
		}
		
		if (txtCodePostal.getText().isEmpty()) {
			setChampsErreur(txtCodePostal, "Veuillez entrer un code postal.");
		}
		
		if (txtTelephone.getText().isEmpty()) {
			setChampsErreur(txtTelephone, "Veuillez entrer un numéro de t\u00E9l\u00E9phone.");
		}
		
		if (txtOdonyme.getText().isEmpty()) {
			setChampsErreur(txtOdonyme, "Veuillez entrer un odonyme.");
		}
		
		if (!Utils.isValidDate(txtDateNaissance.getText())) {
			setChampsErreur(txtDateNaissance, "Veuillez entrer une date de naissance avec le bon format.");
		}
		
		return !txtNom.isInError() &&
			   !txtPrenom.isInError() &&
			   !txtNoCivique.isInError() &&
			   !txtVille.isInError() &&
			   !txtCodePostal.isInError() &&
			   !txtTelephone.isInError() &&
			   !txtOdonyme.isInError() &&
			   !txtDateNaissance.isInError();
	}
	
	private void viderChamps() {
		txtNom.setText("");
		txtPrenom.setText("");
		txtNoCivique.setText("");
		txtVille.setText("");
		txtCodePostal.setText("");
		txtTelephone.setText("");
		txtOdonyme.setText("");
		txtDateNaissance.setText("");
		txtCourriel.setText("");
	}
	
	private void setChampsNormal(JTagTextField field) {
		field.setForeground(Color.BLACK);
		field.setInError(false);
		isDirty = true;
	}
	
	private void setChampsErreur(JTagTextField field, String msgErreur) {
		field.setText(msgErreur);
		field.setForeground(Color.RED);
		field.setInError(true);
	}
}
