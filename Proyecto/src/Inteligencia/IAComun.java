package Inteligencia;

import Curva.Curva;
import Curva.OscilacionComun;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class IAComun extends Inteligencia
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Curva curvaMovimiento;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public IAComun( Mapa map )
	{
		this.map	= map;
		this.rand	= new Randomizador( );
		
		this.curvaMovimiento = new OscilacionComun( rand.nextDouble(0.0, 1000.0) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void disparar( Enemigo me )
	{
		// 20% de chance de disparar
		if (rand.nextDouble() <= 0.5)
			me.getArma().lanzarDisparo( me );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void mover( Enemigo me, double msDesdeUltActualizacion )
	{
		Posicion	pos			= me.getPos(),
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
		if (x < me.getPanel().getBounds().getWidth()/2)  
			x = me.getPanel().getBounds().getWidth()/2;
		
		// Esto de dividirlo por 2 y multiplicarlo por 2 lo agregué porque el enemigo se iba al borde de la pantalla,
		// un lugar donde el jugador no puede disparar.
		else if (x > Juego.GAME_WIDTH - me.getPanel().getBounds().getWidth()*2)
			x = Juego.GAME_WIDTH - me.getPanel().getBounds().getWidth()*2;
		
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