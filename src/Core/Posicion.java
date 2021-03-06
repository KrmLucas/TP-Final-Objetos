package Core;
/**
 * Clase creada para manejar las posiciones de los Elementos dentro del Escenario como coordenadas x, y 
 * @author Krmpotic-Saiegg
 *
 */
public class Posicion {

	private int x;
	private int y;
	
	
	public Posicion (int x, int y){
		this.x = x;
		this.y = y; 
	}
	
	//Comparadores de posicion
	/*public boolean mayor (Posicion elemento){
		return (this.getY() >= elemento.getX() && this.getY() >= elemento.getY());
	}
	public boolean menor(Posicion elemento){
		return(this.getX() <= elemento.getX() && this.getY() <= elemento.getY());
	}*/

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

