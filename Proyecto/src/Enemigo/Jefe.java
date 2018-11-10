package Enemigo;

import java.util.LinkedList;

import Arma.ArmaBoss;
import Escudo.Escudo;
import Inteligencia.IABoss;
import Logica.Juego;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;
import visitor.ColDispEnemigo;
import visitor.ColEnemigo;
import visitor.Visitor;



public class Jefe extends Enemigo
{	
	public Jefe( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IABoss( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		this.rand			= Randomizador.create( );

		setSprite( new Sprite( "/GameSprites/Boss.PNG" ) );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 2000.0 + (100.0 * dificultad);
		this.puntaje		= (int) (200 + (10 * dificultad));

		setArma( new ArmaBoss(this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		arma.setMultCadencia( 2 );
		
		actualizarPosicion();
	}
	
	
	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
}