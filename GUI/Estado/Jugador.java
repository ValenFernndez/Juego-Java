package Estado;

public class Jugador{
	private int score = 0;
	public String nombre[] = {"_","_","_"};

	public void setNombre(int i, char l){
		nombre[i] = String.valueOf(l);
	}
	public String getChar(int i){
		return String.valueOf(nombre[i]);
	}
	public String getNombre(){
		return nombre[0]+nombre[1]+nombre[2];
	}
	public void setScore(int s){
		score += s;
	}
	public int getScore(){
		return score;
	}
}