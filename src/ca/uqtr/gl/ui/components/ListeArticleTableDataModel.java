package ca.uqtr.gl.ui.components;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.ui.EcranPrincipal;

public class ListeArticleTableDataModel extends AbstractTableModel {
	private String[] columnNames;
	private ArrayList<Article> listeArticle; 
	
	public ListeArticleTableDataModel(String[] columnNames)
	{
		this.columnNames = columnNames;
		listeArticle = EcranPrincipal.ctlArticles.getRegistreArticle().getListeArticles();
	}
	
	public void setList(ArrayList<Article> listeArticle)
	{
		this.listeArticle = listeArticle;
	}
	
	public int getColumnCount() {
		
		return columnNames.length;
	}

	public int getRowCount() {
		return listeArticle.size();
	}

	public Object getValueAt(int row, int col) {
		Article a = listeArticle.get(row);

		switch(col)
		{
			case 0 : return a.getCode();
			
			case 1 : return a.getDescription();

			case 2 : return a.getQteInventaire();
			
			case 3 : return a.getPrix();
		}
		
		return null;
	}
	
	public String getColumnName(int index) {
	    return this.columnNames[index];
	}
	
	public Article getArticle(int row) {
		return listeArticle.get(row);
	}
}
