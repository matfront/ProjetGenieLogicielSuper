package ca.uqtr.gl.ui.components;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.LigneVente;
import ca.uqtr.gl.entities.Vente;
import ca.uqtr.gl.util.Utils;


public class VenteTableDataModel extends AbstractTableModel {

	//private List<Article> transaction;
	private Vente vente;
	private String[] columnNames;
	
	public VenteTableDataModel(Vente vente, String[] columnNames)
	{
		this.vente = vente;
		this.columnNames = columnNames;
		
		//this.transaction = new ArrayList<Article>();
		
		//this.transaction.add(new Product("RAQ12", "Raquette de badminton", 30.99, 2));
		//this.transaction.add(new Product("SKI345", "Ski alpin", 239.99, 1));
		//this.transaction.add(new Product("BAL345", "Balle de tennis", 1.99, 10));
		//this.transaction.add(new Product("PAT494", "Patin à glace", 359.99, 3));

	}
	public int getColumnCount() {
		
		return 5;
	}

	public int getRowCount() {
		
		//return this.transaction.size();
		return vente.retournerNombreLigne();
	}

	public Object getValueAt(int row, int col) {
		LigneVente ligneVente = vente.retournerLigneVente(row);

		switch(col)
		{
			case 0 : return ligneVente.getArticle().getCode();
			
			case 1 : return ligneVente.getArticle().getDescription();

			case 2 : return ligneVente.getArticle().getPrix();

			case 3 : return ligneVente.getQuantite();

			case 4 : return ligneVente.getTotal();

		}
		
		return null;
	}
	
	@Override
	public String getColumnName(int index) {
	    return this.columnNames[index];
	}
}
