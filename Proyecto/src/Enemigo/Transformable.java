package Enemigo;

import Colisiones.Colisionador;
import Enemigo.Estados.Estado;
import Inteligencia.Inteligencia;
import Mapa.Mapa;

public abstract class Transformable extends Enemigo {
	protected Estado estado;
	protected double explosionDmg;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Inteligencia getInteligencia() {
		return ia;
	}
	
	public void setInteligencia(Inteligencia ia) {
		this.ia = ia;
	}
	
	public Mapa getMapa() {
		return map;
	}
	
	public double getExplosionDmg() {
		return explosionDmg;
	}
	
	public void setExplosionDmg(double dmg) {
		this.explosionDmg = dmg;
	}
	
	public void setColisionador(Colisionador col) {
		colisionador = col;
	}
	
	public abstract void choque();
	
}
