

import java.util.ArrayList;

public class Robot implements RadarListener {

	private String nombre;
	
	public Robot(String nombre){
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

}
