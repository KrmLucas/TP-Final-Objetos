
public class RobotSoldadoRyan extends Robot{

	private static final double LIMITE_ESCUDOS = 0.4;
	
	public RobotSoldadoRyan(String equipo) {
		super(equipo);
	}
	
	@Override
	public void definirEstrategia() {
		int nivelMinimoEscudos = (int) Math.round(Config.ROBOT_ESCUDOS * LIMITE_ESCUDOS);
		boolean buscaEscudos = false;
		boolean evade = false;
		int direccion;
		
		if (this.getNivelEscudo() < nivelMinimoEscudos){
			buscaEscudos = true;
		}
		for(int i=0; i<this.getElementosDetectados().size();i++){
			Elemento e = this.getElementosDetectados().get(i);
			if (e instanceof Bomba){
				Bomba b = (Bomba)e;
				Posicion np = Calculos.getNewPosicion(b.getPosicion(), b.getDireccion(), b.getVelocidad());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(this, Calculos.direccion(this.getPosicion(), np));
				}
				evadir(b);
				evade = true;
			} else if ((e instanceof BonusEscudo) && buscaEscudos){
				BonusEscudo b = (BonusEscudo)e;
				direccion = Calculos.direccion(this.getPosicion(), b.getPosicion());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(this, direccion);
				}
				this.setDireccion(direccion);
			} else{
				evadir(e);
				evade = true;
			}
			if (!(buscaEscudos || evade)){
				if (this.getPersona()){
					direccion = Calculos.direccion(this.getPosicion(), this.getRefugio().getPosicion());
				} else{
					//Zona de rescate
					int x = (int)Math.round(ConfigOldBorrar.ESCENARIO_ANCHO/2);
					int y = (int)Math.round(ConfigOldBorrar.ESCENARIO_ALTO/2);
					Posicion p = new Posicion(x, y);
					direccion = Calculos.direccion(this.getPosicion(), p);
				}
				this.setDireccion(direccion);
			}
		}
	}

	//Setea una nueva dirección para evadir el elemento detectado
	private void evadir(Elemento e) {
		int direccion = this.getDireccion();
		//TODO Mejorar cálculo de dirección 
		if (e instanceof Bomba){
			Bomba b = (Bomba) e;
			direccion = b.getDireccion();
		}
		if (e instanceof Municion){
			Municion m = (Municion) e;
			direccion = m.getDireccion();
		}
		this.setDireccion(direccion+45);
	}
}