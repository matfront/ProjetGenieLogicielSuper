package ca.uqtr.gl.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import ca.uqtr.gl.controllers.ControlleurVentes;
import ca.uqtr.gl.domain.RegistreVente;
import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Article;
import ca.uqtr.gl.entities.Client;
import ca.uqtr.gl.entities.LigneVente;
import ca.uqtr.gl.entities.Vente;
import ca.uqtr.gl.ui.EcranPrincipal;

public class ArchiveTimer {
	private Timer timer;
	private TimerTask minuteTask;
	private final int TIME = 1000 * 60;
	
	public ArchiveTimer() {
		timer = new Timer();
		createTimerTask();
		timer.schedule(minuteTask, TIME, TIME);
	}
	
	private void createTimerTask() {
		minuteTask = new TimerTask() {
			@Override
			public void run() {
				/*Article a = new Article("ABC123", "Frisbee", 12, 12, 1, 20, 20);
				
				Adresse ad = new Adresse(282, "rue Boulard", "Trois-Rivières", "G8T9G9");
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date = null;
				try {
					date = sdf.parse("28/03/1992");
				} catch (Exception e) { }
				
				Client c = new Client("Lamer", "Gabriel", date, ad);
				
				Vente v = new Vente();
				v.ajouterLigne(2, a);
				v.setNumeroFacture(1);
				v.setClient(c);*/
				
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
				Date d = new Date();
				
				try {
					FileOutputStream fileOut = new FileOutputStream("archive" + dateFormat.format(d) + ".txt");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					
					for (Vente v : RegistreVente.listeVentes) {
						out.writeObject(v);
					}
					
			        out.close();
			        fileOut.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
