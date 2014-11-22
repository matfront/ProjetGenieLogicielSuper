package ca.uqtr.gl.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ca.uqtr.gl.controllers.*;
import ca.uqtr.gl.entities.Vente;
public class EcranAfficherListeVentes {

	
	private JFrame frame;
	private JPanel contentPane;
	private JList lListeNumerosVentes;
	private DefaultListModel<Vente> listModel = new DefaultListModel<Vente>();
	
	public EcranAfficherListeVentes() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lListeNumerosVentes = new JList(listModel);
		
		lListeNumerosVentes.setBounds(32, 59, 136, 133);
		contentPane.add(lListeNumerosVentes);
		
		JButton btnTraiterUneVente = new JButton("Traiter une vente");
		btnTraiterUneVente.setBounds(32, 228, 136, 23);
		contentPane.add(btnTraiterUneVente);
		
		JLabel lblListeVentesnumro = new JLabel("Liste ventes (num\u00E9ro)");
		lblListeVentesnumro.setBounds(32, 34, 136, 14);
		contentPane.add(lblListeVentesnumro);
		
		JButton btnVoir = new JButton("Voir");
		
		btnVoir.setBounds(32, 202, 89, 23);
		contentPane.add(btnVoir);

		rafraichirListeVentes();
		
		final EcranAfficherListeVentes ecran = this;
		
		//Clique boutton traiter une vente
		btnTraiterUneVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranTraiterUneVente window = new EcranTraiterUneVente(ecran, null);
				window.getFrame().setVisible(true);
			}
		});
		
		//Clique boutton voir
		btnVoir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(!lListeNumerosVentes.isSelectionEmpty())
				{
					Vente venteSel = (Vente) listModel.get(lListeNumerosVentes.getSelectedIndex());
					EcranTraiterUneVente window = new EcranTraiterUneVente(ecran, venteSel);
					window.getFrame().setVisible(true);
				}
			}
		});
		
		
	}
	
	public void rafraichirListeVentes()
	{
		
		listModel.clear();
		
		for(Vente v : EcranPrincipal.ctlVentes.getListeVentes())
			listModel.addElement(v);
	
	}
	
	public Frame getFrame()
	{
		return frame;
	}
}
