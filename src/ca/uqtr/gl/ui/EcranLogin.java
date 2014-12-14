package ca.uqtr.gl.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.uqtr.gl.domain.RegistrePrepose;
import ca.uqtr.gl.entities.Prepose;
import javax.swing.JPasswordField;

public class EcranLogin extends JCustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTagTextField txtNomUtilisateur;
	private JPasswordField txtPassword;
	
	/**
	 * Create the dialog.
	 */
	public EcranLogin() {
		this.setModal(true);
		setBounds(100, 100, 352, 170);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 88, 328, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Se connecter");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Prepose p = RegistrePrepose.getInstance().obtenirPrepose(txtNomUtilisateur.getText());
						
						if (p != null && p.getMotPasse().equalsIgnoreCase(String.valueOf(txtPassword.getPassword()))) {
							setModalResult(1);
							dispose();
						} else
							setModalResult(0);
					}
				});
				buttonPane.add(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel label = new JLabel("Mot de passe:");
		label.setBounds(10, 45, 111, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Nom d'utilisateur:");
		label_1.setBounds(10, 14, 121, 14);
		getContentPane().add(label_1);
		
		txtNomUtilisateur = new JTagTextField();
		txtNomUtilisateur.setToolTipText("");
		txtNomUtilisateur.setColumns(10);
		txtNomUtilisateur.setBounds(131, 11, 197, 20);
		getContentPane().add(txtNomUtilisateur);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(131, 42, 197, 20);
		getContentPane().add(txtPassword);
	}
}
