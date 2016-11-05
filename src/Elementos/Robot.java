package Elementos;
//CORREGIDO -> Ver calcularDirecciones

import java.util.ArrayList;

import Armamento.Bomba;
import Armamento.Municion;
import Armamento.Radar;
import Bonus.BonusBateria;
import Bonus.BonusEscudo;
import Configuracion.Config;
import Core.Escenario;
import Core.Movible;
import Core.Posicion;
import Core.Tamanio;
import Interfaces.RadarListener;

/**
 * Clase abstracta que generaliza el funcionamiento de los diferentes robots.
 * Este robot genérico implementa una estrategia de juego muy simple que deberá
 * ser especializada por los robots de cada equipo del juego.
 * 
 * @author Krmpotic-Saiegg
 *
 */
public abstract class Robot extends Movible implements RadarListener {

	private String equipo;
	private Refugio refugio;
	private int nivelEscudo;
	private int nivelEnergia;
	private Radar radar;
	private boolean persona;
	private int cantidadMuniciones;
	private int cantidadBombas;
	private int danio;
	private int direccionDisparo;
	private int direccionBomba;
	private ArrayList<Elemento>detectados;
	
	//Constructor privado que setea las variables iniciales
	private Robot(){
		super();
		this.setPosicion(new Posicion(0,0));
		this.setTamanio(new Tamanio(Config.ROBOT_ANCHO ,Config.ROBOT_ALTO));
		this.radar = new Radar(this);
		this.persona = false;
		this.cantidadMuniciones = Config.ROBOT_MUNICIONES;
		this.cantidadBombas = Config.ROBOT_BOMBAS;
		this.danio = Config.ROBOT_DANIO;
		this.direccionDisparo = this.getDireccion();
		this.direccionBomba = this.getDireccion();
		this.detectados = new ArrayList<Elemento>();
		this.radar.addRadarListener(this);
		this.nivelEnergia = Config.ROBOT_ENERGIA;
		this.nivelEscudo = Config.ROBOT_ESCUDOS;
	}
	
	/**
	 * Constructor que debe recibir un String parametrizado con el nombre del equipo
	 * 
	 * @param equipo
	 */
	public Robot(String equipo){
		this();
		this.equipo = equipo;
		this.refugio = new Refugio(equipo);
	}
	
	public String getEquipo() {
		return this.equipo;
	}

	/**
	 * Método que devuelve el nivel actual de escudos que protegen al robot
	 * 
	 * @return Valor entero con el nivel de escudos
	 */
	public int getNivelEscudo() {
		return this.nivelEscudo;
	}

	public int getNivelEnergia() {
		return this.nivelEnergia;
	}

	public Refugio getRefugio() {
		return refugio;
	}

	public void setRefugio(Refugio refugio) {
		this.refugio = refugio;
	}

	public boolean getPersona() {
		return this.persona;
	}

	public void setPersona(boolean persona) {
		this.persona = persona;
	}

	public int getCantidadMuniciones() {
		return this.cantidadMuniciones;
	}

	public int getCantidadBombas() {
		return this.cantidadBombas;
	}
	
	public int getDanio() {
		return this.danio;
	}
	
	public Radar getRadar(){
		return this.radar;
	}

	public void dispararMunicion(int direccion){
		Escenario.getEscenario().addElemento(new Municion(this, direccion));
		this.cantidadMuniciones--;
	}

	public void lanzarBomba(Robot robot, int direccion){
		Escenario.getEscenario().addElemento(new Bomba(this, direccion));
		this.cantidadBombas--;
	}
	
	public void cargarPersona(){
		this.setPersona(true);
	}
	
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {
		this.detectados = elementos;
		//System.out.println(String.format("Robot %s detectó elementos", this.equipo));
	}
	
	@Override
	/**
	 * Método que permite avanzar ubicando el robot en su nueva ubicación teniendo en cuenta
	 * la dirección y velocidad del mismo. Cada vez que avanza, decrementa su nivel de energía
	 * y, si carga a una persona, el consumo se duplica.
	 */
	public void avanzar() {
		super.avanzar();
		if (this.persona){
			this.nivelEnergia--;
		}
		this.nivelEnergia--;
	}
	
	@Override
	public void chocarContra(Elemento elemento) {
		if (elemento instanceof Refugio){
			Refugio r = (Refugio) elemento;
			if (r.getEquipo() != this.getEquipo()){
				if (r.getPersonas()>0){
					this.cargarPersona();
					this.nivelEscudo -= r.getDanio(); 
				}
			} else{
				this.persona = false;
			}
		}
		if (elemento instanceof ZonaRescate){
			if (!this.persona){
				cargarPersona();
			}
		}
		if (elemento instanceof Satelite){
			Satelite s = (Satelite)elemento;
			if (s.getEquipo() != this.getEquipo()){
				this.nivelEscudo--;
			}
		}
		if (elemento instanceof Robot){
			Robot r = (Robot)elemento;
			if (r.getEquipo() != this.getEquipo()){
				this.nivelEscudo -= r.getDanio();
			}
		}
		if (elemento instanceof Municion){
			Municion m = (Municion)elemento;
			this.nivelEscudo -= m.getDanio();
		}
		if (elemento instanceof Bomba){
			Bomba b = (Bomba)elemento;
			this.nivelEscudo -= b.getDanio();
		}
		if (elemento instanceof BonusBateria){
			BonusBateria b = (BonusBateria)elemento; 
			this.nivelEnergia += b.getEnergia();	// TODO [CORRECCION] Usar valores del objeto
		}
		if (elemento instanceof BonusEscudo){
			BonusEscudo b = (BonusEscudo)elemento;
			this.nivelEscudo += b.getEscudo();	// TODO [CORRECCION] Usar valores del objeto
		}
	}
	
	@Override
	public void jugar() {
		if (this.estaVivo()){
			this.radar.escanear();
			this.calcularDirecciones();
			//this.definirEstrategia();
			if (this.nivelEnergia > 0){
				this.avanzar();
			}
		}else{
			this.destruir();
		}
	}

	private void calcularDirecciones() {
		// TODO Calcular direcciones en base a los elementos detectados
		
	}

	public void definirEstrategia() {
		if (this.cantidadMuniciones > 0){
			this.dispararMunicion(this.direccionDisparo);
		}
		if (this.cantidadBombas > 0){
			if ((Math.random()*10)>9.0){
				this.lanzarBomba(this, this.getDireccion());
			}
		}
	}

	public ArrayList<Elemento> getElementosDetectados() {
		return this.detectados;
	}

	@Override
	public String toString() {
		return "Robot " + this.equipo + ": Escudos=" + this.nivelEscudo + ", Energía=" + this.nivelEnergia +
				", Municiones=" + this.cantidadMuniciones + ", Bombas=" + this.cantidadBombas +
				", Posición=" + this.getPosicion();
	}
}