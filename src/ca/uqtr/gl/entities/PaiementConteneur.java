package ca.uqtr.gl.entities;

public class PaiementConteneur {

	private Paiement paiement;
	
	public PaiementConteneur(Paiement paiement) {
		this.paiement = paiement;
	}
	
	public void effectuerPaiement() {
		paiement.effectuer();
	}
}
