package ca.uqtr.gl.aspects;

import java.awt.EventQueue;

import ca.uqtr.gl.ui.EcranLogin;

public aspect LoginAspect {
	private EcranLogin dialog = null;
	
	pointcut startEcranLogin(): 
	call(void initialization());
	 
	after() : startEcranLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialog = new EcranLogin();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		while (dialog == null || (dialog != null && dialog.getModalResult() == 0)) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
