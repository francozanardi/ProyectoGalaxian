package Logica;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;



public class Teclado
{
	private int teclaIzquierda,
				teclaDerecha,
				teclaDisparo,
				teclaPausa;
	
	private boolean pausa;
	
	private Set<Integer>	teclasApretadas;
	private Juego			juego;



	public Teclado( Juego juego )
	{
		this.juego		= juego;
		
		teclaIzquierda	= KeyEvent.VK_LEFT;
		teclaDerecha	= KeyEvent.VK_RIGHT;
		teclaDisparo	= KeyEvent.VK_SPACE;
		teclaPausa		= KeyEvent.VK_ESCAPE;
		
		pausa			= false;
		
		teclasApretadas = new HashSet<Integer>();
	}


	
	public int direccionJugador( )
	{
		int dir = 0;
		
		// No utilizamos else porque el jugador podría estar apretando izquierda y derecha a la vez, y en ese caso no debería moverse.
		if ( isPressed(teclaIzquierda) )
			dir --;
		if ( isPressed(teclaDerecha) )
			dir ++;
		
		return dir;
	}


	
	public boolean disparando( )
	{
		return isPressed( teclaDisparo );
	}


	
	public void press( int keyCode )
	{
		teclasApretadas.add( keyCode );
		
		if (keyCode == teclaPausa)
		{
			pausa = !pausa;
			
			juego.pauseGame( pausa );
		}
	}


	
	public void release( int keyCode )
	{
		teclasApretadas.remove( keyCode );
	}


	
	public boolean isPressed( int keyCode )
	{
		return teclasApretadas.contains( keyCode );
	}
}