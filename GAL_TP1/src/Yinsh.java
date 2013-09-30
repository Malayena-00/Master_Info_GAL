
public class Yinsh {

	Color[][] plateauYinsh = new Color[11][11];

	public Yinsh(){
		for (int i = 0; i < plateauYinsh.length; i++){
			for (int j = 0; j < plateauYinsh.length; j++){
				plateauYinsh[i][j] = Color.NULL;
			}
		}
		
		plateauYinsh[0][0] = Color.UNEXISTING;
		plateauYinsh[0][5] = Color.UNEXISTING;
		plateauYinsh[5][0] = Color.UNEXISTING;
		plateauYinsh[5][11] = Color.UNEXISTING;
		plateauYinsh[11][5] = Color.UNEXISTING;
		plateauYinsh[11][11] = Color.UNEXISTING;
	}

	public enum Color{
		BLACK, WHITE, NULL, UNEXISTING
	}

	public Color current_color(){
		double random = Math.random();
		if(random <= 0.5){
			return Color.WHITE;
		}else{
			return Color.BLACK;
		}
	}

	public boolean put_ring(char coord_x, int coord_y, Color couleur){
		plateauYinsh[coord_x-'A'][coord_y] = couleur;
		return true;
	}

	public int CountRings(){
		int nb = 0;
		for (int i = 0; i < plateauYinsh.length; i++){
			for (int j = 0; j < plateauYinsh.length; j++){
				if (plateauYinsh[i][j] == Color.WHITE || plateauYinsh[i][j] == Color.BLACK){
					nb++;
				}
			}
		}
		
		return nb;
	}
}
