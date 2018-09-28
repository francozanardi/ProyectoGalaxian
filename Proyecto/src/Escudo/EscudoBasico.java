package Escudo;

import Entidad.EntidadConVida;

public class EscudoBasico extends Escudo
{
	public EscudoBasico( EntidadConVida holder )
	{
		this.holder = holder;
	}

	public double modificarDmg(double dmg)
	{
		return dmg / 2.0;
	}

	
	public void actualizar(double msDesdeUltActualizacion)
	{		
	}
	
	
}
