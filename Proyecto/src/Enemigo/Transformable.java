package Enemigo;

import Colisiones.Colisionador;
import Enemigo.Estados.Estado;
import Inteligencia.Inteligencia;
import Mapa.Mapa;

public abstract class Transformable extends Enemigo {
	protected Estado estado;
	protected double explosionDmg;
	

	/*
	public void setEstado(Estado estado) { //quitamos que se pueda setear el estado y pusimos un método transformar para evitar que un cliente cambie a cualquier estado.
		this.estado = estado;
	}
	
	*/
	
	public Mapa getMapa() { //Esto se puede quitar haciendo que los estados reciban en su constructor por parámetro el mapa.
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
	
	public abstract void explotar();
	public abstract void transformar();
	
}
