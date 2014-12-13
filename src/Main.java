
import java.awt.EventQueue;

import ca.uqtr.gl.services.ArchiveTimer;
import ca.uqtr.gl.ui.EcranPrincipal;

public class Main {	

	public static void main(String[] args) {	

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
}
