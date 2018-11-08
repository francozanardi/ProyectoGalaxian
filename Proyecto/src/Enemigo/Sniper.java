package Enemigo;

import java.util.LinkedList;

import Arma.ArmaSniper;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Escudo.Escudo;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;
import visitor.ColDispEnemigo;
import visitor.ColEnemigo;
import visitor.Visitor;
import Inteligencia.IASniper;
import Logica.Juego;



public class Sniper extends Enemigo
{
	public Sniper( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IASniper( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		this.rand			= Randomizador.create( );

		setSprite( new Sprite( "/GameSprites/Sniper.PNG" ) );
		
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 300.0 + (75.0 * dificultad);
		this.puntaje		= (int) (60 + (12 * dificultad));

		setArma( new ArmaSniper(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		
		CreadorPowerUP drop = new CreadorPowerUPEnemigo(map, dificultad);
		powerUp = drop.crearPowerUP();
	}


	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
}