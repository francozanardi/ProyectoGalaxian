package Inteligencia;

import Enemigo.Enemigo;
import Grafica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class IAKamikaze extends Inteligencia
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int cont;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public IAKamikaze( Mapa map )
	{
		this.rand 	= new Randomizador( );
		this.map	= map;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( Enemigo me )
	{
		Posicion	pos			= me.getPos(),
					posPlayer	= map.coordenadasDelJugador( );
		
		double	x = pos.getX(),
				y = pos.getY(),
				px = posPlayer.getX(),
				py = posPlayer.getY();
		
		
		// Cada 3 actualizaciones del mapa, dirigirse hacia el jugador
		cont ++;
		if (cont == 3)
		{
			if (x > px)
				x -=3;
			else if (x < px)
				x +=3;
	
			cont = 0;
		}
		
		// Descender obligatoriamente
		y = y + 1; 
		
		// No permitir que se vaya por los costados de la pantalla
		if (x < 0)
			x = 0;
		else if (x > Juego.GAME_WIDTH)
			x = Juego.GAME_WIDTH;
		
		// Si nos pasamos de la parte de abajo de la pantalla, volvemos arriba, pero deben volver a aparecer en una coordenada X aleatoria
		if (y > Juego.GAME_HEIGHT)
		{
			x = rand.nextInt( Juego.GAME_WIDTH );
			y = 0;
		}
		
		
		// Finalmente actualizar posicion
		pos.setX( x );
		pos.setY( y );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////