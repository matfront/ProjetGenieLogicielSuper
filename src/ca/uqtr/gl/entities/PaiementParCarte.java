package ca.uqtr.gl.entities;

public class PaiementParCarte implements Paiement {

	private double grandTotal;
	
	public PaiementParCarte(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void effectuer() {
		// Effectuer le paiement par carte
	}

}
