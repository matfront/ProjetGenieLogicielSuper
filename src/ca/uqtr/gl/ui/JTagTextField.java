package ca.uqtr.gl.ui;

import javax.swing.JTextField;

public class JTagTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2235978773483063901L;
	private boolean isInError = false;

	public boolean isInError() {
		return isInError;
	}

	public void setInError(boolean isInError) {
		this.isInError = isInError;
	}
}
