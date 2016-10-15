
import java.util.Random;
/**
 * Clase abstracta de la que heredan los dos tipos de bonus requeridos en el juego (BonusBatería - BonusEscudo)
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
	 * Método implementado en las subclases
	 */
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
	}
	/**
	 * Método implementado en las subclases
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Tiempo de vida es la "cantidad de turnos" en los que estará disponible el Bonus 
	 * @param tiempoDeVida
	 */
	public void setTiempoDeVida (int tiempoDeVida){
		this.tiempoDeVida = tiempoDeVida;
	}

	public int getTiempoDeVida (){
		return tiempoDeVida;
	}

}
