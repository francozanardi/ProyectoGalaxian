package Proyecto;

public abstract class Personaje extends EntidadConVida{
	protected Arma arma;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void mover( );
	
	public Posicion getPos() {
		return pos;
	}
	
	public Disparo lanzarDisparo() {
		return arma.lanzarDisparo(this);
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public abstract void hacerDMG(Colisionador c, EntidadConVida receptor, Disparo disparo);
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}
