package ca.uqtr.gl.ui.components;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.ui.EcranPrincipal;

public class ListeClientTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -2999506785141283840L;
	private String[] columnNames;
	private ArrayList<Client> listeClient; 
	
	public ListeClientTableDataModel(String[] columnNames)
	{
		this.columnNames = columnNames;
		listeClient = EcranPrincipal.ctlClients.getRegistreClient().getListeClients();
	}
	
	public void setList(ArrayList<Client> listeClient)
	{
		this.listeClient = listeClient;
	}
	
	public int getColumnCount() {
		
		return columnNames.length;
	}

	public int getRowCount() {
		return listeClient.size();
	}

	public Object getValueAt(int row, int col) {
		Client c = listeClient.get(row);

		switch(col)
		{
			case 0 : return c.getIdentifiant();
			
			case 1 : return c.getPrenom() + " " + c.getNom();

			case 2 : return c.getNoCarteMembre();
		}
		
		return null;
	}
	
	@Override
	public String getColumnName(int index) {
	    return this.columnNames[index];
	}
	
	public Client getClient(int row) {
		return listeClient.get(row);
	}
}
