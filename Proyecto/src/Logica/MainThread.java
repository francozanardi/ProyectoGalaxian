package Logica;

import Mapa.Mapa;



public class MainThread extends Thread
{
	private Mapa	mapa;
	private int		fps;
	private boolean ejecutando;


	
	public MainThread( Mapa mapa, int fps )
	{
		this.ejecutando	= true;
		this.mapa		= mapa;
		this.fps		= fps;
	}


	
	public void terminar( )
	{
		ejecutando = false;
	}
	
	
	
	public int getFPS( )
	{
		return this.fps;
	}
	
	public void setFPS( int fps )
	{
		this.fps = fps;
	}


	
	public void run( )
	{
		long	tiempoActual	= System.nanoTime(),
				tiempoFinal		= tiempoActual + (1000000L * 1000L / fps),
				tiempoUltima	= tiempoActual;
		
		while (ejecutando)
		{
			tiempoActual = System.nanoTime();
			
			if (tiempoActual >= tiempoFinal)
			{
				tiempoFinal = tiempoActual + (1000000L * 1000L / fps);
									
				// Actualizaciones del juego, le pasamos la cantidad de MS transcurridos desde la última actualización
				cicloDelJuego( (tiempoActual - tiempoUltima) / 1000000.0 );

				tiempoUltima = tiempoActual;
				
				try
				{
					tiempoActual = (tiempoFinal - System.nanoTime());
					long	sleepTimeMS = (tiempoActual) / 1000000L,
							sleepTimeNS = (tiempoActual) % 1000000L;
					
					if (sleepTimeMS >= 0 && sleepTimeNS >= 0)
						Thread.sleep( sleepTimeMS, (int) sleepTimeNS );
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		mapa.limpiarMapa();
	}


	
	private void cicloDelJuego( double msDesdeUltActualizacion )
	{
		mapa.actualizar( msDesdeUltActualizacion );
	}
}