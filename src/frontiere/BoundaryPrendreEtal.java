package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desolee " + nomVendeur +
					" mais il faut etre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un etal.");
			
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Desolee " + nomVendeur + 
						" je n'ai plus d'etal qui ne soit pas deja occupe.");
			} else {
				this.installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un etal pour vous!");
				System.out.println("Il me faudrait quelques renseignements:");
				
				String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre?");
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
				
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if (numeroEtal != -1) {
					
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
