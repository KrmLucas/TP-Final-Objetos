
/**
 * Clase que maneja la Zona de Rescate. Contiene los metodos necesarios para restar personas a medida que 
 * los Robots las van rescatando.
 * @author Krmpotic-Saiegg
 *
 */
public class ZonaRescate extends Elemento{

	private int personas;
	private Posicion posicion;
	
	//TODO [CORRECCION]Falta documentacion  
	
	public ZonaRescate() {
		super ();
		this.getTamanio().setAlto(Config.ZONA_ALTO);
		this.getTamanio().setAncho(Config.ZONA_ANCHO);
		this.posicion = new Posicion(300, 200);
		this.personas = Config.ZONA_CANT_PERS;
	}
	
	public void rescatarPersona(){
		this.setPersonas(this.getPersonas()-1);
	}
	
	public int getPersonas() {
		return personas;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void setPersonas(int personas) {
		this.personas = personas;
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		if (elemento instanceof Robot){
			this.rescatarPersona();
		}
	}
	
	public String toString(){
		return "Zona de Rescate\n"
				+ "Personas por rescatar: " + this.getPersonas();
	}
}
