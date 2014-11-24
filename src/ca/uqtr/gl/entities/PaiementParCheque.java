package ca.uqtr.gl.entities;

public class PaiementParCheque implements Paiement {

	private double grandTotal;
	
	public PaiementParCheque(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void effectuer() {
		// Effectuer le paiement par cheque
	}

}
