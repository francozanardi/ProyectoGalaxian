package Obstaculo;

import Entidad.EntidadConVida;
import PowerUp.PowerUp;



public abstract class Obstaculo extends EntidadConVida
{

	protected PowerUp powerup;
	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
	}
	
	public void morir( ) {		
		powerup.caer( pos.clone() );
	}
	
}