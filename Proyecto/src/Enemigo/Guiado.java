package Enemigo;

import java.util.LinkedList;

import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.ColKamikaze;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPGuiado;
import Escudo.Escudo;
import Inteligencia.IAKamikaze;
import Logica.Juego;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;



public class Guiado extends Kamikaze
{	
	public Guiado(Mapa map, double dificultad)
	{
		this.map			= map;
		this.ia				= new IAKamikaze( this );
		this.dificultad		= dificultad;
		this.rand			= Randomizador.create( );

		cargarSprite( new Sprite( "/GameSprites/Guiado.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (50 + (10.0 * dificultad));
		this.explosionDmg	= 100 + (12.5 * dificultad);
		this.vida			= 400 + (66.6 * dificultad);

		this.colisionador	= new ColKamikaze( explosionDmg );

		setArma( new ArmaSniper(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		CreadorPowerUP drop = new CreadorPowerUPGuiado(map, dificultad);
		powerUp = drop.crearDrop();
	}
}