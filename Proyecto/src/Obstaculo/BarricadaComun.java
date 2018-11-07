package Obstaculo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import PowerUp.PUMinigun;
import Utils.Posicion;
import Utils.Size;
import visitor.ColBarricada;



public class BarricadaComun extends Barricada
{
	public BarricadaComun( Mapa map, Posicion posicionInicial )
	{
		this.map			= map;
		this.panel			= new JPanel( );
		this.vida			= 300;
		this.escudo 		= new LinkedList<Escudo>( );
		this.pos			= posicionInicial.clone();
		this.tamano			= new Size(100, 20);
		this.colisionador	= new ColBarricada( );
		this.puntaje		= 10;
		
		this.actualizarPanel(true, Color.white);
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
	}

	
	
	public void morir( )
	{		
		PowerUp drop = new PUMinigun(map);
		drop.caer( pos.clone() );
	}
}