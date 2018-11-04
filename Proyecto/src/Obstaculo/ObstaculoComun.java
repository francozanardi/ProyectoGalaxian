package Obstaculo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Colisiones.ColObstaculo;
import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import PowerUp.PUCongelar;
import Utils.Posicion;
import Utils.Size;



public class ObstaculoComun extends Destructible
{
	
	public ObstaculoComun( Mapa map, Posicion posicionInicial )
	{
		this.map			= map;
		this.panel			= new JPanel( );
		this.vida			= 1000;
		this.escudo 		= new LinkedList<Escudo>( );
		this.pos			= posicionInicial.clone();
		this.tamano			= new Size(100, 20);
		this.colisionador	= new ColObstaculo( );
		this.puntaje		= 10;
		
		this.actualizarPanel(true, Color.orange);
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
	}
	
	
	
	public void morir( )
	{		
		PowerUp drop = new PUCongelar(map);
		drop.caer( pos.clone() );
	}
	
}