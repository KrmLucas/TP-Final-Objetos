
import java.util.ArrayList;

//TODO: revisar la necesidad o no de implementar la interface, teniendo en cuenta que el Radar ya la detecta.  

public class Satelite extends Elemento implements RadarListener {

	private Radar radar;
	private int nivelEscudo;
	private int cantidadMuniciones;
	
	//Constructor
	public Satelite (){
		super(1, 1, 1, 1); //TODO: resolver como se setean posicion y tamaño
		this.cantidadMuniciones = 10;
		this.nivelEscudo = 10;
		this.radar = new Radar();
	}
	
	public void disparar (){
		//TODO: definir que es una munición si bomba o misíl y como se define la dirección
		this.setCantidadMuniciones(this.getCantidadMuniciones()-1);
	}
	
	//Implementacion del listener
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {

		System.out.println("Satelite detecto elementos");
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
		if (elemento instanceof Misil || elemento instanceof Bomba) {
			this.setNivelEscudo(this.getNivelEscudo()-1);
		}
	}

	@Override
	public boolean estaVivo() {
		return this.nivelEscudo > 0;	
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
