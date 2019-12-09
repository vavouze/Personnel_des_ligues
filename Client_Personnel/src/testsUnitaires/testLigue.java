package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	@Test
	void setNom() 
	{	
		Ligue ligue = new Ligue("");
		ligue.setNom("toinou");
		assertEquals("toinou", ligue.getNom());
	}
	
	
	@Test
	void getAdministrateur() 
	{	
		Ligue ligue = new Ligue("test");
		Employe employe = new Employe(ligue,"Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		assertEquals(employe, ligue.getAdministrateur());
	}
	
	@Test
	void setAdministrateur() 
	{
		Ligue ligue = new Ligue("test");
		Ligue ligue2 = new Ligue("test2");
		Employe employe = ligue2.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		assertThrows(DroitsInsuffisants.class,() -> ligue.setAdministrateur(employe));
	}
	
	
	@Test
    public void testToString()
    {
        Ligue ligue = new Ligue("test");
        String expected = "test";
        assertEquals(expected, ligue.toString());
    }
	
	
	@Test
    public void testRemove()
    {
		Ligue ligue = new Ligue("test");
        ligue.remove();
        
    }
	
	
	
	
}
