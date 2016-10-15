
import java.util.Random;
/**
 * Clase abstracta de la que heredan los dos tipos de bonus requeridos en el juego (BonusBater�a - BonusEscudo)
 * @author Krmpotic-Saiegg
 *
 */
public abstract class Bonus extends Elemento {

	private int tiempoDeVida;
	static Random rand = new Random();

	//TODO: limitar el random en funcion de las dimensiones del escenario
	public Bonus (){
		super (); 
		this.tiempoDeVida = 50; // cantidad de turnos
		Posicion posicion = new Posicion(rand.nextInt(), rand.nextInt());
		Tamanio tamanio = new Tamanio(Config.BONUS_ANCHO, Config.BONUS_ALTO);
		this.setPosicion(posicion);
		this.setTamanio(tamanio);
	}
	/**
	 * M�todo implementado en las subclases
	 */
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
	}
	/**
	 * M�todo implementado en las subclases
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Tiempo de vida es la "cantidad de turnos" en los que estar� disponible el Bonus 
	 * @param tiempoDeVida
	 */
	public void setTiempoDeVida (int tiempoDeVida){
		this.tiempoDeVida = tiempoDeVida;
	}

	public int getTiempoDeVida (){
		return tiempoDeVida;
	}

}
