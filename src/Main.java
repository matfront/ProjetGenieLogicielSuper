
import java.awt.EventQueue;
import java.util.Date;

import ca.uqtr.gl.domain.RegistrePrepose;
import ca.uqtr.gl.entities.Adresse;
import ca.uqtr.gl.entities.Prepose;
import ca.uqtr.gl.ui.EcranPrincipal;

public class Main {	

	public static void main(String[] args) {	

		initialization();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranPrincipal window = new EcranPrincipal();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void initialization() {
		Adresse a1 = new Adresse(1234, "Boulevard Jean XXIII", "Trois-Rivieres", "G8Y 4N6");
		Adresse a2 = new Adresse(5678, "Boulevard des Forges", "Trois-Rivieres", "G8Y 4N6");
		
		RegistrePrepose.getInstance().ajouterPrepose("Bond", "James", new Date(), a1, 1, "Commis", "james", "007");
		RegistrePrepose.getInstance().ajouterPrepose("Simpson", "Homer", new Date(), a2, 2, "Gerant", "homer", "doh");
	}
}
