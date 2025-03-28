package frontiere;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.controlVerifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desole " + nomAcheteur
					+ " mais il faut etre un habitant de notre village pour commercer ici.");
			return;
		}

		String produit = Clavier.entrerChaine("Quel produit voulez vous acheter?");
		String[] listeVendeurProduit = controlAcheterProduit.controlListeVendeurProduit(produit);

		if (listeVendeurProduit == null) {
			System.out.println("Desole, personne ne vend ce produit au marche");
			return;
		} else {
			System.out.println("Chez quel commercants voulez vous acheter des " + produit);
			this.afficherListeVendeurProduit(listeVendeurProduit);
		}

		int choixVendeur = Clavier.entrerEntier("") - 1;
		System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + listeVendeurProduit[choixVendeur]);
		System.out.println("Bonjour " + nomAcheteur + " combien de " + produit + " voulez vous acheter?");
		int nbProduit = Clavier.entrerEntier("");

		Etal etalVendeur = controlAcheterProduit.controlTrouverEtal(listeVendeurProduit[choixVendeur]);

		if (etalVendeur.getQuantite() == 0) {
			System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit
					+ " , malheureusement il n'y en a plus.");
		} else if (nbProduit > etalVendeur.getQuantite()) {
			System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement "
					+ listeVendeurProduit[choixVendeur] + "n'en a plus que " + etalVendeur.getQuantite() + ". "
					+ nomAcheteur + " achete tout le stock de " + listeVendeurProduit[choixVendeur]);
			etalVendeur.acheterProduit(etalVendeur.getQuantite());
		} else {
			System.out.println(
					nomAcheteur + " achete " + nbProduit + " " + produit + " a " + listeVendeurProduit[choixVendeur]);
			etalVendeur.acheterProduit(nbProduit);
		}

	}

	private void afficherListeVendeurProduit(String[] listeVendeurProduit) {
		for (int i = 0; i < listeVendeurProduit.length; i++) {
			System.out.println((i + 1) + " - " + listeVendeurProduit[i]);
		}
	}
}
