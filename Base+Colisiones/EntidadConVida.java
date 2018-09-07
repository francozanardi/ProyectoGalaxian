package Proyecto;

public abstract class EntidadConVida extends Entidad{
	
	protected float vida;
	
	public abstract void recibirDMG(Colisionador c, Jugador lanzador, Disparo disparo);
	public abstract void recibirDMG(Colisionador c, Enemigo lanzador, Disparo disparo);
	
	
	public void setVida(float vida) {
		this.vida = vida;
	}
	
	public float getVida() {
		return vida;
	}
}
