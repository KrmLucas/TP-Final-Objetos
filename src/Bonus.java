
import java.util.Random;

public abstract class Bonus extends Elemento {

	private int tiempoDeVida;
	static Random rand = new Random();

	//TODO: limitar el random en funcion de las dimensiones del escenario
	public Bonus (){
		super (); //posicion aleatoria y tamaño by default
		this.tiempoDeVida = 50; // cantidad de turnos
		Posicion posicion = new Posicion(rand.nextInt(), rand.nextInt());
		Tamanio tamanio = new Tamanio(Config.BONUS_ANCHO, Config.BONUS_ALTO);
		this.setPosicion(posicion);
		this.setTamanio(tamanio);
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTiempoDeVida (int tiempoDeVida){
		this.tiempoDeVida = tiempoDeVida;
	}

	public int getTiempoDeVida (){
		return tiempoDeVida;
	}

}
