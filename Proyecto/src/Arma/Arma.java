package Arma;

import Disparo.Disparo;
import Disparo.DisparoEnemigo;
import Entidad.Entidad;
import Entidad.Personaje;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Arma extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected int			cadenciaDisparo; // determina cada cuantos MILISEGUNDOS se puede disparar.
	protected long			tiempoUltimoDisparo;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected abstract Disparo crearDisparo( Personaje p );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getCadenciaDisparo( )
	{
		return cadenciaDisparo;
	}
	
	public void setCadenciaDisparo( int tiempoEntreDisparosMS )
	{
		cadenciaDisparo = tiempoEntreDisparosMS;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Este método inicializa la variable tiempoUltimoDisparo con un delay aleatorio entre 0 y 1000 miliegundos,
	 * de esta forma nos aseguramos de que los enemigos no disparen todos a la vez.
	 */
	protected void inicializar( )
	{
		tiempoUltimoDisparo = System.nanoTime() + (rand.nextInt(1000) * 1000000);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Disparo lanzarDisparo(Personaje p)
	{
		Disparo disp			= null;
		long	tiempoActual	= System.nanoTime(),
				tiempoFinal		= tiempoUltimoDisparo + (cadenciaDisparo * 1000000);
		
		// Si entre el último disparo y este intento pasó el tiempo mínimo establecido por la cadencia de disparo, entonces disparar.
		if(tiempoActual >= tiempoFinal)
		{
			tiempoUltimoDisparo = System.nanoTime();
			
			disp = crearDisparo( p );
		}
		
		return disp;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion )
	{
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////