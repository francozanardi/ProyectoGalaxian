package Grafica;

import javax.swing.JPanel;



public abstract class GUI
{
	protected JPanel canvas;
	
	
	
	public abstract void updateHP( double hp, double maxHP );
	
	public abstract void updateScore( int score );
	
	public abstract void updateFPS( double fps );
	
	public abstract void announce( String texto, int duracionMS );
	
	public abstract void createVisual( );
	
	public abstract void show( boolean toggle );
}
