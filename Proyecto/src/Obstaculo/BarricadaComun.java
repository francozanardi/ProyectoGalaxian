package Obstaculo;

import java.util.LinkedList;

import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import Sprite.Sprite;
import PowerUp.PUMinigun;
import PowerUp.PUVelocidadMovimiento;
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
		
		setSprite( new Sprite( "/GameSprites/Destructible2.PNG" ) );
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
		
		actualizarPosicion( );
	}

	
	
	public void morir( )
	{		
		PowerUp drop = new PUVelocidadMovimiento(map);
		drop.caer( pos.clone() );
	}
}