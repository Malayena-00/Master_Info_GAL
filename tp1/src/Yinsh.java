
public class Yinsh {

	public enum Color{
		BLACK, WHITE, NULL, UNEXISTING
	}


	Color[][] plateauYinsh = new Color[11][11];


	public Yinsh(){
		for (int i=0; i<11; i++){
			for (int j=0; j<11; j++){
				plateauYinsh[i][j]=Color.NULL;
			}
		}

	}


	public Color current_color(){

		double random = Math.random();
		if(random <= 0.5){
			return Color.WHITE;
		}else{
			return Color.BLACK;
		}

	}

	public boolean tetsPUT(char coord_x, int coord_y, Color couleur){

		if(plateauYinsh[coord_x-'A'][coord_y] == couleur){
			return true;
		}else{
			return false;
		}

	}


	public boolean put_ring(char coord_x, int coord_y, Color couleur){
		plateauYinsh[coord_x-'A'][coord_y] = couleur;
		return true;
	}

	
	/*public int put_ring(char coord_x, int coord_y, Color couleur){
		int nb_anneau=0;
		plateauYinsh[coord_x-'A'][coord_y] = couleur;
		for (int i=0; i<11; i++){
			for (int j=0; j<11; j++){
				if (plateauYinsh[i][j] != Color.NULL){
					nb_anneau +=1;
				}
			}
			return nb_anneau;
		}	
	
	*/

	/*public static void main(String args[]){
		put_ring('C',2,Yinsh.Color.WHITE);
		System.out.println(tetsPUT('C',2,Yinsh.Color.BLACK));
	}*/

}

/* Initialisation du plateau de Yinsh 

for (int i=0; i<11; i++){
	for (int j=0; j<11; j++){
		plateauYinsh[i][j]=Color.NULL;
	}
}
*/