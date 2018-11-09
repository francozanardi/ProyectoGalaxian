package Obstaculo;

import java.util.LinkedList;

import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPObstaculo;
import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import Sprite.Sprite;
import PowerUp.PUArmaTriple;
import PowerUp.PUCongelar;
import Utils.Posicion;
import visitor.ColObstaculo;


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
		
		CreadorPowerUP creadorPowerUp = new CreadorPowerUPObstaculo(map, map.getDificultad());
		this.powerup 		= creadorPowerUp.crearPowerUP();
		
		setSprite( new Sprite( "/GameSprites/Destructible.PNG" ) );
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
		
		actualizarPosicion( );
	}
	
}