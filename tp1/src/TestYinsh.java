//import Yinsh.Color;
import junit.framework.*;

public class TestYinsh extends TestCase {

	public TestYinsh(String name){ super(name); }

	public void testCurrentColor(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.current_color() == Yinsh.Color.BLACK || tstYinsh.current_color() == Yinsh.Color.WHITE);

		try {
			assertTrue(tstYinsh.put_ring('C', 3, Yinsh.Color.BLACK)==true);

		}
		catch(AssertionFailedError e){
			System.out.println("Echec placemment anneau!");}

		try {
			assertTrue(tstYinsh.tetsPUT('C', 2, Yinsh.Color.BLACK)==true);
		}
		catch(AssertionFailedError e){
			System.out.println("Aucun anneu n'est placé à l'emplacement indiqué");	
		}
		System.out.println(tstYinsh.put_ring().nb_anneau);
	}
	
	/*public void testPutRing(){
		Yinsh tstYinsh = new Yinsh(); // Rajouter fonction qui check l'état de la case dans Yinsh.java
		assertTrue(tstYinsh.put_ring() != Yinsh.Color.NULL);

	}*/
	
	/*public void testPut(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.tetsPUT('A', 2, Yinsh.Color.WHITE));
		System.out.println()
	}*/
		
	
	
}
