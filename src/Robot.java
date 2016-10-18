import java.util.ArrayList;

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
	private ArrayList<Elemento>elementosDetectados;
	
	private Robot(){
		super();
		this.setTamanio(new Tamanio(ConfigOld.ROBOT_ANCHO ,ConfigOld.ROBOT_ALTO));
		this.radar = new Radar(this);
		this.persona = false;
		this.cantidadMuniciones = ConfigOld.ROBOT_MUNICIONES;
		this.cantidadBombas = ConfigOld.ROBOT_BOMBAS;
		this.danio = ConfigOld.ROBOT_DANIO;
	}
	
	public Robot(String equipo){
		this();
		this.equipo = equipo;
		this.refugio = new Refugio(equipo);
	}
	
	public String getEquipo() {
		return this.equipo;
	}

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

	public ArrayList<Elemento> getElementosDetectados() {
		return elementosDetectados;
	}

	public void setElementosDetectados(ArrayList<Elemento> elementosDetectados) {
		this.elementosDetectados = elementosDetectados;
	}

	public void dispararMunicion(Robot robot, int direccion){
		new Municion(robot, direccion);
		this.cantidadMuniciones--;
	}

	public void lanzarBomba(Robot robot, int direccion){
		new Bomba(robot, direccion);
		this.cantidadBombas--;
	}
	
	public void cargarPersona(){
		this.setPersona(true);
	}
	
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {
		this.setElementosDetectados(elementos);
		System.out.println(String.format("Robot %s detectó elementos", this.equipo));
	}

	@Override
	public void avanzar() {
		this.setPosicion(Calculos.getNewPosicion(this.getPosicion(), 
				this.getDireccion(), ConfigOld.ROBOT_VELOCIDAD));
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
			this.nivelEnergia += ConfigOld.BONUS_ENERGIA;
		}
		if (elemento instanceof BonusEscudo){
			this.nivelEscudo += ConfigOld.BONUS_ESCUDO;
		}
	}
	
	@Override
	public void jugar() {
		if (this.estaVivo()){
			this.radar.escanear();
			this.definirEstrategia();
			if (this.nivelEnergia > 0){
				this.avanzar();
			}
		}else{
			this.destruir();
		}
	}

	public void definirEstrategia() {
		if (this.cantidadMuniciones > 0){
			this.dispararMunicion(this, this.getDireccion());
		}
		if (this.cantidadBombas > 0){
			if ((Math.random()*10)>9.0){
				this.lanzarBomba(this, this.getDireccion());
			}
		}
	}

	@Override
	public String toString() {
		return "Robot " + equipo + ": Escudos=" + nivelEscudo + ", Energía=" + nivelEnergia
				+ ", Municiones=" + cantidadMuniciones + ", Bombas=" + cantidadBombas + "]";
	}
	
	
}