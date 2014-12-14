package ca.uqtr.gl.ui;

import javax.swing.JDialog;

public class JCustomDialog extends JDialog {
	private int modalResult = 0;

	public int getModalResult() {
		return modalResult;
	}

	public synchronized void setModalResult(int result) {
		this.modalResult = result;
	}
}
