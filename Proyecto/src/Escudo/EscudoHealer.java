package Escudo;

import Entidad.EntidadConVida;

public class EscudoHealer extends Escudo
{
	private final double HEAL_POR_SEG = 10;
	
	public EscudoHealer( EntidadConVida holder )
	{
		this.holder = holder;
	}

	public void actualizar(double msDesdeUltActualizacion)
	{
		double curacion = conversionEnTiempo( HEAL_POR_SEG, msDesdeUltActualizacion );
		holder.setVida( holder.getVida() + curacion );
	}
	

}
