package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlAfficherVillageTest {
	private ControlAfficherVillage ctrlAffVlg;
	private Village village;

	@BeforeEach
	void setUp() throws Exception {
		// Chef chef = new Chef("leChef", 5);
		village = new Village("leVillage", 5, 5);
		ctrlAffVlg = new ControlAfficherVillage(village);
	}

	@Test
	void donnerNomVillageTest() {
		assertEquals(ctrlAffVlg.donnerNomVillage(), "leVillage");
		assertNotEquals(ctrlAffVlg.donnerNomVillage(), "PROUUUUT");
	}

	@Test
	void donnerNbEtalsTest() {
		assertEquals(ctrlAffVlg.donnerNbEtals(), 5);
		assertNotEquals(ctrlAffVlg.donnerNbEtals(), 842);
		assertNotEquals(ctrlAffVlg.donnerNbEtals(), 0);
		assertNotEquals(ctrlAffVlg.donnerNbEtals(), -1);
	}

	@Test
	void donnerNomsVillageoisTest() {
		// assertTrue()
	}

}
