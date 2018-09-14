package Entidad;

import Colisiones.Colisionador;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Jugador.Jugador;

public abstract class EntidadConVida extends Entidad{
	
	protected float vida;
	protected Colisionador colisionador;
	
	public void setVida(float vida) {
		this.vida = vida;
	}
	
	public float getVida() {
		return vida;
	}
	
	public abstract void serChocado(Colisionador col);
	//{
		//afectar(this);
	//}
	
	public void colisionar(EntidadConVida e) { //agregado
		e.serChocado(colisionador);
	}
}
