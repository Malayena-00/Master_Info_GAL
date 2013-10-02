//import Yinsh.*;
import junit.framework.*;

public class Tests extends TestCase{

	public Tests(String name){
		super(name);
	}

	// Histoire 1 // Teste si la couleur est bien blanche ou noire
	public void testCurrentColor(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.current_color() == Yinsh.Color.BlackRing || tstYinsh.current_color() == Yinsh.Color.WhiteRing);
	}

	// test si
	public void testPutRing(){
		Yinsh tstYinsh = new Yinsh();
		try{
			tstYinsh.put_ring('B', 3, Yinsh.Color.BlackRing);
			tstYinsh.put_ring('B', 3, Yinsh.Color.BlackRing);
			assertTrue(false);
		}catch(JouerDeuxFoisException e){
			assertTrue(true);
			System.out.println(e);
			System.out.println("Vous ne pouvez pas jouer deux fois consécutives.");
		}catch(CoordonneesFaussesException e){
			assertTrue(true);
			System.out.println(e);
			System.out.println("Coordonnées fausses");
		} catch (PlaceDejaPriseException e) {}
	}

	// Compter le nombre d'anneaux avant et après en avoir placé un // Histoire 2
	public void testCountRing(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.CountRings() == 0);
		try {
			tstYinsh.put_ring('C', 9, Yinsh.Color.WhiteRing);
		} catch (JouerDeuxFoisException e) {
			e.printStackTrace();
			System.out.println("Joue deux fois de suite");
		} catch (CoordonneesFaussesException e) {
			e.printStackTrace();
			System.out.println("Coordonnées fausses !!!");
		} catch (PlaceDejaPriseException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		assertTrue(tstYinsh.CountRings() == 1);
	}

	// Vérifier que les coordonnées de l'anneau sont possibles // Histoire 2
	public void testCoordonnees(){
		Yinsh tstYinsh = new Yinsh();
		try{
			tstYinsh.put_ring('B', 10, Yinsh.Color.BlackRing);
		}catch(AssertionFailedError e){
			System.out.println(e);
			System.out.println("Vous ne pouvez pas jouer en dehors du plateau.");
		}catch(CoordonneesFaussesException e){
			System.out.println("Coordonnées en dehors du plateau");
			e.printStackTrace();
		} catch (JouerDeuxFoisException e) {
			e.printStackTrace();
		} catch (PlaceDejaPriseException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}

	// teste si la place est déja prise
	public void testMemeIntersection(){
		Yinsh tstYinsh = new Yinsh();

		try{
			tstYinsh.put_ring('B', 1, Yinsh.Color.BlackRing);
			tstYinsh.put_ring('B', 1, Yinsh.Color.WhiteRing);
			assertTrue(false);
		}catch(AssertionFailedError e){
			System.out.println(e);
			System.out.println("Vous ne pouvez pas jouer sur la même case que votre adversaire.");
		} catch (JouerDeuxFoisException e) {}
		catch (CoordonneesFaussesException e) {}
		catch (PlaceDejaPriseException e) {
			assertTrue(true);
		}
	}

	
	//histoire 4
	public void testIs_Initialised(){
		Yinsh tstYinsh = new Yinsh();
		assertFalse(tstYinsh.is_initialized());
	}
	
	//histoire 5
	public void testPutMarker() throws JouerDeuxFoisException, CoordonneesFaussesException, PlaceDejaPriseException{
		Yinsh tstYinsh = new Yinsh();
		
		try {
			tstYinsh.put_marker('C', 7, Yinsh.Color.BlackMark);
			assertTrue(true);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	
}
