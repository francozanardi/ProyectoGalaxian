package Controladores;

import Jugador.Jugador;
import Logica.Juego;
import Logica.MainThread;
import Mapa.Mapa;
import Tienda.Item;



public abstract class ControladorNiveles
{
	protected MainThread	thread;
	protected int			nivel;
	protected Juego			juego;
	protected Jugador		jugador;
	
	
	public abstract void mapVictory( Jugador player );
	public abstract void mapDefeat( Jugador player );
	public abstract void siguienteNivel(Item compra);
	
	public abstract void gameStart( );
	public abstract void gameEnd( );
	
	
	
	public final void togglePause( boolean pause )
	{
		if(thread != null) {
			thread.togglePause( pause );
		}
	}
	
	
	
	protected void startMap( Mapa map )
	{
		thread = new MainThread( map, Juego.GAME_FPS );
		thread.start();
	}
	
	protected void stopMap( )
	{
		if (thread != null && thread.isAlive())
		{
			thread.terminar();
			thread = null;
		}
	}
}
