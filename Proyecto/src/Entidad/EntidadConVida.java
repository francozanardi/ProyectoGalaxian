package Entidad;

import Colisiones.Colisionador;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Jugador.Jugador;

public abstract class EntidadConVida extends Entidad
{
	
	protected float			vida;
	
	public void setVida(float vida) {
		this.vida = vida;
	}
	
	public float getVida() {
		return vida;
	}
	
}
