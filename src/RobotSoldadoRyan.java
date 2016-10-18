
public class RobotSoldadoRyan extends Robot{

	private static final double LIMITE_ESCUDOS = 0.4;
	
	public RobotSoldadoRyan(String equipo) {
		super(equipo);
	}
	
	@Override
	public void jugar(){
		super.jugar();
	}

	@Override
	public void definirEstrategia() {
		int nivelMinimoEscudos = (int) Math.round(ConfigOld.ROBOT_ESCUDOS * LIMITE_ESCUDOS);
		boolean buscaEscudos = false;
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
			} else if ((e instanceof BonusEscudo) && buscaEscudos){
				BonusEscudo b = (BonusEscudo)e;
				direccion = Calculos.direccion(this.getPosicion(), b.getPosicion());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(this, direccion);
				}
				this.setDireccion(direccion);
			} else{
				evadir(e);
			}
			if (!buscaEscudos){
				if (this.getPersona()){
					direccion = Calculos.direccion(this.getPosicion(), this.getRefugio().getPosicion());
				} else{
					//Zona de rescate
					int x = (int)Math.round(ConfigOld.ESCENARIO_ANCHO/2);
					int y = (int)Math.round(ConfigOld.ESCENARIO_ALTO/2);
					Posicion p = new Posicion(x, y);
					direccion = Calculos.direccion(this.getPosicion(), p);
				}
				this.setDireccion(direccion);
			}
		}
	}

	private void evadir(Elemento e) {
		// TODO Auto-generated method stub
		
	}
}