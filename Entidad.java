package Proyecto;

import javax.swing.JPanel;
import java.awt.Color;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected JPanel	panel;
	protected Posicion	pos;
	protected Size		tamano;
	protected Mapa		map;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public JPanel obtenerPanel( )
	{
		return panel;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizarPanel( boolean esOpaco, Color colorFondo )
	{
		actualizarPosicion( );
		panel.setLayout( null );
		panel.setOpaque( esOpaco );
		panel.setBackground( colorFondo );
		panel.setVisible( true );
	}
	
	public void actualizarPosicion()
	{
		panel.setBounds( pos.getX(), pos.getY(), tamano.getWidth(), tamano.getHeight() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void eliminar()
	{
		panel.setVisible(false);
		panel = null;
		pos = null;
		tamano = null;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Posicion getPos( )
	{
		return pos;
	}
		
	public void setPos( Posicion newPos )
	{
		pos.setX( newPos.getX() );
		pos.setY( newPos.getY() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Size getSize( )
	{
		return tamano;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setMapa( Mapa map )
	{
		this.map = map;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////