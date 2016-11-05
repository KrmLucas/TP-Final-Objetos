package Elementos;
//CORREGIDO

import java.util.Random;

import Armamento.Bomba;
import Armamento.Municion;
import Configuracion.Config;
import Core.Posicion;
import Core.Tamanio;
/**
 * Clase abstracta de la que heredan los dos tipos de bonus requeridos en el juego (BonusBatería - BonusEscudo)
 * @author Krmpotic-Saiegg
 *
 */
public abstract class Bonus extends Elemento {

	private int tiempoDeVida;
	private static Random randX = new Random(Config.ESCENARIO_ANCHO); //TODO [CORRECCION] Agregar nivel de accesibilidad (private)
	private static Random randY = new Random(Config.ESCENARIO_ALTO);

	//TODO: limitar el random en funcion de las dimensiones del escenario
	public Bonus (){
		super (); 
		//TODO [CORRECCION] Tiene una clase Config, utilizarla para estos valores fijos.
		this.tiempoDeVida = Config.BONUS_VIDA; // cantidad de turnos
		Posicion posicion = new Posicion(randX.nextInt(), randY.nextInt());
		Tamanio tamanio = new Tamanio(Config.BONUS_ANCHO, Config.BONUS_ALTO);
		this.setPosicion(posicion);
		this.setTamanio(tamanio);
	}
	
	/**
	 * Método que descuenta tiempo de vida al bonus hasta llegar a 0,
	 * momento en el cual el bonus se destruye
	 */
	@Override
	public void jugar() {
		
		if (this.estaVivo()){
			this.tiempoDeVida--;
		}
		if (this.tiempoDeVida == 0){
			this.destruir();
		}
	}
	
	/**
	 * Método implementado en las subclases
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		if (elemento instanceof Municion | elemento instanceof Robot |elemento instanceof Bomba){
			this.destruir();
		}
	}
	
	/**
	 * Tiempo de vida es la "cantidad de turnos" en los que estará disponible el Bonus 
	 * @param tiempoDeVida
	 */
	public void setTiempoDeVida (int tiempoDeVida){
		this.tiempoDeVida = tiempoDeVida;
	}

	/**
	 * 
	 * @return Devuelve el tiempo de vida del bonus en el escenario
	 */
	public int getTiempoDeVida (){
		return tiempoDeVida;
	}
}