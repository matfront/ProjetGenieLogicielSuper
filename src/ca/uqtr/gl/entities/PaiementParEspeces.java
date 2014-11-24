package ca.uqtr.gl.entities;

public class PaiementParEspeces implements Paiement {

	private double grandTotal;
	
	public PaiementParEspeces(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void effectuer() {
		// Effectuer le paiement par especes
	}

}
