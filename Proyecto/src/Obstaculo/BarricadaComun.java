package Obstaculo;

import java.util.LinkedList;

import DropPowerUP.CreadorPowerUP;
import DropPowerUP.CreadorPowerUPObstaculo;
import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import visitor.ColBarricada;

public class BarricadaComun extends Barricada
{
	public BarricadaComun( Mapa map, Posicion posicionInicial )
	{
		this.map			= map;
		this.vida			= 300;
		this.escudo 		= new LinkedList<Escudo>( );
		this.pos			= posicionInicial.clone();
		this.colisionador	= new ColBarricada( );
		this.puntaje		= 10;
		
		CreadorPowerUP creadorPowerUp = new CreadorPowerUPObstaculo(map, map.getDificultad());
		this.powerup 		= creadorPowerUp.crearPowerUP();
		
		setSprite( new Sprite( "/GameSprites/Destructible2.PNG" ) );
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
		
		actualizarPosicion( );
	}

}