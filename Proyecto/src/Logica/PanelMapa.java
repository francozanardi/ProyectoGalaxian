package Logica;

import java.awt.Component;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class PanelMapa extends JPanel
{
	private Collection<Component> entidadesJuego;
	
	
	
	public PanelMapa()
	{
		super();
		
		entidadesJuego = new HashSet<Component>( );
	}
	
	
	
	public void addEntity( Component c )
	{
		super.add( c );
		
		entidadesJuego.add( c );
	}
	
	public void removeEntity( Component c )
	{
		super.remove( c );
		
		entidadesJuego.remove( c );
	}
	
	public void removeAllEntities( )
	{
		for (Component c: entidadesJuego)
		{
			remove( c );
		}
		
		entidadesJuego.clear();
	}
}
