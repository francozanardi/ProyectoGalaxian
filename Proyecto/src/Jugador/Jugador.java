package Jugador;

import java.util.LinkedList;
import java.util.List;

import Arma.*;
import Disparo.Disparo;
import Entidad.Personaje;
import Escudo.*;
import Logica.Juego;
import Sprite.Sprite;
import Utils.Posicion;
import visitor.ColDispJugador;
import visitor.ColJugador;
import visitor.Visitor;



public class Jugador extends Personaje
{	
	private int dir;
	private double velHorizontal = 40.0;


	
	public Jugador()
	{
		this.vida			= 1000;
		this.escudo			= new LinkedList<Escudo>( );
		this.colisionador	= new ColJugador();
		
		Sprite s = new Sprite( "/GameSprites/Personaje.PNG" );
		setSprite( s );
		
		this.pos = new Posicion((Juego.GAME_WIDTH / 2) - (tamano.getWidth() / 2), Juego.GAME_HEIGHT - tamano.getHeight() - 30);
		
		setArma( new ArmaComun(this, new ColDispJugador(), 0.5 * Math.PI) );
	}



	protected void morir( )
	{
		map.perder();
	}



	public void explosionKamikaze( double dmg )
	{
		dmg = utilizarEscudosExplosion( dmg );
		recibirDMG( dmg );
	}


	
	public void setPos( int posX )
	{
		pos.setX(posX);
	}

	public void setDireccion( int dir )
	{
		this.dir = dir;
	}


	
	public void accept(Visitor col)
	{
		col.visit(this);
	}


	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
		mover( msDesdeUltAct );
	}


	
	public void disparar( )
	{
		if (arma != null)
		{
			List<Disparo> lista = arma.lanzarDisparo();
			
			for (Disparo d : lista)
				map.addEntity( d );
		}
	}


	
	public void mover( double msDesdeUltActualizacion )
	{		
		double futuraPosX = pos.getX() + dir * conversionEnTiempo(velHorizontal, msDesdeUltActualizacion);
		
		if(futuraPosX > 5 && futuraPosX < Juego.GAME_WIDTH - tamano.getWidth()-10) {
			pos.setX(futuraPosX);
		}
		actualizarPosicion();
	}
}