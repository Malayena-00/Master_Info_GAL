public class Yinsh{

	Color[][] _plateauYinsh = new Color[11][11];
	double _random = Math.random();
	Color _lastplayed = Color.NULL;

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
		BlackRing, WhiteRing, BlackMark, WhiteMark, NULL, UNEXISTING
	}

	public Color current_color(){
		if(this._random <= 0.5){
			return Color.WhiteRing;
		}else{
			return Color.BlackRing;
		}
	}

	public void put_ring(char coord_x, int coord_y, Color couleur) throws JouerDeuxFoisException, CoordonneesFaussesException, PlaceDejaPriseException {
		try{
			if(this._plateauYinsh[coord_x-'A'][coord_y] == Color.UNEXISTING){
				throw new CoordonneesFaussesException();
			}
			if(this._plateauYinsh[coord_x-'A'][coord_y] != Color.NULL){
				throw new PlaceDejaPriseException();
			}
			if(couleur != this._lastplayed){
				if(this._plateauYinsh[coord_x-'A'][coord_y] == Color.NULL){
					this._plateauYinsh[coord_x-'A'][coord_y] = couleur;
					this._lastplayed = couleur;
				}
			}else{
				throw new JouerDeuxFoisException();
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CoordonneesFaussesException();
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

	/*
	public static void main(String[] args) {
		Yinsh a = new Yinsh();
		System.out.print(a.plateauYinsh.length);
	}*/

	public int nb_rings (Color couleur){
		int nb = 0;

		for (int i = 0; i < this._plateauYinsh.length; i++){
			for (int j = 0; j < this._plateauYinsh.length; j++){
				if (this._plateauYinsh[i][j] == couleur){
					nb++;
				}
			}
		}
		return nb;
	}

	public boolean is_initialized(){
		if(nb_rings(Color.WhiteRing) == 5 && nb_rings(Color.BlackRing) == 5){
			return true;
		}else{
			return false;
		}
	}

	public void put_marker (char coord_x, int coord_y, Color couleur) throws JouerDeuxFoisException, CoordonneesFaussesException, PlaceDejaPriseException {
		try{
			if(this._plateauYinsh[coord_x-'A'][coord_y] == Color.UNEXISTING){
				throw new CoordonneesFaussesException();
			}
			if(this._plateauYinsh[coord_x-'A'][coord_y] != Color.NULL){
				throw new PlaceDejaPriseException();
			}
			if((couleur == Color.BlackMark && this._plateauYinsh[coord_x - 'A'][coord_y] == Color.WhiteRing) || (couleur == Color.WhiteMark && this._plateauYinsh[coord_x - 'A'][coord_y] == Color.BlackRing)){
				System.out.println("Anneau de la mauvaise couleur");
				throw new CoordonneesFaussesException();
		}
			
		if(couleur != this._lastplayed){
			if(this._plateauYinsh[coord_x-'A'][coord_y] == Color.NULL){
				this._plateauYinsh[coord_x-'A'][coord_y] = couleur;
				this._lastplayed = couleur;
			}
		}else{
			throw new JouerDeuxFoisException();
		}
	}catch(ArrayIndexOutOfBoundsException e){
		throw new CoordonneesFaussesException();
	}
}

public void moveRing(int coord_x_r, int coord_y_r, int coord_x_nr, int coord_y_nr){
	Color couleur = this._plateauYinsh[coord_x_r - 'A'][coord_y_r];
	this._plateauYinsh[coord_x_r - 'A'][coord_y_r] = Color.NULL;
	this._plateauYinsh[coord_x_nr - 'A'][coord_y_nr] = couleur;
}
}
