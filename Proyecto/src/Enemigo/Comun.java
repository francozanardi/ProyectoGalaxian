package Enemigo;

import java.util.LinkedList;

import Arma.ArmaDefaultEnemigo;
import Colisiones.ColDispEnemigo;
import Colisiones.Colisionador;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Colisiones.ColEnemigo;
import Escudo.Escudo;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;
import Inteligencia.IAComun;
import Logica.Juego;



public class Comun extends Enemigo
{
	public Comun( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IAComun( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		this.rand			= Randomizador.create( );

		cargarSprite( new Sprite( "/GameSprites/Comun.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 200.0 + (50.0 * dificultad);
		this.puntaje		= (int) (30 + (10 * dificultad));

		setArma( new ArmaDefaultEnemigo(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearDrop();
	}


	
	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}
}