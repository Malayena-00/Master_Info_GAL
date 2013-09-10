
public class Yinsh {
	
	public enum Color{
		BLACK, WHITE
	}
	
	public Color current_color(){
		
		int random = (int)(Math.random());
		
		if(random <= 0.5){
			return Color.WHITE;
		}else{
			return Color.BLACK;
		}
	
	}
	
	public void put_ring(){
		
	}
	
}
