package Escudo;

import Entidad.Entidad;
import Entidad.EntidadConVida;
import visitor.Visitor;



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

	public void accept(Visitor col)
	{
	}
	
	public void actualizar( double msDesdeUltAct )
	{		
	}
}