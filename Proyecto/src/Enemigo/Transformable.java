package Enemigo;

import Colisiones.Colisionador;
import Enemigo.Estados.Estado;
import Inteligencia.Inteligencia;
import Mapa.Mapa;

public abstract class Transformable extends Kamikaze {
	protected Estado estado;
		
	public Mapa getMapa() { //Esto se puede quitar haciendo que los estados reciban en su constructor por parámetro el mapa.
		return map;
	}

	
	public void setColisionador(Colisionador col) {
		colisionador = col;
	}
	
	public abstract void transformar();
	
}
