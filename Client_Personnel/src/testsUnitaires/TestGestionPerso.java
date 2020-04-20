package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.DroitsInsuffisants;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.ImpossibleDeSupprimerRoot;
import personnel.Ligue;



public class TestGestionPerso {
	
	
	@Test
	void testGetLigue() 
	{	
		Ligue ligue = new Ligue("Flechettes");
		
		Employe administrateur = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "");
		ligue.setAdministrateur(administrateur);
		
		assertEquals(ligue,GestionPersonnel.getGestionPersonnel().getLigue(administrateur));	
		
		Employe pasadmin = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "");
		
		assertNull(GestionPersonnel.getGestionPersonnel().getLigue(pasadmin));
		
		
					
	}
	
	
	
	

}
