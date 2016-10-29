
public class RobotRencoroso extends Robot{

	public RobotRencoroso(String equipo) {
		super(equipo);
	}
	
	@Override
	public void definirEstrategia(){
		int direccion = (int)Math.round(Math.random()*1000)%360; //Dirección aleatoria
	
		for(int i=0; i<this.getElementosDetectados().size();i++){
			Elemento e = this.getElementosDetectados().get(i);
			if (e instanceof Robot){
				Robot r = (Robot)e;
				Posicion np = Calculos.getNewPosicion(r.getPosicion(), r.getDireccion(), r.getVelocidad());
				direccion = Calculos.direccion(this.getPosicion(), np);
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(this, Calculos.direccion(this.getPosicion(), np));
				}
				this.setDireccion(direccion);
			} else if (e instanceof Bonus){
				Bonus b = (Bonus)e;
				int direccionDisparo = Calculos.direccion(this.getPosicion(), b.getPosicion());
				if (this.getCantidadMuniciones()>0){
					this.dispararMunicion(this, direccionDisparo);
				}
			}
		}
	}
}