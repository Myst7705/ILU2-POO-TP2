package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager controlEmmenager;
	private Chef chef;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("VillageTest", 5, 5);
		controlEmmenager = new ControlEmmenager(village);
		chef = new Chef("leChef", 10, village);
		village.setChef(chef);
	}

	@Test
	void isHabitantTest() {
		assertFalse(controlEmmenager.isHabitant("Clovis"));

		controlEmmenager.ajouterGaulois("Francois", 3);
		assertTrue(controlEmmenager.isHabitant("Francois"));

		assertTrue(controlEmmenager.isHabitant("leChef"));

		controlEmmenager.ajouterDruide("leDruide", 3, 2, 5);
		assertTrue(controlEmmenager.isHabitant("leDruide"));
	}

	@Test
	void tailleMaxAtteinteTest() {
		for (int i = 1; i < 6; i++) {
			controlEmmenager.ajouterGaulois("gaulois" + i, 5);
		}
		controlEmmenager.ajouterGaulois("gauloisMax", 5);
		assertFalse(controlEmmenager.isHabitant("gauloisMax"));
	}
}
