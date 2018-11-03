package Obstaculo;

import Colisiones.Colisionador;



public abstract class Destructible extends Obstaculo
{
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
	
}