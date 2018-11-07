package Obstaculo;

import java.util.LinkedList;

import Colisiones.ColObstaculo;
import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import Sprite.Sprite;
import PowerUp.PUCongelar;
import Utils.Posicion;



public class ObstaculoComun extends Destructible
{
	
	public ObstaculoComun( Mapa map, Posicion posicionInicial )
	{
		this.map			= map;
		this.vida			= 1000;
		this.escudo 		= new LinkedList<Escudo>( );
		this.pos			= posicionInicial.clone();
		this.colisionador	= new ColObstaculo( );
		this.puntaje		= 10;
		
		cargarSprite( new Sprite( "/GameSprites/Destructible.PNG" ) );
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
		
		actualizarPosicion( );
	}
	
	
	
	public void morir( )
	{		
		PowerUp drop = new PUCongelar(map);
		drop.caer( pos.clone() );
	}
	
}