package Inteligencia;

import java.util.List;

import Disparo.Disparo;
import Enemigo.Enemigo;



public abstract class IAEnemigo extends Inteligencia
{
	protected Enemigo entidad;
	

	public abstract void mover( double msDesdeUltActualizacion );

	
	public void disparar( )
	{
		List<Disparo> disparos = entidad.getArma().lanzarDisparo( );
		
		// Añadir disparos al mapa
		for (Disparo d : disparos)
			entidad.getMapa().addEntity(d);
	}

}
