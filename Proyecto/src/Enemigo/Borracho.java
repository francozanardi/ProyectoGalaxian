package Enemigo;

import java.util.LinkedList;

import Arma.ArmaDefaultEnemigo;
import Colisiones.ColDispEnemigo;
import Colisiones.ColKamikaze;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Escudo.Escudo;
import Inteligencia.IABorracho;
import Logica.Juego;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;



public class Borracho extends Kamikaze
{	
	public Borracho(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IABorracho( this );
		this.dificultad		= dificultad;
		this.rand			= Randomizador.create( );

		setSprite( new Sprite( "/GameSprites/Kamikaze.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 6) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (50 + (10 * dificultad));
		this.explosionDmg	= 100 + (10.0 * dificultad);
		this.vida			= 600.0 + (100.0 * dificultad);
		
		this.colisionador	= new ColKamikaze( explosionDmg );
		
		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearDrop();
		
		setArma( new ArmaDefaultEnemigo(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI ) );
	}
}