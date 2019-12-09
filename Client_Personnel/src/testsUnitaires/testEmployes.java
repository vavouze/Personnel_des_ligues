package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.DroitsInsuffisants;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;


public class testEmployes {
	
	
	@Test
	void testestAdmin() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Ligue ligue2 = new Ligue("TIR");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		assertFalse(employe.estAdmin(ligue2));
		assertTrue(employe.estAdmin(ligue));	
	}
	
	@Test
	void testestRoot() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		assertFalse(employe.estRoot());
		assertTrue(GestionPersonnel.getGestionPersonnel().getRoot().estRoot());
		
	}
	
	
	@Test
	void testgetNom() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue,"Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty");
		assertEquals("Bouchard", employe.getNom());
		assertEquals("Gerard", employe.getPrenom());
		assertEquals("g.bouchard@gmail.com", employe.getMail());
		
	}
	
	@Test
	void testsetNom() 
	{	
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = new Employe(ligue,"", "", "", "azerty");
		employe.setNom("toinou");
		employe.setPrenom("james");
		employe.setMail("james@gmail.com");
		assertEquals("toinou", employe.getNom());
		assertEquals("james", employe.getPrenom());
		assertEquals("james@gmail.com", employe.getMail());
	}
	
	
	@Test
	void testCheckPass() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "");
		employe.setPassword("azerty");
		assertTrue(employe.checkPassword("azerty"));
		assertFalse(employe.checkPassword("tete"));
		
	}
	
	
	@Test
	void testToString() 
	{
		
		Ligue ligue = new Ligue("Flechettes");
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "");
		
		assertEquals("Bouchard Gérard g.bouchard@gmail.com (Flechettes)",employe.toString());
		assertEquals(root.getNom()+" "+ root.getPrenom()+" "+root.getMail()+" (super-utilisateur)",root.toString());
		
	}
	
	
	

	
	
	

}
