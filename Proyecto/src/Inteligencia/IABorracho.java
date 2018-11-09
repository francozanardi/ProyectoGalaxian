package Inteligencia;

import Curva.CurvaBorracho;
import Enemigo.Enemigo;
import Logica.Juego;
import Utils.Posicion;
import Utils.Randomizador;



public class IABorracho extends Inteligencia
{
	public IABorracho( Enemigo me )
	{
		this.entidad	= me;
		this.rand 		= Randomizador.create( );
		
		this.curvaMovimiento = new CurvaBorracho( rand.nextDouble(0.0, 100000.0) );
	}
	
	
	
	public void mover( double msDesdeUltActualizacion )
	{
		final double	VELOCIDAD_HORIZONTAL	= 7.5;
		
		Posicion	pos			= entidad.getPos(),
					posPlayer	= entidad.getMapa().getPlayerPos( ),
					movCurva	= curvaMovimiento.obtenerCambio( msDesdeUltActualizacion );
		
		double	x = pos.getX(),
				y = pos.getY() + movCurva.getY(),
				px = posPlayer.getX();
		
		// Moverse hacia la posición del jugador
		if (x > px)
			x -= calcularVelocidad( VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion );
		else if (x < px)
			x += calcularVelocidad( VELOCIDAD_HORIZONTAL, msDesdeUltActualizacion );
		
		// Agregar el movimiento extra de la parametrización
		x += movCurva.getX();
		
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
}