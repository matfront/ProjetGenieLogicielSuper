package ca.uqtr.gl.ui;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ca.uqtr.gl.controllers.ControlleurClients;
import ca.uqtr.gl.ui.components.ListeClientTableDataModel;

public class EcranListeClient extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTable table;
	private ListeClientTableDataModel dataModel;

	/**
	 * Create the frame.
	 */
	public EcranListeClient(ControlleurClients controlleur) {
		frame = new JFrame();
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		
		frame.setTitle("Liste des clients");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		//Titres de colonnes
		String[] columnNames = {
								"Identifiant",
								"Nom",
								"# Carte"
				                };
		
		dataModel = new ListeClientTableDataModel(columnNames);
		
		table = new JTable(dataModel);
		table.setBounds(0, 0, 450, 240);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	EcranGestionClient window = new EcranGestionClient(EcranPrincipal.ctlClients, dataModel.getClient(row));
					window.frmGestionClient.setVisible(true);
		        }
		    }
		});
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 450, 240);
		contentPane.add(scrollPane);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(320, 247, 115, 26);
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EcranGestionClient window = new EcranGestionClient(EcranPrincipal.ctlClients);
				window.frmGestionClient.setVisible(true);
				
				window.frmGestionClient.addWindowListener(new WindowListener() {

					public void windowActivated(WindowEvent arg0) {
						
					}

					public void windowClosed(WindowEvent arg0) {
						table.updateUI();
					}

					public void windowClosing(WindowEvent arg0) {
						
					}

					public void windowDeactivated(WindowEvent arg0) {
						
					}

					public void windowDeiconified(WindowEvent arg0) {
						
					}

					public void windowIconified(WindowEvent arg0) {
						
					}

					public void windowOpened(WindowEvent arg0) {
						
					}
				});
			}
		});
		contentPane.add(btnAjouter);
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}
