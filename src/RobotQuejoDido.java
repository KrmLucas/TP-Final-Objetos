
public class RobotQuejoDido extends Robot{
	
	private static final double LIMITE_ENERGIA = 0.2;

	public RobotQuejoDido(String equipo) {
		super(equipo);
	}
	
	@Override
	public void definirEstrategia(){
		int nivelMinimoEnergia = (int) Math.round(Config.ROBOT_ENERGIA * LIMITE_ENERGIA);
		boolean buscaBateria = false;
		int direccion;
		
		if (this.getNivelEnergia() < nivelMinimoEnergia){
			buscaBateria = true;
		}
		this.getRadar().
		for(int i=0; i<this.getElementosDetectados().size();i++){
			Elemento e = this.getElementosDetectados().get(i);
			if ((e instanceof BonusBateria) && buscaBateria){
				BonusBateria b = (BonusBateria)e;
				direccion = Calculos.direccion(this.getPosicion(), b.getPosicion());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(this, direccion);
				}
				this.setDireccion(direccion);
			} else if (e instanceof Robot){
				Robot r = (Robot)e;
				if (r.getPersona()){
					Posicion np = Calculos.getNewPosicion(r.getPosicion(), r.getDireccion(), r.getVelocidad());
					direccion = Calculos.direccion(this.getPosicion(), np);
					if (this.getCantidadMuniciones()>0){
						this.dispararMunicion(this, Calculos.direccion(this.getPosicion(), np));
					}
				}
			}
			merodearZonaRescate();
		}
	}

	private void merodearZonaRescate() {
		// TODO Implementar cálculos para rondar la zona central
		
	}
}
