package Obstaculo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Colisiones.ColisionadorObstaculo;
import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import PowerUp.PowerUpCongelar;
import PowerUp.PowerUpMinigun;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ObstaculoComun extends ObstaculoDestructible
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ObstaculoComun( Mapa map, Posicion posicionInicial )
	{
		this.map			= map;
		this.panel			= new JPanel( );
		this.vida			= 1000;
		this.escudo 		= new LinkedList<Escudo>( );
		this.pos			= posicionInicial.clone();
		this.tamano			= new Size(100, 20);
		this.colisionador	= new ColisionadorObstaculo( );
		
		this.actualizarPanel(true, Color.orange);
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void morir( )
	{
		System.out.println("Obstaculo comun destruido");
		
		PowerUp drop = new PowerUpCongelar(map);
		drop.caer( pos.clone() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////