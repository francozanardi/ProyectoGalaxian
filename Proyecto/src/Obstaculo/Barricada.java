package Obstaculo;

import Colisiones.Colisionador;



public abstract class Barricada extends Obstaculo
{
	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
	
}