package Obstaculo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Colisiones.ColisionadorBarricada;
import Escudo.Escudo;
import Escudo.EscudoBasico;
import Mapa.Mapa;
import PowerUp.PowerUp;
import PowerUp.PowerUpMinigun;
import Utils.Posicion;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class BarricadaComun extends Barricada
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BarricadaComun( Mapa map, Posicion posicionInicial )
	{
		this.map			= map;
		this.panel			= new JPanel( );
		this.vida			= 300;
		this.escudo 		= new LinkedList<Escudo>( );
		this.pos			= posicionInicial.clone();
		this.tamano			= new Size(100, 20);
		this.colisionador	= new ColisionadorBarricada( );
		
		this.actualizarPanel(true, Color.white);
		
		this.addEscudo( new EscudoBasico(this, 2.0) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void morir( )
	{
		System.out.println("Barricada comun destruida");
		
		PowerUp drop = new PowerUpMinigun(map);
		drop.caer( pos.clone() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////