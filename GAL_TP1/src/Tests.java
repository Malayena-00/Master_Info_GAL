//import Yinsh.*;
import junit.framework.*;

public class Tests extends TestCase{
	public Tests(String name){
		super(name);
	}
	

	public void testCurrentColor(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.current_color() == Yinsh.Color.BLACK || tstYinsh.current_color() == Yinsh.Color.WHITE);
	}

	public void testPutRing(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.put_ring('B', 3, Yinsh.Color.BLACK));
	}

	public void testCountRing(){
		Yinsh tstYinsh = new Yinsh();
		
		assertTrue(tstYinsh.CountRings() == 0);
		
		tstYinsh.put_ring('C', 9, Yinsh.Color.WHITE);
		
		assertTrue(tstYinsh.CountRings() == 1);
	}
	
	public void testCoordonnees(){
		Yinsh tstYinsh = new Yinsh();
		
		try{
		assertTrue(tstYinsh.put_ring('Z', 12, Yinsh.Color.BLACK));
		}catch(AssertionFailedError e){
			System.out.println(e);
		}
	}
}
