package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean controlVerifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] controlListeVendeurProduit(String produit) {
		String[] infoMarche = village.donnerEtatMarche();
		int nbVendeurProduit = 0;

		for (int i = 0; i < infoMarche.length; i += 3) {
			if (infoMarche[i + 2].equals(produit)) {
				nbVendeurProduit++;
			}
		}

		if (nbVendeurProduit == 0) {
			return null;
		}

		String[] listeVendeurProduit = new String[nbVendeurProduit];
		int j = 0;

		for (int i = 0; i < infoMarche.length; i += 3) {
			if (infoMarche[i + 2].equals(produit)) {
				listeVendeurProduit[j] = infoMarche[i];
				j++;
			}
		}

		return listeVendeurProduit;
	}

	public String[] controlInfoVendeurProduit(String listeVendeur[]) {
		String[] infoVendeurProduit = new String[(listeVendeur.length) * 3];
		String[] infoMarche = village.donnerEtatMarche();

		int j = 0;
		for (int i = 0; i < infoMarche.length; i += 3) {
			if (listeVendeur[j].equals(infoMarche[i])) {
				infoVendeurProduit[j] = infoMarche[i];
				infoVendeurProduit[j + 1] = infoMarche[i + 1];
				infoVendeurProduit[j + 2] = infoMarche[i + 2];
				j += 3;

			}
		}

		return infoVendeurProduit;
	}

	public Etal controlTrouverEtal(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}

}
