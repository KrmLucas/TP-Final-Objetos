

import java.util.ArrayList;

public class Robot extends Elemento implements RadarListener {

	private String nombre;
	private int nivelEscudo;
	private int nivelEnergia;
	
	public Robot(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelEscudo() {
		return nivelEscudo;
	}


	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}

	public int getNivelEnergia() {
		return nivelEnergia;
	}

	public void setNivelEnergia(int nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}
	
	@Override
	public void elementosDetectados(ArrayList<Elemento> elementos) {
		
		System.out.println(String.format("Robot %s detecto elementos", this.nombre));

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
