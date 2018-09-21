package Inteligencia;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class IAKamikaze extends Inteligencia
{	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public IAKamikaze( Mapa map )
	{
		this.rand 	= new Randomizador( );
		this.map	= map;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Disparo disparar( Enemigo me )
	{
		return null;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( Enemigo me, double msDesdeUltActualizacion )
	{
		final double	VELOCIDAD_HORIZONTAL	= 25.0,
						VELOCIDAD_VERTICAL		= 25.0;
		
		Posicion	pos			= me.getPos(),
					posPlayer	= map.coordenadasDelJugador( );
		
		double	x = pos.getX(),
				y = pos.getY(),
				px = posPlayer.getX(),
				dx = Math.abs( x - px ),
				mov = calcularVelocidad( VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion );
		
		// Si la distancia que debería moverse horizontalmente es mayor a la distancia horizontal con el jugador, ponerlos en la misma linea
		if (dx < mov)
			mov = dx;
				
		// Moverse hacia la posición del jugador
		if (x > px)
			x -= mov;
		else if (x < px)
			x += mov;
		
		// Descender obligatoriamente
		y += calcularVelocidad( VELOCIDAD_VERTICAL, msDesdeUltActualizacion ); 
		
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