package Escudo;

import Colisiones.Colisionador;
import Entidad.Entidad;
import Entidad.EntidadConVida;



public abstract class Escudo extends Entidad
{	
	protected EntidadConVida holder;



	public double modificarDmgExplosion( double dmg )
	{
		return dmg;
	}
	
	public double modificarDmg( double dmg )
	{
		return dmg;
	}
	
	public void remove( )
	{
		holder.removeEscudo( this );
	}

	public void serChocado( Colisionador col )
	{
	}
	
	public void actualizar( double msDesdeUltAct )
	{		
	}
}