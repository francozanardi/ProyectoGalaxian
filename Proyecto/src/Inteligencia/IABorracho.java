package Inteligencia;

import java.awt.Color;
import java.util.List;

import Arma.Arma;
import Curva.Curva;
import Curva.OscilacionBorracho;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class IABorracho extends Inteligencia
{	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Curva curvaMovimiento;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public IABorracho( Mapa map )
	{
		this.rand 	= new Randomizador( );
		this.map	= map;
		
		this.curvaMovimiento = new OscilacionBorracho( rand.nextDouble(0.0, 100000.0) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void disparar( Enemigo me )
	{
		List<Disparo> disparos = me.getArma().lanzarDisparo( me );
		
		// Añadir disparos al mapa
		for (Disparo d : disparos)
			map.addEntity(d);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( Enemigo me, double msDesdeUltActualizacion )
	{
		final double	VELOCIDAD_HORIZONTAL	= 7.5,
						VELOCIDAD_VERTICAL		= 30.0;
		
		Posicion	pos			= me.getPos(),
					posPlayer	= map.coordenadasDelJugador( ),
					movCurva	= curvaMovimiento.obtenerCambio( msDesdeUltActualizacion );
		
		double	x = pos.getX(),
				y = pos.getY(),
				px = posPlayer.getX();
		
		// Moverse hacia la posición del jugador
		if (x > px)
			x -= calcularVelocidad( VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion );
		else if (x < px)
			x += calcularVelocidad( VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion );
		
		// Agregar el movimiento extra de la parametrización
		x += movCurva.getX();
		
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