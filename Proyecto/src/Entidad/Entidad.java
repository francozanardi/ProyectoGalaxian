package Entidad;

import javax.swing.JPanel;

import Inteligencia.Inteligencia;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import visitor.ColEntidad;
import visitor.Colisionador;
import visitor.Visitor;

import java.awt.Color;



public abstract class Entidad
{	
	protected JPanel		panel;
	protected Posicion		pos;
	protected Size			tamano;
	protected Mapa			map;
	protected Randomizador	rand;
	protected Colisionador	colisionador = new ColEntidad();
	protected Inteligencia	ia;



	public abstract void accept(Visitor col);
	
	public abstract void actualizar( double msDesdeUltActualizacion );

	
	public JPanel getPanel() {
		return panel;
	}
	
	public Inteligencia getIA()
	{
		return this.ia;
	}
	
	public void setIA(Inteligencia ia)
	{
		this.ia = ia;
	}
	
	public Posicion getPos( )
	{
		return pos;
	}
		
	public void setPos( Posicion newPos )
	{
		pos.setX( newPos.getX() );
		pos.setY( newPos.getY() );
	}
	
	public Size getSize( )
	{
		return tamano;
	}
		
	public Mapa getMapa( )
	{
		return this.map;
	}
	
	public void setMapa( Mapa map )
	{
		this.map = map;
	}


	
	protected void actualizarPanel( boolean esOpaco, Color colorFondo )
	{
		actualizarPosicion( );
		panel.setLayout( null );
		panel.setOpaque( esOpaco );
		panel.setBackground( colorFondo );
		panel.setVisible( true );
	}
	
	protected void actualizarPosicion()
	{
		panel.setBounds(
			(int) Math.round( pos.getX() ),
			(int) Math.round( pos.getY() ),
			tamano.getWidth(),
			tamano.getHeight()
		);
	}



	protected double conversionEnTiempo( double unidadesPorSegundo, double tiempoTranscurrido )
	{
		return tiempoTranscurrido * (unidadesPorSegundo / 1000.0);
	}


	
	public void remove()
	{
		map.removeEntity(this);
	}
	
	public void colisionar(Entidad e)
	{
		e.accept(colisionador);
	}
}