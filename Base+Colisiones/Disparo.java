package Proyecto;

public abstract class Disparo extends Entidad{
	protected float fuerza;
	protected float velocidad;
	protected Personaje lanzador;
	
	public void avanzar() {
		pos.setY(pos.getY()+5);
		actualizarPosicion();
	}
	
	public Personaje getLanzador() {
		return lanzador;
	}
	
	public float getFuerza() {
		return fuerza;
	}
}
