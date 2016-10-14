
import java.util.ArrayList;

//TODO: revisar la necesidad o no de implementar la interface, teniendo en cuenta que el Radar ya la detecta.  

public class Satelite extends Elemento implements RadarListener {

	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	//Constructor
	public Satelite (){
		super(); //TODO: resolver como se setean posicion y tamaño
		this.cantidadMuniciones = 10;
		this.nivelEscudo = 10;
		this.radar = new Radar();
	}
	
	//TODO: ver como se define la direccion del disparo (a partir de la posicion del elemento que recibo)
	public void disparar (Elemento e){
		this.setCantidadMuniciones(this.getCantidadMuniciones()-1);
	}
	
	//Implementacion del listener
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {

		for (Elemento e : elementos){
			//TODO: ver tema equipos -> si robot es de mi equipo no le tiro
			if (e instanceof Bonus){
				this.disparar(e);
			}else if (e instanceof Robot){
				this.disparar(e);
			}
		}
	}

	
	//Implementacion de los metodos heredados de la clase abstracta Elemento
	@Override
	public void jugar() {
		
		this.getRadar().escanear(this.getPosicion());
		
		/*TODO: if elemento detectado ==> disparar municion*/
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		// TODO: 
		if (elemento instanceof Municion || elemento instanceof Bomba) {
			this.setNivelEscudo(this.getNivelEscudo()-1);
		}
	}

	//Métodos get y set
	public Radar getRadar() {
		return radar;
	}

	public int getNivelEscudo() {
		return nivelEscudo;
	}

	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}

	public int getCantidadMuniciones() {
		return cantidadMuniciones;
	}

	public void setCantidadMuniciones(int cantidadMuniciones) {
		this.cantidadMuniciones = cantidadMuniciones;
	}

	
}
