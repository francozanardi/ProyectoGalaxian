
public class MainThread extends Thread
{
	private Mapa mapa;
	private int fps;
	
	public MainThread( Mapa mapa, int fps )
	{
		this.mapa = mapa;
		this.fps = fps;
	}

	public void run( )
	{
		long	tiempoActual = System.nanoTime(),
				tiempoFinal = tiempoActual + (1000000 * 1000 / fps);
		int i = 0;
		
		while (true)
		{
			tiempoActual = System.nanoTime();
			//System.out.println( tiempoActual + ", " + tiempoFinal);
			if (tiempoActual >= tiempoFinal)
			{
				tiempoFinal = tiempoActual + (1000000 * 1000 / fps);
				
				System.out.println( i );
				i ++;
				
				mapa.actualizar();
			}
		}
	}
}
