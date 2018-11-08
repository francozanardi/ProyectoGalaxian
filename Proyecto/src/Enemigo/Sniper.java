package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import Arma.ArmaSniper;
import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPEnemigo;
import Escudo.Escudo;
import Mapa.Mapa;
import Sprite.Sprite;
import Sprite.SpriteEditor;
import Utils.Posicion;
import Utils.Randomizador;
import visitor.ColDispEnemigo;
import visitor.ColEnemigo;
import visitor.Visitor;
import Inteligencia.IAComun;
import Logica.Juego;



public class Sniper extends Enemigo
{
	public Sniper( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.ia				= new IAComun( this );
		this.dificultad		= dificultad;
		this.colisionador	= new ColEnemigo();
		this.rand			= Randomizador.create( );

		Sprite			spr		= new Sprite( "/GameSprites/Comun.PNG" );
		SpriteEditor	editor	= SpriteEditor.create();
		editor.tintura( spr, new Color(255, 0, 0) );
		setSprite( spr );
		
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.escudo			= new LinkedList<Escudo>( );
		
		this.vida			= 300.0 + (750.0 * dificultad);
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