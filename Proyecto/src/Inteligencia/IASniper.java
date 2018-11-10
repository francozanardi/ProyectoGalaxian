package Inteligencia;

import Curva.CurvaSinusoidal;
import Enemigo.Enemigo;
import Logica.Juego;
import Utils.Posicion;
import Utils.Randomizador;



public class IASniper extends Inteligencia
{
	public IASniper( Enemigo me )
	{
		this.entidad	= me;

		this.curvaMovimiento = new CurvaSinusoidal( Randomizador.create().nextDouble(0.0, 1000.0), 100.0, 10.0, 0.5 );
	}


	
	public void mover( double msDesdeUltActualizacion )
	{
		Posicion	pos			= entidad.getPos(),
					movimiento	= curvaMovimiento.obtenerCambio( msDesdeUltActualizacion );
				
		double	x = pos.getX() + movimiento.getX(),
				y = pos.getY() + movimiento.getY();
		/*
		// Oscilan hacia los costados
		x = x + rand.nextInt(-1, 1);
		
		// Descender obligatoriamente
		y = y + 1; 
		*/
		
		// No permitir que se vaya por los costados de la pantalla
		if (x < entidad.getSprite().getBounds().getWidth()/2)  
			x = entidad.getSprite().getBounds().getWidth()/2;
		
		// Esto de dividirlo por 2 y multiplicarlo por 2 lo agregué porque el enemigo se iba al borde de la pantalla,
		// un lugar donde el jugador no puede disparar.
		else if (x > Juego.GAME_WIDTH - entidad.getSprite().getBounds().getWidth()*2)
			x = Juego.GAME_WIDTH - entidad.getSprite().getBounds().getWidth()*2;
		
		// Si nos pasamos de la parte de abajo de la pantalla, volvemos arriba
		if (y > Juego.GAME_HEIGHT)
			y = 0;
		
		// Finalmente actualizar posicion
		pos.setX( x );
		pos.setY( y );
	}
}