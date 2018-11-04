package Obstaculo;

import Entidad.EntidadConVida;



public abstract class Obstaculo extends EntidadConVida
{

	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
	}
	
}