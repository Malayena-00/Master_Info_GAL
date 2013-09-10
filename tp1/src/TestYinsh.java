import junit.framework.*;

public class TestYinsh extends TestCase {
	
	public TestYinsh(String name){ super(name); }
	
	public void testCurrentColor(){
		Yinsh tstYinsh = new Yinsh();
		assertTrue(tstYinsh.current_color() == Yinsh.Color.BLACK 
				|| tstYinsh.current_color() == Yinsh.Color.WHITE);
	}
	
	public void testPutRing(){
		
	}
	
}
