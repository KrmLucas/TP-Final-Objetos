import java.util.ArrayList;

public class Robot extends Movible implements RadarListener {

	private String nombre;
	
	private Robot(){
		super();
		this.setTamanio(new Tamanio(Config.ROBOT_ANCHO ,Config.ROBOT_ALTO));
	}
	
	public Robot(String nombre){
		this();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {
		
		System.out.println(String.format("Robot %s detecto elementos", this.nombre));

	}
	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}
}
