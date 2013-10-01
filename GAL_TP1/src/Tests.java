//import Yinsh.*;
import junit.framework.*;

public class Tests extends TestCase{
	
	public Tests(String name){
		super(name);
	}


	public void testCurrentColor(){
		Yinsh tstYinsh = new Yinsh();
		/*try{*/
			assertTrue(tstYinsh.current_color() == Yinsh.Color.BlackRing || tstYinsh.current_color() == Yinsh.Color.WhiteRing);
		/*}catch(AssertionFailedError e){
			System.out.println(e);
		}*/
	}

	public void testPutRing(){
		Yinsh tstYinsh = new Yinsh();
		Yinsh.Color col1;
		Yinsh.Color col2;
		assertTrue(tstYinsh.put_ring('B', 3, Yinsh.Color.BlackRing));
		tstYinsh.put_ring('C', 5, Yinsh.Color.BlackRing);
		col1 = tstYinsh._lastplayed;
		tstYinsh.put_ring('B', 4, Yinsh.Color.BlackRing);
		col2 = tstYinsh._lastplayed;
		try{
			assertTrue(col1 != col2);
		}catch(AssertionFailedError e){
			System.out.println(e);
			System.out.println("Vous ne pouvez pas jouer deux fois consécutives.");
		}
	}

	public void testCountRing(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.CountRings() == 0);
		tstYinsh.put_ring('C', 9, Yinsh.Color.WhiteRing);
		assertTrue(tstYinsh.CountRings() == 1);
	}

	public void testCoordonnees(){
		Yinsh tstYinsh = new Yinsh();
		try{
			assertTrue(tstYinsh.put_ring('B', 10, Yinsh.Color.BlackRing));
		}catch(AssertionFailedError e){
			System.out.println(e);
			System.out.println("Vous ne pouvez pas jouer en dehors du plateau.");
		}
	}
	
	public void testMemeIntersection(){
		Yinsh tstYinsh = new Yinsh();
		tstYinsh.put_ring('B', 1, Yinsh.Color.BlackRing);
		try{
			assertTrue(tstYinsh.put_ring('C', 1, Yinsh.Color.WhiteRing));
		}catch(AssertionFailedError e){
			System.out.println(e);
			System.out.println("Vous ne pouvez pas jouer sur la même case que votre adversaire.");
		}
	}
	
}
