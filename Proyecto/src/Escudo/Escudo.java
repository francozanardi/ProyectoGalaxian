package Escudo;

import Entidad.Entidad;
import Entidad.EntidadConVida;

public abstract class Escudo extends Entidad
{
	protected EntidadConVida holder;
	
	public double modificarDmg( double dmg )
	{
		return dmg;
	}
}
