package Inteligencia;

import Enemigo.Enemigo;
import Grafica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class IAComun extends Inteligencia
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public IAComun( Mapa map )
	{
		this.map	= map;
		this.rand	= new Randomizador( );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( Enemigo me )
	{
		Posicion pos = me.getPos();
		
		double	x = pos.getX(),
				y = pos.getY();
		
		// Oscilan hacia los costados
		x = x + rand.nextInt(-1, 1);
		
		// Descender obligatoriamente
		y = y + 1; 
		
		// No permitir que se vaya por los costados de la pantalla
		if (x < me.obtenerPanel().getBounds().getWidth()/2)  
			x = me.obtenerPanel().getBounds().getWidth()/2;
		
		// Esto de dividirlo por 2 y multiplicarlo por 2 lo agregué porque el enemigo se iba al borde de la pantalla,
		// un lugar donde el jugador no puede disparar.

		else if (x > Juego.GAME_WIDTH - me.obtenerPanel().getBounds().getWidth()*2)
			x = Juego.GAME_WIDTH - me.obtenerPanel().getBounds().getWidth()*2;
		
		// Si nos pasamos de la parte de abajo de la pantalla, volvemos arriba
		if (y > Juego.GAME_HEIGHT)
			y = 0;
		
		
		// Finalmente actualizar posicion
		pos.setX( x );
		pos.setY( y );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////