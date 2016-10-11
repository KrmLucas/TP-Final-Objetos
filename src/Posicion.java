
public class Posicion {

	private double x;
	private double y;
	
	
	public Posicion (double x, double y){
		this.x = x;
		this.y = y; 
	}
	
	//Comparadores de posicion
	public boolean mayor (Posicion elemento){
		return (this.getY() >= elemento.getX() && this.getY() >= elemento.getY());
	}
	public boolean menor(Posicion elemento){
		return(this.getX() <= elemento.getX() && this.getY() <= elemento.getY());
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}

