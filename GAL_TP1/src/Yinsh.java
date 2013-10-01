public class Yinsh {

	Color[][] _plateauYinsh = new Color[11][11];
	double _random = Math.random();
	Color _lastplayed;

	public Yinsh(){
		for (int i = 0; i < this._plateauYinsh.length; i++){
			for (int j = 0; j < this._plateauYinsh.length; j++){
				this._plateauYinsh[i][j] = Color.NULL;
			}
		}

		this._plateauYinsh[0][0] = Color.UNEXISTING;
		this._plateauYinsh[0][5] = Color.UNEXISTING;
		this._plateauYinsh[5][0] = Color.UNEXISTING;
		this._plateauYinsh[5][10] = Color.UNEXISTING;
		this._plateauYinsh[10][5] = Color.UNEXISTING;
		this._plateauYinsh[10][10] = Color.UNEXISTING;
	}

	public enum Color{
		BlackRing, WhiteRing, NULL, UNEXISTING
	}

	public Color current_color(){
		if(this._random <= 0.5){
			return Color.WhiteRing;
		}else{
			return Color.BlackRing;
		}
	}

	public boolean put_ring(char coord_x, int coord_y, Color couleur){
		if(this._plateauYinsh[coord_x-'A'][coord_y] == Color.NULL){
			this._plateauYinsh[coord_x-'A'][coord_y] = couleur;
			this._lastplayed = couleur;
			return true;
		}else{
			return false;
		}
	}

	public int CountRings(){
		int nb = 0;
		for (int i = 0; i < this._plateauYinsh.length; i++){
			for (int j = 0; j < this._plateauYinsh.length; j++){
				if (this._plateauYinsh[i][j] == Color.WhiteRing || this._plateauYinsh[i][j] == Color.BlackRing){
					nb++;
				}
			}
		}

		return nb;
	}

	/*public static void main(String[] args) {
		Yinsh a = new Yinsh();
		System.out.print(a.plateauYinsh.length);
	}*/
}
