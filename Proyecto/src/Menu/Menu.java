package Menu;

import java.awt.event.ActionListener;

import javax.swing.JPanel;



public abstract class Menu
{
	protected final int	BOTON_WIDTH		= 200,
						BOTON_HEIGHT	= 40,
						DIST_BOTONES	= 10;
	
	
	
	protected JPanel		canvas;
	protected MediadorMenu	mediador;
	
	
	
	public abstract void crear( );
	
	public abstract void show( boolean toggle );
	
	public abstract void inicializar( );
	
	
	
	protected void nextMenu( Menu menu )
	{
		this.show( false );
		
		if (menu != null)
		{
			menu.inicializar();
			menu.show( true );
		}
	}
	
	
	
	protected final void setMediator( MediadorMenu mediador )
	{
		this.mediador = mediador;
	}
	
	
	
	protected MenuButton crearBoton( String texto, int x, int y, int w, int h, ActionListener oyente )
	{
		MenuButton b = new MenuButton( texto );
		b.setBounds( x, y, w, h );
		b.addActionListener( oyente );
		canvas.add( b );
		
		return b;
	}
}