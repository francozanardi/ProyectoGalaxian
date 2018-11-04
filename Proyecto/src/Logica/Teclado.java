package Logica;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;



public class Teclado
{
	private int teclaIzquierda,
				teclaDerecha,
				teclaDisparo;
	
	private Set<Integer> teclasApretadas;



	public Teclado( )
	{		
		teclaIzquierda	= KeyEvent.VK_LEFT;
		teclaDerecha	= KeyEvent.VK_RIGHT;
		teclaDisparo	= KeyEvent.VK_SPACE;
		
		teclasApretadas = new HashSet<Integer>(); //necesitamos una estructura que no pueda tener elementos repetidos, por eso set
	}


	
	public int direccionJugador( )
	{
		int dir = 0;
		
		// No utilizamos else porque el jugador podr�a estar apretando izquierda y derecha a la vez, y en ese caso no deber�a moverse.
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