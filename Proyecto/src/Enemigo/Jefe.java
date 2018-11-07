package Enemigo;

import java.util.LinkedList;

import Arma.ArmaMinigun;
import Colisiones.ColDispEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColEnemigo;
import Escudo.Escudo;
import Inteligencia.IAComun;
import Logica.Juego;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;



public class Jefe extends Enemigo
{	
	public Jefe( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IAComun( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		this.rand			= Randomizador.create( );

		setSprite( new Sprite( "/GameSprites/Boss.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 2000.0 + (100.0 * dificultad);
		this.puntaje		= (int) (200 + (10 * dificultad));

		setArma( new ArmaMinigun(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
	}
	
	
	
	public void serChocado( Colisionador col )
	{
		col.afectar(this);
	}
}